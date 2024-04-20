package org.simulator.algorithm;

import org.simulator.scenario.RTRequest;
import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

import java.util.Comparator;

public class FDSCANAlgorithm extends Algorithm {
    private boolean goingRight;
    private int totalTime;

    public FDSCANAlgorithm(Scenario scenario) {
        super(scenario);
        this.requests.sort(Comparator.comparingInt(o -> ((RTRequest) o).getDeadline()));
        this.goingRight = true;
        this.totalTime = 0;
    }

    @Override
    public void run() {
        for (Request request : requests) {
            if (isFeasible((RTRequest) request)) {
                goingRight = request.getSectorId() > headPosition;
                break;
            }
        }

        while (!requests.isEmpty()) {
            if (goingRight) {
                for (int i = headPosition; i <= maxSectorId; i++) {
                    serviceRequest(i);
                }
                for (int i = headPosition - 1; i >= 0; i--) {
                    serviceRequest(i);
                }
            } else {
                for (int i = headPosition; i >= 0; i--) {
                    serviceRequest(i);
                }
                for (int i = headPosition + 1; i <= maxSectorId; i++) {
                    serviceRequest(i);
                }
            }
        }
    }

    private boolean isFeasible(RTRequest request) {
        int accessTime = Math.abs(request.getSectorId() - headPosition);
        return request.getDeadline() >= totalTime + accessTime;
    }

    private void serviceRequest(int sectorId) {
        Request request = findRequest(sectorId);
        if (request != null) {
            totalDistance += Math.abs(sectorId - headPosition);
            totalTime++;
            headPosition = sectorId;
            requests.remove(request);
        }
    }

    private Request findRequest(int sectorId) {
        for (Request request : requests) {
            if (request.getSectorId() == sectorId) {
                return request;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "FD-SCAN";
    }
}