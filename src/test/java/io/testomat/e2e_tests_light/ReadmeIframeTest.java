package io.testomat.e2e_tests_light;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadmeIframeTest extends BaseTest{


    @Test
    @DisplayName("Update readme text in iframe")
    void updateReadmeIframeTest(){
        application.projectsPage.isLoaded()
                .searchProject(targetProjectName)
                .selectProject(targetProjectName);

        application.projectPage.isLoaded(targetProjectName)
                .openReadme()
                .clickOnEdit();

        application.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("newTextTest")
                .clickOnUpdate()
                .clickOnEditReadme()
                .verifyReadmeContainsNewText("newTextTest")
                .clickOnCancel();

    }
}
