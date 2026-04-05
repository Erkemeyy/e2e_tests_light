package io.testomat.e2e_tests_light.web.pages;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SignInPage {

    public SignInPage open(){
        Selenide.open("/users/sign_in");
        return  this;
    }

    public SignInPage loginUser(String email, String password ) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=commit]").click();
        return this;
    }

    public void isLoaded() {
        $("#content-desktop h2").shouldHave(text("Sign In"));
        $("#content-desktop h1").shouldBe(visible);
        $("#content-desktop #user_email").shouldBe(enabled);
        $("#content-desktop #user_password").shouldBe(enabled);
        $("#content-desktop #user_remember_me").shouldBe(enabled);
        $("#content-desktop [name=commit]").shouldBe(enabled);
        webdriver().shouldHave(url(baseUrl+"users/sign_in?info=You+must+be+logged+in+to+access+this+page+"));
    }
}
