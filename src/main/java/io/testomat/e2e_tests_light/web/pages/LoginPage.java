package io.testomat.e2e_tests_light.web.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

public void isLoaded() {
        $("#content-desktop h2").shouldHave(text("Sign In"));
        $("#content-desktop .common-flash-wrapper").shouldBe(visible);
    }
}
