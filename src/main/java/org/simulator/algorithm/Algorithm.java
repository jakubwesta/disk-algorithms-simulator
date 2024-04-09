package org.simulator.algorithm;

import lombok.Getter;
import org.simulator.scenario.Request;
import org.simulator.scenario.Scenario;

import java.util.ArrayList;

public abstract class Algorithm {
    @Getter private final Scenario scenario;
    protected final int maxSectorId;
    protected int headPosition;
    @Getter protected int totalDistance;
    protected ArrayList<Request> requests;

    public Algorithm(Scenario scenario) {
        this.scenario = scenario;
        this.maxSectorId = scenario.getMaxSectorId();
        this.headPosition = scenario.getInitialHeadPosition();
        this.totalDistance = 0;
        this.requests = scenario.getRequests();
    }

    public void printPostRunInformation() {
        System.out.printf("Algorithm: %s%n", getName());
        System.out.printf("Total distance: %s%n", totalDistance);
    }

    public abstract void run();

    public abstract String getName();
}
