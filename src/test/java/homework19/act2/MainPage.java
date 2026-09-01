package homework19.act2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement formAuthLink = $("a[href='/login']");

    public void openFormAuthentication() {
        formAuthLink.click();
    }
}
