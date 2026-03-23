package org.example.integrational;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.example.math.FunctionSystemCalculator;
import org.example.math.exception.ToleranceException;
import org.example.math.MyMath;
import org.example.math.logarithmic.LnCalculator;
import org.example.math.logarithmic.LogCalculator;
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

class Layer1MockTest {
    FunctionSystemCalculator calculator;

    @Mock
    SinCalculator sinCalculator;
    @Mock
    CosCalculator cosCalculator;
    @Mock
    TanCalculator tanCalculator;
    @Mock
    CotCalculator cotCalculator;
    @Mock
    SecCalculator secCalculator;
    @Mock
    CscCalculator cscCalculator;
    @Mock
    LnCalculator lnCalculator;
    @Mock
    LogCalculator logCalculator;

    @InjectMocks
    MyMath math;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(sinCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.sinValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in sinValues");
            }
            return PredefinedValues.sinValues.get(x);
        });
        when(cosCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.cosValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in cosValues");
            }
            return PredefinedValues.cosValues.get(x);
        });
        when(tanCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.tanValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in tanValues");
            }
            return PredefinedValues.tanValues.get(x);
        });
        when(cotCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.cotValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in cotValues");
            }
            return PredefinedValues.cotValues.get(x);
        });
        when(secCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.secValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in secValues");
            }
            return PredefinedValues.secValues.get(x);
        });
        when(cscCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.cscValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in cscValues");
            }
            return PredefinedValues.cscValues.get(x);
        });
        when(lnCalculator.calculate(anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.lnValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in lnValues");
            }
            return PredefinedValues.lnValues.get(x);
        });

        when(sinCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.sinValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in sinValues");
            }
            return PredefinedValues.sinValues.get(x);
        });
        when(cosCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.cosValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in cosValues");
            }
            return PredefinedValues.cosValues.get(x);
        });
        when(tanCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.tanValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in tanValues");
            }
            return PredefinedValues.tanValues.get(x);
        });
        when(cotCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.cotValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in cotValues");
            }
            return PredefinedValues.cotValues.get(x);
        });
        when(secCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.secValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in secValues");
            }
            return PredefinedValues.secValues.get(x);
        });
        when(cscCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.cscValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in cscValues");
            }
            return PredefinedValues.cscValues.get(x);
        });
        when(lnCalculator.calculate(anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            if (!PredefinedValues.lnValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in lnValues");
            }
            return PredefinedValues.lnValues.get(x);
        });
        when(logCalculator.calculate(anyDouble(), anyDouble(), anyDouble())).thenAnswer(invocation -> {
            Double x = invocation.getArgument(0);
            Double base = invocation.getArgument(1);
            if (!PredefinedValues.logValues.containsKey(x)) {
                throw new ToleranceException("Value for x=" + x + " not found in logValues");
            }
            Map<Double, Double> baseMap = PredefinedValues.logValues.get(x);
            if (!baseMap.containsKey(base)) {
                throw new ToleranceException("Value for x=" + x + ", base=" + base + " not found in logValues");
            }
            return baseMap.get(base);
        });

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
