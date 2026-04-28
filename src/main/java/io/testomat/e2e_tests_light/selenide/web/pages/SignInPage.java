package io.testomat.e2e_tests_light.selenide.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class SignInPage {

    public SignInPage open() {
        Selenide.open("/users/sign_in");
        return this;
    }

    public SignInPage loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=commit]").click();
        return this;
    }

    public SignInPage isLoaded() {
        $("#content-desktop h2").shouldHave(text("Sign In"));
        $("#content-desktop h1").shouldBe(visible);
        return this;
    }

    public SignInPage contentIsClickable() {
        $("#content-desktop #user_email").shouldBe(enabled);
        $("#content-desktop #user_password").shouldBe(enabled);
        $("#content-desktop #user_remember_me").shouldBe(enabled);
        $("#content-desktop [name=commit]").shouldBe(enabled);
        return this;
    }

    public SignInPage verifyUrlOnSignInPage() {
        webdriver().shouldHave(urlContaining("users/sign_in"));
        return this;
    }
}
