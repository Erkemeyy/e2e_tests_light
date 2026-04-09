package io.testomat.e2e_tests_light;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light.common.Application;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    protected static Dotenv env = Dotenv.load();
    protected static String userName = env.get("EMAIL");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "test Project Artem";

    protected static Application application = new Application();

    @BeforeAll
    static void openTestomatAndLogin(){
        application.signInPage.open()
                .loginUser(userName, password);
        application.projectsPage.signInSuccess();
    }

    @AfterAll
    static void tearDown(){
        closeWebDriver();
    }

    static {
        Configuration.baseUrl = env.get("BASE_URL");
        Configuration.headless = true;

    }
}
