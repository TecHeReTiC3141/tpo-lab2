package org.example.math.series;

import org.example.math.common.FunctionType;

public class LnSeriesExpander extends SeriesExpander {
    public LnSeriesExpander() {
        super(FunctionType.LN);
    }

    @Override
    protected boolean checkToleranceHit(double x) {
        return Double.isFinite(x) && !Double.isNaN(x) && (x > 0);
    }

    @Override
    protected double calculateNthTerm(double x, int n) {
        double argument = (x - 1) / (x + 1);
        return (2 * Math.pow(argument, 2 * n + 1.0)) / (2 * n + 1);
    }
}
