package io.testomat.e2e_tests_light.selenium.web.pages;

import io.testomat.e2e_tests_light.selenium.web.common.Elements;import org.openqa.selenium.By;

import static io.testomat.e2e_tests_light.selenium.web.common.WebDriverProvider.driver;

public class LoginPageSelenium {


    public void login(String userName, String password) {
        Elements.find("#content-desktop #user_email")  .sendKeys(userName);
        Elements.find("#content-desktop #user_password").sendKeys(password);
        Elements.find("#content-desktop #user_remember_me").click();
        Elements.find("#content-desktop [name=commit]").click();
    }
}
