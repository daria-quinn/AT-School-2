package homework19.act3;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {

    @Given("User opens the internet homepage")
    public void userOpensTheInternetHomepage() {
        open("https://the-internet.herokuapp.com/");
    }

    @When("User clicks on Form Authentication link")
    public void userClicksOnFormAuthenticationLink() {
        $("a[href='/login']").click();
    }

    @Then("Login page title should be displayed")
    public void loginPageTitleShouldBeDisplayed() {
        $("h2").shouldHave(Condition.text("Login Page"));
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        $("#username").setValue(username);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        $("#password").setValue(password);
    }

    @And("User clicks Login button")
    public void userClicksLoginButton() {
        $("button[type='submit']").click();
    }

    @Then("Success message {string} should be displayed")
    public void successMessageShouldBeDisplayed(String message) {
        $("#flash").shouldHave(Condition.text(message));
    }

    @And("Logout button should be visible")
    public void logoutButtonShouldBeVisible() {
        $("a[href='/logout']").should(Condition.visible);
    }

    @When("User clicks Logout button")
    public void userClicksLogoutButton() {
        $("a[href='/logout']").click();
    }

    @Then("Elemental Selenium link should be visible")
    public void elementalSeleniumLinkShouldBeVisible() {
        $("#content a[href='http://elementalselenium.com/']").should(Condition.visible);
    }

    @Then("Error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        $("#flash").shouldHave(Condition.text(message));
    }
}
