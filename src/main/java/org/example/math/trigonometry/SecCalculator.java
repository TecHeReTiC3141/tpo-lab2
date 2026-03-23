package org.example.math.trigonometry;

import org.example.math.common.FunctionCalculator;
import org.example.math.common.FunctionConstants;
import org.example.math.common.FunctionType;
import org.example.math.exception.ToleranceException;

public class SecCalculator extends FunctionCalculator {
    private final CosCalculator cosCalculator;

    public SecCalculator() {
        super(FunctionType.SEC);
        this.cosCalculator = new CosCalculator();
    }

    public SecCalculator(CosCalculator cosCalculator) {
        super(FunctionType.SEC);
        this.cosCalculator = cosCalculator;
    }

    @Override
    protected boolean checkToleranceHit(double x) {
        return Double.isFinite(x) && !Double.isNaN(x)
                && (Math.abs(cosCalculator.calculate(x)) > FunctionConstants.SINGULARITY_EPSILON);
    }

    @Override
    public double calculate(double x) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String.format(
                    "Argument x = %f is out of tolerance range for the '%s' function.",
                    x, getFunction().getName()));
        }

        double result = 1 / cosCalculator.calculate(x);
        writeCalculationResult(x, result);
        return result;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String.format(
                    "Argument x = %f is out of tolerance range for the '%s' function.",
                    x, getFunction().getName()));
        }

        if (epsilon < 0) {
            throw new IllegalArgumentException(
                    String.format("Cannot calculate a function with negative accuracy: epsilon = %f", epsilon));
        }

        double result = 1 / cosCalculator.calculate(x, epsilon);
        writeCalculationResult(x, result);
        return result;
    }
}
