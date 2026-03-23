package org.example.integrational;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import org.example.math.FunctionSystemCalculator;
import org.example.math.MyMath;
import org.example.math.exception.ToleranceException;
import org.example.math.logarithmic.LnCalculator;
import org.example.math.logarithmic.LogCalculator;
import org.example.math.series.LnSeriesExpander;
import org.example.math.series.SinSeriesExpander;
import org.example.math.trigonometry.CosCalculator;
import org.example.math.trigonometry.CotCalculator;
import org.example.math.trigonometry.CscCalculator;
import org.example.math.trigonometry.SecCalculator;
import org.example.math.trigonometry.SinCalculator;
import org.example.math.trigonometry.TanCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class Layer4MockTest {
    FunctionSystemCalculator calculator;

    @Mock
    SinSeriesExpander sinSeriesExpander;
    @Mock
    LnSeriesExpander lnSeriesExpander;

    @InjectMocks
    SinCalculator sinCalculator;
    @InjectMocks
    LnCalculator lnCalculator;

    CosCalculator cosCalculator;
    SecCalculator secCalculator;
    TanCalculator tanCalculator;
    CotCalculator cotCalculator;
    CscCalculator cscCalculator;
    LogCalculator logCalculator;

    MyMath math;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cosCalculator = new CosCalculator(sinCalculator);
        tanCalculator = new TanCalculator(sinCalculator, cosCalculator);
        cotCalculator = new CotCalculator(sinCalculator, cosCalculator);
        secCalculator = new SecCalculator(cosCalculator);
        cscCalculator = new CscCalculator(sinCalculator);
        logCalculator = new LogCalculator(lnCalculator);

        when(sinSeriesExpander.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.sinValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in sinValues");
            }
            return PredefinedValues.sinValues.get(x);
        });
        when(lnSeriesExpander.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.lnValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in lnValues");
            }
            return PredefinedValues.lnValues.get(x);
        });

        when(sinSeriesExpander.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.sinValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in sinValues");
            }
            return PredefinedValues.sinValues.get(x);
        });
        when(lnSeriesExpander.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.lnValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in lnValues");
            }
            return PredefinedValues.lnValues.get(x);
        });


        math = new MyMath(
                sinCalculator,
                cosCalculator,
                tanCalculator,
                cotCalculator,
                secCalculator,
                cscCalculator,
                lnCalculator,
                logCalculator
        );

        this.calculator = new FunctionSystemCalculator(math);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/system/positive_values.csv", numLinesToSkip = 1)
    void positiveValuesTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        assertEquals(expected, calculator.calculate(x, convergenceEpsilon), resultEpsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data/system/negative_values.csv", numLinesToSkip = 1)
    void negativeValuesTest(double x, double expected, double resultEpsilon, double convergenceEpsilon) {
        assertEquals(expected, calculator.calculate(x, convergenceEpsilon), resultEpsilon);
    }
}
