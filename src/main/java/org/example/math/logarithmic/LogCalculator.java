package org.example.math.logarithmic;

import org.example.math.common.FunctionCalculator;
import org.example.math.common.FunctionType;
import org.example.math.exception.ToleranceException;

public class LogCalculator extends FunctionCalculator {
    private final LnCalculator lnCalculator;

    public LogCalculator() {
        super(FunctionType.LOG);
        this.lnCalculator = new LnCalculator();
    }

    public LogCalculator(LnCalculator lnCalculator) {
        super(FunctionType.LOG);
        this.lnCalculator = lnCalculator;
    }

    @Override
    protected boolean checkToleranceHit(double x) {
        return Double.isFinite(x) && !Double.isNaN(x) && (x > 0);
    }

    public double calculate(double x) {
        double result = lnCalculator.calculate(x);
        writeCalculationResult(x, result);
        return result;
    }

    @Override
    public double calculate(double x, double base) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String.format(
                    "Argument x = %f is out of tolerance range for the '%s' function.",
                    x, getFunction().getName()));
        }

        double result = lnCalculator.calculate(x) / lnCalculator.calculate(base);
        return result;
    }

    public double calculate(double x, double base, double epsilon) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String.format(
                    "Argument x = %f is out of tolerance range for the '%s' function.",
                    x, getFunction().getName()));
        }

        double result = lnCalculator.calculate(x, epsilon) / lnCalculator.calculate(base, epsilon);
        return result;
    }
}
