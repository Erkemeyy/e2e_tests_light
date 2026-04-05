package io.testomat.e2e_tests_light;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class ReadmeIframeTest extends BaseTest{


    @Test
    @DisplayName("Update readme text in iframe")
    void updateReadmeIframeTest(){
        application.projectsPage.isLoaded()
                .searchProject(targetProjectName)
                .selectProject(targetProjectName);

        application.projectPage.openReadme().clickOnEdit();

        application.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("newTextTest")
                .clickOnUpdate()
                .clickOnEditReadme()
                .verifyReadmeContainsNewText("newTextTest")
                .clickOnCancel();

    }
}
