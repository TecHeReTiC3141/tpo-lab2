package org.example.math.trigonometry;

import org.example.math.common.FunctionCalculator;
import org.example.math.common.FunctionConstants;
import org.example.math.common.FunctionType;
import org.example.math.exception.ToleranceException;

public class TanCalculator extends FunctionCalculator {
    private final SinCalculator sinCalculator;
    private final CosCalculator cosCalculator;

    public TanCalculator() {
        super(FunctionType.TAN);
        this.sinCalculator = new SinCalculator();
        this.cosCalculator = new CosCalculator();
    }

    public TanCalculator(SinCalculator sinCalculator, CosCalculator cosCalculator) {
        super(FunctionType.TAN);
        this.sinCalculator = sinCalculator;
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

        double result = sinCalculator.calculate(x) / cosCalculator.calculate(x);
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

        double result = sinCalculator.calculate(x, epsilon) / cosCalculator.calculate(x, epsilon);
        return result;
    }
}
