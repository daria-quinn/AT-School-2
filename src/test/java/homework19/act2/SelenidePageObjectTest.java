package homework19.act2;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelenidePageObjectTest {

    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        Selenide.open("https://the-internet.herokuapp.com/");
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void testValidLogin() {
        mainPage.openFormAuthentication();
        loginPage.verifyLoginPageTitle();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLogin();
        loginPage.verifySuccessMessage();
        loginPage.verifyLogoutButtonVisible();
        loginPage.clickLogout();
        loginPage.verifyLoginPageTitle();
    }

    @Test
    void testInvalidLogin() {
        mainPage.openFormAuthentication();
        loginPage.verifyElementalSeleniumLinkVisible();
        loginPage.setUsername("admin");
        loginPage.setPassword("1234");
        loginPage.clickLogin();
        loginPage.verifyInvalidUsernameMessage();
    }
}
