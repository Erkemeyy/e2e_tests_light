package io.testomat.e2e_tests_light;

import io.testomat.e2e_tests_light.web.pages.LoginPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTests extends BaseTest{

    @BeforeAll
    static void openTestomatAndLogin(){
        application.signInPage.open();
        application.signInPage.loginUser(userName, password);
    }
    @Test
    public void userIsAbleToSignOutFromAccount(){
        application.projectsPage.signOutFromAccount();
        application.loginPage.isLoaded();
    }
}
