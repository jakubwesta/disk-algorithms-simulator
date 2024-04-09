package org.simulator.scenario;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Scenario {
    @Getter @Setter private Generator generator;
    @Getter private final int requestsAmount;
    @Getter private final int maxSectorId;
    @Getter private final int initialHeadPosition;
    private ArrayList<Request> savedRequests;
    
    public Scenario(Generator generator, int requestsAmount, int maxSectorId, int initialHeadPosition) {
        this.generator = generator;
        this.requestsAmount = requestsAmount;
        this.maxSectorId = maxSectorId;
        this.initialHeadPosition = initialHeadPosition;
        rerollRequests();
    }
    
    public void rerollRequests() {
        savedRequests = generator.generateRequests(requestsAmount, maxSectorId);
    }
    
    public ArrayList<Request> getRequests() {
        return savedRequests;
    }

    public void printInformation() {
        System.out.printf("Generator name: %s%n", generator.getName());
        System.out.printf("Requests amount: %s%n", requestsAmount);
        System.out.printf("Max sector id: %s%n", maxSectorId);
        System.out.printf("Initial head position: %s%n", initialHeadPosition);
    }
}
