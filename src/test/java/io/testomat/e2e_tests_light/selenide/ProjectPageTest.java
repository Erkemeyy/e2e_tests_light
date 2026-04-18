package io.testomat.e2e_tests_light.selenide;

import org.junit.jupiter.api.Test;


public class ProjectPageTest extends BaseTest {

    @Test
    public void userIsAbleToCreateSuiteAndDeleteIt() {
        application.projectsPage.isLoaded()
                .searchProject(targetProjectName)
                .selectProject(targetProjectName);

        application.projectPage.isLoaded(targetProjectName)
                .createSuite()
                .verifyTestSuiteIsCreated()
                .verifyTestSuiteHasZeroTest(0);
        application.projectPage.openTestSuiteWindow()
                .verifyHeaderNameOfSuiteWindow()
                .openDropdown()
                .deleteTestSuite();

    }
}
