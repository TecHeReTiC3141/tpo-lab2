package org.example.unit.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.math.exception.ToleranceException;
import org.example.math.trigonometry.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class TrigonometryTest {
    private double BASE_EPSILON = 1e-3;

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/sin_values.csv", numLinesToSkip = 1)
    void sinCalculatorTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        SinCalculator calculator = new SinCalculator();
        double actual = calculator.calculate(x, convergenceEpsilon);

        assertEquals(expected, actual, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity"
    })
    void sinCalculatorToleranceTest(double x) {
        SinCalculator calculator = new SinCalculator();
        assertThrows(ToleranceException.class, () -> calculator.calculate(x));
        assertThrows(ToleranceException.class, () -> calculator.calculate(x, BASE_EPSILON));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when epsilon is negative for sin")
    void sinCalculateWithNegativeEpsilonShouldThrowIllegalArgumentException() {
        SinCalculator calculator = new SinCalculator();

        double x = Math.PI / 2;
        double negativeEpsilon = -0.001;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(x, negativeEpsilon),
                "Expected IllegalArgumentException for negative epsilon value");
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/cos_values.csv", numLinesToSkip = 1)
    void cosCalculatorTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        CosCalculator calculator = new CosCalculator();
        double actual = calculator.calculate(x, convergenceEpsilon);

        assertEquals(expected, actual, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity"
    })
    void cosCalculatorToleranceTest(double x) {
        CosCalculator calculator = new CosCalculator();
        assertThrows(ToleranceException.class, () -> calculator.calculate(x));
        assertThrows(ToleranceException.class, () -> calculator.calculate(x, BASE_EPSILON));
    }

    @Test
    @DisplayName("Cos should throw IllegalArgumentException when epsilon is negative")
    void cosCalculateWithNegativeEpsilonShouldThrowIllegalArgumentException() {
        CosCalculator calculator = new CosCalculator();

        double x = Math.PI / 2;
        double negativeEpsilon = -0.001;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(x, negativeEpsilon),
                "Expected IllegalArgumentException for negative epsilon value");
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/tan_values.csv", numLinesToSkip = 1)
    void tanCalculatorTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        TanCalculator calculator = new TanCalculator();
        double actual = calculator.calculate(x, convergenceEpsilon);
        double actualWithoutEpsilon = calculator.calculate(x);


        assertEquals(expected, actual, resultEpsilon);
        assertEquals(expected, actualWithoutEpsilon, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity",
            "1.5708",
            "-1.5708"
    })
    void tanCalculatorToleranceTest(double x) {
        TanCalculator calculator = new TanCalculator();
        assertThrows(ToleranceException.class, () -> calculator.calculate(x));
        assertThrows(ToleranceException.class, () -> calculator.calculate(x, BASE_EPSILON));
    }

    @Test
    @DisplayName("Tan should throw IllegalArgumentException when epsilon is negative")
    void tanCalculateWithNegativeEpsilonShouldThrowIllegalArgumentException() {
        TanCalculator calculator = new TanCalculator();

        double x = Math.PI;
        double negativeEpsilon = -0.001;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(x, negativeEpsilon),
                "Expected IllegalArgumentException for negative epsilon value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/cot_values.csv", numLinesToSkip = 1)
    void cotCalculatorTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        CotCalculator calculator = new CotCalculator();
        double actual = calculator.calculate(x, convergenceEpsilon);
        double actualWithoutEpsilon = calculator.calculate(x);

        assertEquals(expected, actual, resultEpsilon);
        assertEquals(expected, actualWithoutEpsilon, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity",
            "0.0",
            "3.1416"
    })
    void cotCalculatorToleranceTest(double x) {
        CotCalculator calculator = new CotCalculator();
        assertThrows(ToleranceException.class, () -> calculator.calculate(x));
        assertThrows(ToleranceException.class, () -> calculator.calculate(x, BASE_EPSILON));
    }

    @Test
    @DisplayName("Cot should throw IllegalArgumentException when epsilon is negative")
    void cotCalculateWithNegativeEpsilonShouldThrowIllegalArgumentException() {
        CotCalculator calculator = new CotCalculator();

        double x = Math.PI / 2;
        double negativeEpsilon = -0.001;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(x, negativeEpsilon),
                "Expected IllegalArgumentException for negative epsilon value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/sec_values.csv", numLinesToSkip = 1)
    void secCalculatorTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        SecCalculator calculator = new SecCalculator();
        double actual = calculator.calculate(x, convergenceEpsilon);
        double actualWithoutEpsilon = calculator.calculate(x);

        assertEquals(expected, actual, resultEpsilon);
        assertEquals(expected, actualWithoutEpsilon, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity",
            "1.5708",
            "-1.5708"
    })
    void secCalculatorToleranceTest(double x) {
        SecCalculator calculator = new SecCalculator();
        assertThrows(ToleranceException.class, () -> calculator.calculate(x));
        assertThrows(ToleranceException.class, () -> calculator.calculate(x, BASE_EPSILON));
    }

    @Test
    @DisplayName("Sec should throw IllegalArgumentException when epsilon is negative")
    void secCalculateWithNegativeEpsilonShouldThrowIllegalArgumentException() {
        SecCalculator calculator = new SecCalculator();

        double x = Math.PI;
        double negativeEpsilon = -0.001;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(x, negativeEpsilon),
                "Expected IllegalArgumentException for negative epsilon value");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/trigonometry/csc_values.csv", numLinesToSkip = 1)
    void cscCalculatorTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        CscCalculator calculator = new CscCalculator();
        double actual = calculator.calculate(x, convergenceEpsilon);
        double actualWithoutEpsilon = calculator.calculate(x);

        assertEquals(expected, actual, resultEpsilon);
        assertEquals(expected, actualWithoutEpsilon, resultEpsilon);
    }

    @ParameterizedTest
    @CsvSource({
            "NaN",
            "Infinity",
            "-Infinity",
            "0.0",
            "3.1416"
    })
    void cscCalculatorToleranceTest(double x) {
        CscCalculator calculator = new CscCalculator();
        assertThrows(ToleranceException.class, () -> calculator.calculate(x));
        assertThrows(ToleranceException.class, () -> calculator.calculate(x, BASE_EPSILON));
    }

    @Test
    @DisplayName("Csc should throw IllegalArgumentException when epsilon is negative")
    void cscCalculateWithNegativeEpsilonShouldThrowIllegalArgumentException() {
        CscCalculator calculator = new CscCalculator();

        double x = Math.PI / 2;
        double negativeEpsilon = -0.001;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(x, negativeEpsilon),
                "Expected IllegalArgumentException for negative epsilon value");
    }
}
