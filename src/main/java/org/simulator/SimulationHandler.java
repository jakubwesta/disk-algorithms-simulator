package org.simulator;

import org.simulator.algorithm.*;
import org.simulator.scenario.RandomGenerator;
import org.simulator.scenario.RandomWithDeadlineGenerator;
import org.simulator.scenario.Scenario;
import org.simulator.scenario.StaticGenerator;

import java.util.ArrayList;
import java.util.List;

public class SimulationHandler {
    private final ArrayList<Scenario> scenarios = new ArrayList<>(List.of(
            new Scenario(
                    new StaticGenerator(
                            199,
                            new ArrayList<>(List.of(176, 79, 34, 60, 92, 11, 41, 114))
                    ),
                    8,
                    199,
                    50
            ),
            new Scenario(
                    new RandomGenerator(),
                    100,
                    199,
                    50
            ),
            new Scenario(
                    new RandomGenerator(),
                    800,
                    199,
                    50
            ),
            new Scenario(
                    new RandomGenerator(),
                    5000,
                    199,
                    50
            )
    ));
    private final ArrayList<Scenario> realTimeScenarios = new ArrayList<>(List.of(
            new Scenario(
                    new RandomWithDeadlineGenerator(),
                    100,
                    199,
                    50
            )
    ));

    public SimulationHandler() {

    }

    public void runTests() {
        System.out.println("\n\n\nNon real time algorithms:\n\n\n");

        for (Scenario scenario : scenarios) {
            runSimulation(new FCFSAlgorithm(scenario));
            runSimulation(new SSTFAlgorithm(scenario));

            runSimulation(new SCANAlgorithm(scenario, true));
            runSimulation(new SCANAlgorithm(scenario, false));

            runSimulation(new CSCANAlgorithm(scenario, true));
            runSimulation(new CSCANAlgorithm(scenario, false));

            System.out.println("\n\n");
        }

        System.out.println("\n\n\nReal time algorithms:\n\n\n");

        for (Scenario scenario : realTimeScenarios) {
            runSimulation(new EDFAlgorithm(scenario));
            runSimulation(new FDSCANAlgorithm(scenario));
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
