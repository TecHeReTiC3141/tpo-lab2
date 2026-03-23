package org.example.math.series;

import org.example.math.common.FunctionType;

public class SinSeriesExpander extends SeriesExpander {
    public SinSeriesExpander() {
        super(FunctionType.SIN);
    }

    @Override
    protected boolean checkToleranceHit(double x) {
        return Double.isFinite(x) && !Double.isNaN(x);
    }

    @Override
    protected double calculateNthTerm(double x, int n) {
        // sin(x) = Σ((-1)^n * x^(2n+1) / (2n+1)!) for n=0 to ∞
        return (Math.pow(-1, n) * Math.pow(x, 2.0 * n + 1)) / factorialCalculator.calculate(2.0 * n + 1);
    }
}