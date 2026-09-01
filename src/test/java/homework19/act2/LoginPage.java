package homework19.act2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement heading = $("h2");
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement flashMessage = $("#flash");
    private final SelenideElement logoutButton = $("a[href='/logout']");
    private final SelenideElement elementalSeleniumLink = $("#content a[href='http://elementalselenium.com/']");

    public void verifyLoginPageTitle() {
        heading.shouldHave(Condition.text("Login Page"));
    }

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void verifySuccessMessage() {
        flashMessage.shouldHave(Condition.text("You logged into a secure area!"));
    }

    public void verifyInvalidUsernameMessage() {
        flashMessage.shouldHave(Condition.text("Your username is invalid!"));
    }

    public void verifyLogoutButtonVisible() {
        logoutButton.should(Condition.visible);
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void verifyElementalSeleniumLinkVisible() {
        elementalSeleniumLink.should(Condition.visible);
    }
}
