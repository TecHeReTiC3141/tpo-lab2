package org.example.math;

import org.example.math.logarithmic.LnCalculator;
import org.example.math.logarithmic.LogCalculator;
import org.example.math.trigonometry.CosCalculator;
import org.example.math.trigonometry.CotCalculator;
import org.example.math.trigonometry.CscCalculator;
import org.example.math.trigonometry.SecCalculator;
import org.example.math.trigonometry.SinCalculator;
import org.example.math.trigonometry.TanCalculator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyMath {
    private final SinCalculator sinCalculator;
    private final CosCalculator cosCalculator;

    private final TanCalculator tanCalculator;
    private final CotCalculator cotCalculator;

    private final SecCalculator secCalculator;
    private final CscCalculator cscCalculator;

    private final LnCalculator lnCalculator;
    private final LogCalculator logCalculator;

    public MyMath() {
        this.sinCalculator = new SinCalculator();
        this.cosCalculator = new CosCalculator();
        this.tanCalculator = new TanCalculator();
        this.cotCalculator = new CotCalculator();
        this.secCalculator = new SecCalculator();
        this.cscCalculator = new CscCalculator();
        this.lnCalculator = new LnCalculator();
        this.logCalculator = new LogCalculator();
    }

    public double sin(double x) {
        return sinCalculator.calculate(x);
    }

    public double sin(double x, double epsilon) {
        return sinCalculator.calculate(x, epsilon);
    }

    public double cos(double x) {
        return cosCalculator.calculate(x);
    }

    public double cos(double x, double epsilon) {
        return cosCalculator.calculate(x, epsilon);
    }

    public double tan(double x) {
        return tanCalculator.calculate(x);
    }

    public double tan(double x, double epsilon) {
        return tanCalculator.calculate(x, epsilon);
    }

    public double cot(double x) {
        return cotCalculator.calculate(x);
    }

    public double cot(double x, double epsilon) {
        return cotCalculator.calculate(x, epsilon);
    }

    public double sec(double x) {
        return secCalculator.calculate(x);
    }

    public double sec(double x, double epsilon) {
        return secCalculator.calculate(x, epsilon);
    }

    public double csc(double x) {
        return cscCalculator.calculate(x);
    }

    public double csc(double x, double epsilon) {
        return cscCalculator.calculate(x, epsilon);
    }

    public double ln(double x) {
        return lnCalculator.calculate(x);
    }

    public double ln(double x, double epsilon) {
        return lnCalculator.calculate(x, epsilon);
    }

    public double log(double x, int base) {
        return logCalculator.calculate(x, base);
    }

    public double log(double x, int base, double epsilon) {
        return logCalculator.calculate(x, base, epsilon);
    }
}
