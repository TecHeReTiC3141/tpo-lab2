package org.example.math;

import org.example.math.common.FunctionCalculator;
import org.example.math.common.FunctionConstants;
import org.example.math.common.FunctionType;
import org.example.math.exception.ToleranceException;

public class FunctionSystemCalculator extends FunctionCalculator {
    private final MyMath math;

    public FunctionSystemCalculator() {
        super(FunctionType.SYSTEM);
        this.math = new MyMath();
    }

    public FunctionSystemCalculator(MyMath math) {
        super(FunctionType.SYSTEM);
        this.math = math;
    }

    @Override
    protected boolean checkToleranceHit(double x) {
        if (x > 0) {
            return Double.isFinite(x) && !Double.isNaN(x) && x > 0;
        }
        return Double.isFinite(x) && !Double.isNaN(x) && (Math.abs(math.sin(x)) > FunctionConstants.SINGULARITY_EPSILON);
    }

    @Override
    public double calculate(double x) {
        if (!checkToleranceHit(x)) {
            return Double.NaN;
        }
        try {

            if (x > 0) {
                double result = (((((math.log(x, 10) + math.log(x, 2)) + math.log(x, 3))
                        - ((math.log(x, 5) + math.log(x, 10)) / (math.log(x, 10) + math.log(x, 2))))
                        - (((math.log(x, 2) / math.log(x, 5)) / math.log(x, 5)) + math.ln(x)))
                        + math.ln(x));
                writeCalculationResult(x, result);
                return result;
            }

            double result = ((Math.pow(Math.pow(Math.pow((((((((math.cos(x) / math.csc(x)) / math.csc(x)) / (math.cot(x) / math.cot(x)))
                    + ((math.sec(x) - math.csc(x)) * math.cos(x)))
                    + math.cos(x)) / (math.tan(x) / math.cos(x))) * math.sec(x)), 2), 3), 2))
                    + (((math.sin(x) * Math.pow(math.csc(x), 2)) * math.cot(x)) + math.cot(x)));
            writeCalculationResult(x, result);
            return result;
        } catch (ToleranceException error) {
            return Double.NaN;
        }

    }

    @Override
    public double calculate(double x, double epsilon) {
        try {
            if (!checkToleranceHit(x)) {
                return Double.NaN;
            }
            if (x > 0) {
                double result = (((((math.log(x, 10, epsilon) + math.log(x, 2, epsilon)) + math.log(x, 3, epsilon))
                        - ((math.log(x, 5, epsilon) + math.log(x, 10, epsilon)) / (math.log(x, 10, epsilon) + math.log(x, 2, epsilon))))
                        - (((math.log(x, 2, epsilon) / math.log(x, 5, epsilon)) / math.log(x, 5, epsilon)) + math.ln(x, epsilon)))
                        + math.ln(x, epsilon));
                writeCalculationResult(x, result);
                return result;
            }

            double result = ((Math.pow(Math.pow(Math.pow((((((((math.cos(x, epsilon) / math.csc(x, epsilon)) / math.csc(x, epsilon)) / (math.cot(x, epsilon) / math.cot(x, epsilon)))
                    + ((math.sec(x, epsilon) - math.csc(x, epsilon)) * math.cos(x, epsilon)))
                    + math.cos(x, epsilon)) / (math.tan(x, epsilon) / math.cos(x, epsilon))) * math.sec(x, epsilon)), 2), 3), 2))
                    + (((math.sin(x, epsilon) * Math.pow(math.csc(x, epsilon), 2)) * math.cot(x, epsilon)) + math.cot(x, epsilon)));
            writeCalculationResult(x, result);
            return result;
        } catch (ToleranceException error) {
            return Double.NaN;
        }
    }
}
