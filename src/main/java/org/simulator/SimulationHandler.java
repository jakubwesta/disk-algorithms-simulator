package org.simulator;

import org.simulator.algorithm.Algorithm;
import org.simulator.algorithm.FCFSAlgorithm;
import org.simulator.scenario.Scenario;
import org.simulator.scenario.StaticGenerator;

import java.util.ArrayList;
import java.util.List;

public class SimulationHandler {
    private ArrayList<Scenario> scenarios = new ArrayList<>(List.of(
            new Scenario(
                    new StaticGenerator(
                            199,
                            new ArrayList<>(List.of(176, 79, 34, 60, 92, 11, 41, 114))
                    ),
                    8,
                    199,
                    50
            )
    ));

    public SimulationHandler() {

    }

    public void runTests() {
        for (Scenario scenario : scenarios) {
            runSimulation(new FCFSAlgorithm(scenario));
        }
    }

    private void runSimulation(Algorithm algorithm) {
        algorithm.run();
        System.out.println("=".repeat(100));
        System.out.println("Results:");
        algorithm.getScenario().printInformation();
        algorithm.printPostRunInformation();
        System.out.println("=".repeat(100));
    }
}