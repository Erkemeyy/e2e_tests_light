package io.testomat.e2e_tests_light;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static Dotenv env = Dotenv.load();
    protected static String userName = env.get("EMAIL");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "test Project Artem";
    protected static final ProjectsPage projectsPage = new ProjectsPage();
    protected final ProjectPage projectPage = new ProjectPage();
    protected static final SignInPage signInPage = new SignInPage();

    @BeforeAll
    static void openTestomatAndLogin(){
        signInPage.open();
        signInPage.loginUser(userName, password);
        projectsPage.signInSuccess();
    }

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
