package org.simulator.algorithm;

import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

public class FCFSAlgorithm extends Algorithm {
    public FCFSAlgorithm(Scenario scenario) {
        super(scenario);
    }

    @Override
    public void run() {
        for (Request request : requests) {
            int nextSector = request.getSectorId();
            totalDistance += Math.abs(headPosition - nextSector);
            headPosition = nextSector;
        }
    }

    @Override
    public String getName() {
        return "FCFS";
    }
}
