package io.testomat.e2e_tests_light;

import io.testomat.e2e_tests_light.web.pages.LoginPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTests extends BaseTest{

    private LoginPage loginPage = new LoginPage();
    private static ProjectsPage projectsPage = new ProjectsPage();
    private static SignInPage signInPage = new SignInPage();

    @BeforeAll
    static void openTestomatAndLogin(){
        signInPage.open();
        signInPage.loginUser(userName, password);
    }
    @Test
    public void userIsAbleToSignOutFromAccount(){
        projectsPage.signOutFromAccount();
        loginPage.isLoaded();
    }
}
