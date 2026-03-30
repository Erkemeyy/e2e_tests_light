package io.testomat.e2e_tests_light;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e_tests_light.web.pages.ReadmePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class ReadmeIframeTest extends BaseTest{


    @Test
    @DisplayName("Update readme text in iframe")
    void updateReadmeIframeTest(){
        projectsPage.isLoaded()
                .searchProject(targetProjectName)
                .selectProject(targetProjectName);

        projectPage.openReadme().clickOnEdit();

        new ReadmePage().isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("TEST")
                .clickOnUpdate();

    }

    @Test
    @DisplayName("Readme test")
    void readmeTest(){

    }
}
