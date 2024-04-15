package org.simulator.algorithm;

import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

public class SSTFAlgorithm extends Algorithm {
    public SSTFAlgorithm(Scenario scenario) {
        super(scenario);
    }

    @Override
    public void run() {
        while (!requests.isEmpty()) {
            Request nearestRequest = findNearest();
            int nextSector = nearestRequest.sectorId();
            totalDistance += Math.abs(headPosition - nextSector);
            headPosition = nextSector;
            requests.remove(nearestRequest);
        }
    }

    private Request findNearest() {
        Request nearest = null;
        int nearestDistance = maxSectorId;
        for (Request request : requests) {
            int sectorIdToCheck = request.sectorId();
            if (Math.abs(headPosition - sectorIdToCheck) < nearestDistance || nearest == null) {
                nearestDistance = Math.abs(headPosition - sectorIdToCheck);
                nearest = request;
            }
        }
        return nearest;
    }

    @Override
    public String getName() {
        return "SSTF";
    }
}
