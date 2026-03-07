package io.testomat.e2e_tests_light;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {
    @Test
    public void userCanFindProjectWithTests() {
        open("https://app.testomat.io/");

        $("#content-desktop #user_email").setValue("ilinartem293@gmail.com");
        $("#content-desktop #user_password").setValue("ilinartem441$AQACourse");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();

        $(".common-flash-success").shouldBe(visible);
        $("#search").setValue("test Project Artem");
        $(Selectors.byText("test Project Artem")).click();
        sleep(10000);
        $("h2").shouldHave(text("test Project Artem"));


    }
}
