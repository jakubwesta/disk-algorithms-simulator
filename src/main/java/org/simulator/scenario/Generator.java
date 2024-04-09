package org.simulator.scenario;

import java.util.ArrayList;

public interface Generator {
    ArrayList<Request> generateRequests(int amount, int maxSectorId);

    String getName();
}
