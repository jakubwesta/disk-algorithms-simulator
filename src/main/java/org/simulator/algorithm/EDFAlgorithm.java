package org.simulator.algorithm;

import org.simulator.scenario.RTRequest;
import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

import java.util.Comparator;

public class EDFAlgorithm extends Algorithm {
    public EDFAlgorithm(Scenario scenario) {
        super(scenario);
        this.requests.sort(Comparator.comparingInt(o -> ((RTRequest) o).getDeadline()));
    }

    @Override
    public void run() {
        while (!requests.isEmpty()) {
            Request nextRequest = requests.get(0);
            int nextSector = nextRequest.getSectorId();
            totalDistance += Math.abs(headPosition - nextSector);
            headPosition = nextSector;
            requests.remove(nextRequest);
        }
    }

    @Override
    public String getName() {
        return "EDF";
    }
}