package org.simulator.algorithm;

import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

import java.util.Comparator;

public class CSCANAlgorithm extends Algorithm {
    private final boolean goingRight;

    public CSCANAlgorithm(Scenario scenario, boolean goingRight) {
        super(scenario);
        this.goingRight = goingRight;
    }

    @Override
    public void run() {
        requests.sort(Comparator.comparingInt(Request::getSectorId));

        while (!requests.isEmpty()) {
            Request nextRequest = findNextRequest();

            if (nextRequest == null) {
                if (goingRight) {
                    totalDistance += maxSectorId - headPosition;
                    headPosition = 0;
                } else {
                    totalDistance += headPosition;
                    headPosition = maxSectorId;
                }
            } else {
                totalDistance += Math.abs(headPosition - nextRequest.getSectorId());
                headPosition = nextRequest.getSectorId();
                requests.remove(nextRequest);
            }
        }
    }

    private Request findNextRequest() {
        if (goingRight) {
            for (int i = 0; i < requests.size(); i++) {
                if (requests.get(i).getSectorId() >= headPosition) {
                    return requests.get(i);
                }
            }
        } else {
            for (int i = requests.size() - 1; i >= 0; i--) {
                if (requests.get(i).getSectorId() <= headPosition) {
                    return requests.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "C-SCAN, going right: %s".formatted(goingRight);
    }
}
