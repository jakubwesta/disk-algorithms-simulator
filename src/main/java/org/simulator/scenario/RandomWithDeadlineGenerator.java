package org.simulator.scenario;

import java.util.ArrayList;
import java.util.Random;

public class RandomWithDeadlineGenerator implements Generator {
    private final Random random = new Random();

    @Override
    public ArrayList<Request> generateRequests(int amount, int maxSectorId) {
        ArrayList<Request> requests = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            int sectorId = random.nextInt(0, maxSectorId);
            int deadline = random.nextInt(1, amount);
            requests.add(new RTRequest(sectorId, deadline));
        }
        return requests;
    }

    @Override
    public String getName() {
        return "Random with deadline generator";
    }
}
