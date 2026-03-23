package org.example.integrational;

import java.util.HashMap;
import java.util.Map;

public class PredefinedValues {
    public static final Map<Double, Double> lnValues = new HashMap<>();

    static {
        lnValues.put(0.05, -2.9957);
        lnValues.put(0.1, -2.3026);
        lnValues.put(0.5, -0.6931);
        lnValues.put(1.5, 0.4055);
        lnValues.put(2.0, 0.6931);
        lnValues.put(2.5, 0.9163);
        lnValues.put(3.0, 1.0986);
        lnValues.put(4.0, 1.3863);
        lnValues.put(5.0, 1.6094);
        lnValues.put(9.0, 2.1972);
        lnValues.put(10.0, 2.3026);
        lnValues.put(12.5, 2.5257);
        lnValues.put(20.0, 2.9957);
    }

    public static final Map<Double, Map<Double, Double>> logValues = new HashMap<>();

    static {
        logValues.put(0.05, Map.of(
                2.0, -4.3219,
                3.0, -2.7268,
                5.0, -1.8614,
                10.0, -1.3010
        ));
        logValues.put(0.1, Map.of(
                2.0, -3.3219,
                3.0, -2.0959,
                5.0, -1.4307,
                10.0, -1.0000
        ));
        logValues.put(0.5, Map.of(
                2.0, -1.0000,
                3.0, -0.6309,
                5.0, -0.4307,
                10.0, -0.3010
        ));
        logValues.put(1.5, Map.of(
                2.0, 0.5850,
                3.0, 0.3691,
                5.0, 0.2519,
                10.0, 0.1761
        ));
        logValues.put(2.0, Map.of(
                2.0, 1.0000,
                3.0, 0.6309,
                5.0, 0.4307,
                10.0, 0.3010
        ));
        logValues.put(2.5, Map.of(
                2.0, 1.3219,
                3.0, 0.8340,
                5.0, 0.5693,
                10.0, 0.3979
        ));
        logValues.put(3.0, Map.of(
                2.0, 1.5850,
                3.0, 1.0000,
                5.0, 0.6826,
                10.0, 0.4771
        ));
        logValues.put(4.0, Map.of(
                2.0, 2.0000,
                3.0, 1.2619,
                5.0, 0.8614,
                10.0, 0.6021
        ));
        logValues.put(5.0, Map.of(
                2.0, 2.3219,
                3.0, 1.4650,
                5.0, 1.0000,
                10.0, 0.6990
        ));
        logValues.put(9.0, Map.of(
                2.0, 3.1699,
                3.0, 2.0000,
                5.0, 1.3652,
                10.0, 0.9542
        ));
        logValues.put(12.5, Map.of(
                2.0, 3.6439,
                3.0, 2.2990,
                5.0, 1.5693,
                10.0, 1.0969
        ));
        logValues.put(20.0, Map.of(
                2.0, 4.3219,
                3.0, 2.7268,
                5.0, 1.8614,
                10.0, 1.3010
        ));
    }

    public static final Map<Double, Double> cosValues = new HashMap<>();

    static {
        cosValues.put(-0.5, 0.8776);
        cosValues.put(-1.0, 0.5403);
        cosValues.put(-1.2, 0.3624);
        cosValues.put(-1.25, 0.3153);
        cosValues.put(-2.0, -0.4161);
        cosValues.put(-2.27, -0.6436);
        cosValues.put(-2.3, -0.6663);
        cosValues.put(-2.32, -0.6811);
        cosValues.put(-2.35, -0.7027);
        cosValues.put(-3.87, -0.7462);
        cosValues.put(-3.89, -0.7327);
        cosValues.put(-3.95, -0.6907);
        cosValues.put(-4.4, -0.3073);
        cosValues.put(-5.2, 0.4685);
        cosValues.put(-5.35, 0.5953);
        cosValues.put(-5.57, 0.7563);
        cosValues.put(-5.62, 0.7880);
        cosValues.put(-5.69, 0.8292);
        cosValues.put(-5.87, 0.9158);
    }

    public static final Map<Double, Double> sinValues = new HashMap<>();

    static {
        sinValues.put(-0.5, -0.4794);
        sinValues.put(-1.0, -0.8415);
        sinValues.put(-1.2, -0.9320);
        sinValues.put(-1.25, -0.9490);
        sinValues.put(-2.0, -0.9093);
        sinValues.put(-2.27, -0.7653);
        sinValues.put(-2.3, -0.7457);
        sinValues.put(-2.32, -0.7322);
        sinValues.put(-2.35, -0.7115);
        sinValues.put(-3.87, 0.6657);
        sinValues.put(-3.89, 0.6805);
        sinValues.put(-3.95, 0.7232);
        sinValues.put(-4.4, 0.9516);
        sinValues.put(-5.2, 0.8835);
        sinValues.put(-5.35, 0.8035);
        sinValues.put(-5.57, 0.6542);
        sinValues.put(-5.62, 0.6156);
        sinValues.put(-5.69, 0.5590);
        sinValues.put(-5.87, 0.4015);

        sinValues.put(0.05, 0.0499);
        sinValues.put(0.1, 0.0998);
        sinValues.put(0.5, 0.4794);
        sinValues.put(1.5, 0.9975);
        sinValues.put(2.0, 0.9093);
        sinValues.put(2.5, 0.5985);
        sinValues.put(3.0, 0.1411);
        sinValues.put(4.0, -0.7568);
        sinValues.put(5.0, -0.9589);
        sinValues.put(9.0, 0.4121);
        sinValues.put(12.5, 0.4999);
        sinValues.put(20.0, 0.9129);
    }

