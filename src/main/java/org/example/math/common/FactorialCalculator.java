package org.example.math.common;

import org.example.math.exception.ToleranceException;

public class FactorialCalculator extends FunctionCalculator {
    public FactorialCalculator() {
        super(FunctionType.FACTORIAL);
    }

    @Override
    protected boolean checkToleranceHit(double x) {
        return Double.isFinite(x) && !Double.isNaN(x) && (x >= 0);
    }

    @Override
    public double calculate(double x) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String
                    .format("Argument x = %f is out of tolerance range for the '%s' function.", x, getFunction().getName()));
        }
        return x == 0 ? 1.0 : x * calculate(x - 1);
    }
}
