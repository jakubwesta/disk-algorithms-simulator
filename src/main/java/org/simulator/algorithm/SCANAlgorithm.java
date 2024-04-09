package org.simulator.algorithm;

import org.simulator.scenario.Scenario;

public class SCANAlgorithm extends Algorithm {
    private boolean goingRight;

    public SCANAlgorithm(Scenario scenario, boolean startsGoingRight) {
        super(scenario);
        this.goingRight = startsGoingRight;
    }

    @Override
    public void run() {
        ;
    }

    @Override
    public String getName() {
        return "SCAN";
    }
}
