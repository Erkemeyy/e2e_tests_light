package io.testomat.e2e_tests_light.selenium.common;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light.selenium.web.common.WebDriverProvider.driver;

public class LoginTestomat implements BeforeAllCallback {

    protected static Dotenv env = Dotenv.load();
    protected static String userName = env.get("EMAIL");
    protected static String password = env.get("PASSWORD");

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver().get("https://app.testomat.io/");

        new io.testomat.e2e_tests_light.selenium.web.pages.LoginPageSelenium()
                .login(userName, password);


    }
}
