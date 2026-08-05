package Homework16;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("===== Начинается сценарий: " + scenario.getName() + " =====");
    }

    @After
    public void afterScenario(Scenario scenario) {
        String status = scenario.isFailed() ? "ПРОВАЛЕН" : "ПРОЙДЕН";
        System.out.println("===== Сценарий \"" + scenario.getName() + "\" " + status + " =====");
    }
}
