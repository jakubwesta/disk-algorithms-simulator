package org.simulator.scenario;

public record Request(int sectorId, int arrivalTime) {
    public Request copy() {
        return new Request(sectorId, arrivalTime);
    }
}
