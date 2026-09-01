package homework19.act1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeEach
    void setUp() {
        Selenide.open("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void testValidLogin() {
        // 1. Кликнуть по ссылке Form Authentication
        $(("a[href='/login']")).click();

        // 2. Проверить заголовок Login Page
        $("h2").shouldHave(Condition.text("Login Page"));

        // 3. Установить Username
        $("#username").setValue("tomsmith");

        // 4. Установить Password
        $("#password").setValue("SuperSecretPassword!");

        // 5. Нажать кнопку Login
        $("button[type='submit']").click();

        // 6. Проверить сообщение об успешном логине
        $("#flash").shouldHave(Condition.text("You logged into a secure area!"));

        // 7. Проверить наличие кнопки Logout
        $("a[href='/logout']").should(Condition.visible);

        // 8. Нажать Logout
        $("a[href='/logout']").click();

        // 9. Проверить что вернулись на страницу Login
        $("h2").shouldHave(Condition.text("Login Page"));
    }

    @Test
    void testInvalidLogin() {
        // 1. Кликнуть по ссылке Form Authentication
        $(("a[href='/login']")).click();

        // 2. Проверить наличие ссылки Elemental Selenium
        $("#content a[href='http://elementalselenium.com/']").should(Condition.visible);

        // 3. Установить Username
        $("#username").setValue("admin");

        // 4. Установить Password
        $("#password").setValue("1234");

        // 5. Нажать кнопку Login
        $("button[type='submit']").click();

        // 6. Проверить сообщение об ошибке
        $("#flash").shouldHave(Condition.text("Your username is invalid!"));
    }
}
