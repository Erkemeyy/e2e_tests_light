package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.Test;

public class AccountTests extends BaseTest{

    @Test
    public void userIsAbleToSignOutFromAccount(){
        application.projectsPage.signOutFromAccount();
        application.signInPage.isLoaded()
                .contentIsClickable()
                .verifyUrlOnSignInPage();
    }
}
