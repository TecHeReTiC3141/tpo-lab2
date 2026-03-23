package org.example.math.series;

import org.example.math.common.FactorialCalculator;
import org.example.math.common.FunctionCalculator;
import org.example.math.common.FunctionConstants;
import org.example.math.common.FunctionType;
import org.example.math.exception.ToleranceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SeriesExpander extends FunctionCalculator {
    private static final int MAX_TERMS = 1000;

    protected final FactorialCalculator factorialCalculator;

    protected SeriesExpander(FunctionType type) {
        super(type);
        this.factorialCalculator = new FactorialCalculator();
    }

    protected abstract double calculateNthTerm(double x, int n);

    @Override
    public double calculate(double x) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String.format(
                    "Argument x = %f is out of tolerance range for the '%s' function.",
                    x, getFunction().getName()));
        }

        double result = 0;
        double delta = 0;
        double previousTerm = 0;
        double nextTerm = 0;
        for (int i = 0; i <= MAX_TERMS; i++) {
            nextTerm = calculateNthTerm(x, i);
            result = result + nextTerm;
            delta = Math.abs(nextTerm - previousTerm);
            if (delta <= FunctionConstants.CONVERGENCE_EPSILON) {
                break;
            }
            previousTerm = nextTerm;
        }

        return result;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String.format(
                    "Argument x = %f is out of tolerance range for the '%s' function.",
                    x, getFunction().getName()));
        }

        double result = 0;
        double delta = 0;
        double previousResult = 0;
        for (int i = 0; i <= MAX_TERMS; i++) {
            double nextTerm = calculateNthTerm(x, i);
            result = result + nextTerm;
            delta = Math.abs(result - previousResult);
            if (delta <= epsilon) {
                break;
            }
            previousResult = result;
        }

        return result;
    }
}
