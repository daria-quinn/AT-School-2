package homework19.act3;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("===== Starting scenario: " + scenario.getName() + " =====");
    }

    @After
    public void afterScenario(Scenario scenario) {
        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        System.out.println("===== Scenario \"" + scenario.getName() + "\" " + status + " =====");
        Selenide.closeWebDriver();
    }
}
