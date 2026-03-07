package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountTests {
    @Test
    public void userIsAbleToSignOutFromAccount(){
        open("https://app.testomat.io/");
        $("#content-desktop #user_email").setValue("ilinartem293@gmail.com");
        $("#content-desktop #user_password").setValue("ilinartem441$AQACourse");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();

        $(".common-flash-success").shouldBe(visible);
        $("#user-menu-button").click();
        $(".block ").click();
        $("#content-desktop h2").shouldHave(text("Sign In"));
    }
}
