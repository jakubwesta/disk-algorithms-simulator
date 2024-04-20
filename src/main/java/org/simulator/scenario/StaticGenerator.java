package org.simulator.scenario;

import java.util.ArrayList;

public class StaticGenerator implements Generator {
    private final int amount;
    private final int maxSectorId;
    private final ArrayList<Request> requests;

    public StaticGenerator(int maxSectorId, ArrayList<Integer> requestsInts) {
        this.amount = requestsInts.size();
        this.maxSectorId = maxSectorId;
        this.requests = new ArrayList<>();
        for (Integer integer : requestsInts) {
            requests.add(new Request(integer));
        }
    }

    public StaticGenerator(int amount, int maxSectorId, ArrayList<Request> requests) {
        this.amount = amount;
        this.maxSectorId = maxSectorId;
        this.requests = requests;
    }

    @Override
    public ArrayList<Request> generateRequests(int amount, int maxSectorId) {
        if (amount != this.amount || maxSectorId != this.maxSectorId) {
            throw new IllegalArgumentException();
        }
        return requests;
    }

    @Override
    public String getName() {
        return "Custom generator";
    }
}
