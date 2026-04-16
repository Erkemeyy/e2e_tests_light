package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectPageTest extends BaseTest {

    @Test
    @Order(1)
    public void userIsAbleToCreateSuite() {
        application.projectsPage.isLoaded()
                .searchProject(targetProjectName)
                .selectProject(targetProjectName);

        application.projectPage.isLoaded(targetProjectName)
                .createSuite()
                .verifyTestSuiteIsCreated()
                .verifyTestSuiteHasZeroTest(0);

    }

    @Test
    @Order(2)
    public void userIsAbleToDeleteSuite() {
        application.projectPage.openTestSuiteWindow()
                .verifyHeaderNameOfSuiteWindow()
                .openDropdown()
                .deleteTestSuit();
    }
}
