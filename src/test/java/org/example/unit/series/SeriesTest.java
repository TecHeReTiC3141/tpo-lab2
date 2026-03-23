package org.example.unit.series;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.math.common.FactorialCalculator;
import org.example.math.exception.ToleranceException;
import org.example.math.series.LnSeriesExpander;
import org.example.math.series.SinSeriesExpander;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SeriesTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/sin_values.csv", numLinesToSkip = 1)
    void sinSeriesTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        SinSeriesExpander expander = new SinSeriesExpander();
        double actual = expander.calculate(x, convergenceEpsilon);

        assertEquals(expected, actual, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity"
    })
    void sinSeriesToleranceTest(double x) {
        SinSeriesExpander expander = new SinSeriesExpander();
        assertThrows(ToleranceException.class, () -> expander.calculate(x, 1e-3));
        assertThrows(ToleranceException.class, () -> expander.calculate(x));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/logarithmic/ln_values.csv", numLinesToSkip = 1)
    void lnSeriesTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        LnSeriesExpander expander = new LnSeriesExpander();
        double actual = expander.calculate(x, convergenceEpsilon);

        assertEquals(expected, actual, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity",
            "-1.0"
    })
    void lnSeriesToleranceTest(double x) {
        LnSeriesExpander expander = new LnSeriesExpander();
        assertThrows(ToleranceException.class, () -> expander.calculate(x));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800"
    })
    void calculateFactorialForPositiveIntegers(double x, double expected) {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assertEquals(expected, factorialCalculator.calculate(x));
        assertEquals(expected, factorialCalculator.calculate(x, 1e-3));
    }

    @Test
    void calculateFactorialForLargeNumber() {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        double actual = factorialCalculator.calculate(12);
        assertEquals(479001600.0, actual);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -2, -5, -10, -100})
    void calculateFactorialForNegativeNumbersShouldThrowToleranceException(double x) {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        assertThrows(ToleranceException.class, () -> factorialCalculator.calculate(x));
        assertThrows(ToleranceException.class, () -> factorialCalculator.calculate(x, 1e-3));
    }
}