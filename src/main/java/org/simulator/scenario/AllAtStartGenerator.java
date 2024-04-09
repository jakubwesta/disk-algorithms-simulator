package org.simulator.scenario;

import java.util.ArrayList;
import java.util.Random;

public class AllAtStartGenerator implements Generator {
    private final Random random = new Random();

    @Override
    public ArrayList<Request> generateRequests(int amount, int maxSectorId) {
        ArrayList<Request> requests = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            requests.add(new Request(random.nextInt(0, maxSectorId), 0));
        }
        return requests;
    }

    @Override
    public String getName() {
        return "All requests arrive at time = 0";
    }
}