    public static final Map<Double, Double> tanValues = new HashMap<>();

    static {
        tanValues.put(-0.5, -0.5463);
        tanValues.put(-1.0, -1.5574);
        tanValues.put(-1.2, -2.5722);
        tanValues.put(-1.25, -3.0096);
        tanValues.put(-2.0, 2.1850);
        tanValues.put(-2.27, 1.1892);
        tanValues.put(-2.3, 1.1192);
        tanValues.put(-2.32, 1.0751);
        tanValues.put(-2.35, 1.0125);
        tanValues.put(-3.87, -0.8921);
        tanValues.put(-3.89, -0.9286);
        tanValues.put(-3.95, -1.0471);
        tanValues.put(-4.4, -3.0963);
        tanValues.put(-5.2, 1.8856);
        tanValues.put(-5.35, 1.3498);
        tanValues.put(-5.57, 0.8651);
        tanValues.put(-5.62, 0.7812);
        tanValues.put(-5.69, 0.6742);
        tanValues.put(-5.87, 0.4384);
    }

    public static final Map<Double, Double> cotValues = new HashMap<>();

    static {
        cotValues.put(-0.5, -1.8305);
        cotValues.put(-1.0, -0.6421);
        cotValues.put(-1.2, -0.3888);
        cotValues.put(-1.25, -0.3323);
        cotValues.put(-2.0, 0.4577);
        cotValues.put(-2.27, 0.8409);
        cotValues.put(-2.3, 0.8935);
        cotValues.put(-2.32, 0.9301);
        cotValues.put(-2.35, 0.9877);
        cotValues.put(-3.87, -1.1210);
        cotValues.put(-3.89, -1.0769);
        cotValues.put(-3.95, -0.9550);
        cotValues.put(-4.4, -0.3230);
        cotValues.put(-5.2, 0.5303);
        cotValues.put(-5.35, 0.7408);
        cotValues.put(-5.57, 1.1560);
        cotValues.put(-5.62, 1.2800);
        cotValues.put(-5.69, 1.4833);
        cotValues.put(-5.87, 2.2809);
    }

    public static final Map<Double, Double> secValues = new HashMap<>();

    static {
        secValues.put(-0.5, 1.1395);
        secValues.put(-1.0, 1.8508);
        secValues.put(-1.2, 2.7597);
        secValues.put(-1.25, 3.1714);
        secValues.put(-2.0, -2.4030);
        secValues.put(-2.27, -1.5537);
        secValues.put(-2.3, -1.5009);
        secValues.put(-2.32, -1.4683);
        secValues.put(-2.35, -1.4231);
        secValues.put(-3.87, -1.3401);
        secValues.put(-3.89, -1.3647);
        secValues.put(-3.95, -1.4479);
        secValues.put(-4.4, -3.2538);
        secValues.put(-5.2, 2.1344);
        secValues.put(-5.35, 1.6799);
        secValues.put(-5.57, 1.3223);
        secValues.put(-5.62, 1.2689);
        secValues.put(-5.69, 1.2060);
        secValues.put(-5.87, 1.0919);
    }

    public static final Map<Double, Double> cscValues = new HashMap<>();

    static {
        cscValues.put(-0.5, -2.0858);
        cscValues.put(-1.0, -1.1884);
        cscValues.put(-1.2, -1.0729);
        cscValues.put(-1.25, -1.0538);
        cscValues.put(-2.27, -1.3066);
        cscValues.put(-2.3, -1.3410);
        cscValues.put(-2.32, -1.3657);
        cscValues.put(-2.35, -1.4055);
        cscValues.put(-2.0, -1.0998);
        cscValues.put(-3.87, 1.5022);
        cscValues.put(-3.89, 1.4696);
        cscValues.put(-3.95, 1.3828);
        cscValues.put(-4.4, 1.0509);
        cscValues.put(-5.2, 1.1319);
        cscValues.put(-5.35, 1.2445);
        cscValues.put(-5.57, 1.5285);
        cscValues.put(-5.62, 1.6244);
        cscValues.put(-5.69, 1.7889);
        cscValues.put(-5.87, 2.4905);
    }
}
