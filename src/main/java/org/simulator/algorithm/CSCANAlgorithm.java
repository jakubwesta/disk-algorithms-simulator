package org.simulator.algorithm;

import org.simulator.scenario.Scenario;

public class CSCANAlgorithm extends Algorithm {
    private final boolean goingRight;

    public CSCANAlgorithm(Scenario scenario, boolean goingRight) {
        super(scenario);
        this.goingRight = goingRight;
    }

    @Override
    public void run() {
        ;
    }

    @Override
    public String getName() {
        return "C-SCAN";
    }
}
