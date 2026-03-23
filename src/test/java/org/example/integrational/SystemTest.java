package org.example.integrational;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.math.FunctionSystemCalculator;
import org.example.math.MyMath;
import org.example.math.exception.ToleranceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class SystemTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/system/positive_values.csv", numLinesToSkip = 1)
    void positiveValuesTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        FunctionSystemCalculator calculator = new FunctionSystemCalculator();
        assertEquals(expected, calculator.calculate(x, convergenceEpsilon), resultEpsilon);
        assertEquals(expected, calculator.calculate(x), resultEpsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/system/negative_values.csv", numLinesToSkip = 1)
    void negativeValuesTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        FunctionSystemCalculator calculator = new FunctionSystemCalculator();
        assertEquals(expected, calculator.calculate(x, convergenceEpsilon), resultEpsilon);
        assertEquals(expected, calculator.calculate(x), resultEpsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void calculateWithInvalidXShouldReturnNaN(double x) {
        FunctionSystemCalculator calculator = new FunctionSystemCalculator();

        assertEquals(Double.NaN, calculator.calculate(x));
        assertEquals(Double.NaN, calculator.calculate(x, 1e-3));
    }

    @Test
    void calculateWhenErrorOccursShouldReturnNaN() {
        // This test verifies that when an error occurs in the calculation,
        // the catch block returns Double.NaN

        // We need to create a scenario that causes an error
        // One way is to use a MyMath instance that throws an error

        MyMath errorProneMath = new MyMath() {
            @Override
            public double cos(double x) {
                throw new ToleranceException("Simulated error");
            }

            @Override
            public double cos(double x, double epsilon) {
                throw new ToleranceException("Simulated error");
            }
        };

        FunctionSystemCalculator errorCalculator = new FunctionSystemCalculator(errorProneMath);

        double result = errorCalculator.calculate(-1.0);
        assertEquals(Double.NaN, result);

        double resultWithEpsilon = errorCalculator.calculate(-1.0, 1e-10);
        assertEquals(Double.NaN, resultWithEpsilon);
    }
}
