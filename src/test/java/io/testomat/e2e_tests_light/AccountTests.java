package io.testomat.e2e_tests_light;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class AccountTests extends BaseTest{

    @Test
    public void userIsAbleToSignOutFromAccount(){
        application.projectsPage.signOutFromAccount();
        application.signInPage.isLoaded();
    }
}
