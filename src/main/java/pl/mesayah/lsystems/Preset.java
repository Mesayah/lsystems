package pl.mesayah.lsystems;

import java.util.Set;

public class Preset {

    private final String name;

    private final double angleIncrement;

    private final LSystem system;

    private final int n;

    public String getName() {

        return name;
    }

    public double getAngleIncrement() {

        return angleIncrement;
    }

    public LSystem getSystem() {

        return system;
    }

    public int getN() {

        return n;
    }

    public Preset(String name, double angleIncrement, LSystem system, int n) {

        this.name = name;
        this.angleIncrement = angleIncrement;
        this.system = system;
        this.n = n;

    }

    @Override
    public String toString() {

        return name;
    }
}
