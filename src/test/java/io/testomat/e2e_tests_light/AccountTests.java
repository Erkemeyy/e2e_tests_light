package io.testomat.e2e_tests_light;

import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountTests {
    @BeforeAll
    static void openTestomatAndLogin(){
        open(ProjectPageTests.baseUrl);
        new SignInPage().loginUser(ProjectPageTests.userName, ProjectPageTests.password);
    }
    @Test
    public void userIsAbleToSignOutFromAccount(){
        signOutFromAccount();
        waitLoginPage();
    }

    private static void waitLoginPage() {
        $("#content-desktop h2").shouldHave(text("Sign In"));
        $("#content-desktop .common-flash-wrapper").shouldBe(visible);
    }

    private static void signOutFromAccount() {
        $(".common-flash-success").shouldBe(visible);
        $("#user-menu-button").click();
        $(".block ").click();
    }
}
