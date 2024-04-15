package org.simulator.algorithm;

import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

import java.util.Comparator;

public class SCANAlgorithm extends Algorithm {
    private final boolean startedGoingRight;
    private boolean goingRight;

    public SCANAlgorithm(Scenario scenario, boolean startsGoingRight) {
        super(scenario);
        this.startedGoingRight = startsGoingRight;
        this.goingRight = startsGoingRight;
    }

    @Override
    public void run() {
        requests.sort(Comparator.comparingInt(Request::sectorId));

        while (!requests.isEmpty()) {
            Request nextRequest = findNextRequest();

            if (nextRequest == null) {
                if (goingRight) {
                    totalDistance += maxSectorId - headPosition;
                    headPosition = maxSectorId;
                } else {
                    totalDistance += headPosition;
                    headPosition = 0;
                }
                goingRight = !goingRight;
            } else {
                totalDistance += Math.abs(headPosition - nextRequest.sectorId());
                headPosition = nextRequest.sectorId();
                requests.remove(nextRequest);
            }
        }
    }

    private Request findNextRequest() {
        if (goingRight) {
            for (int i = 0; i < requests.size(); i++) {
                if (requests.get(i).sectorId() >= headPosition) {
                    return requests.get(i);
                }
            }
        } else {
            for (int i = requests.size() - 1; i >= 0; i--) {
                if (requests.get(i).sectorId() <= headPosition) {
                    return requests.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "SCAN, started going right: %s".formatted(startedGoingRight);
    }
}
