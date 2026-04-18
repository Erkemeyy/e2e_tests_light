package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
