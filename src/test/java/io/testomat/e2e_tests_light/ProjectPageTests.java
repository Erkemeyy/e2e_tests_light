package io.testomat.e2e_tests_light;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({TextReportExtension.class})
public class ProjectPageTests extends BaseTest{


    @BeforeEach
    void openProjectsPage(){
        application.projectsPage.open();
        application.projectsPage.isLoaded();

    }

    //TODO: Delete method for project which created after automation

    @Test
    public void userCanFindProjectWithTests() {

        application.projectsPage.isLoaded()
                .searchProject(targetProjectName)
                .selectProject(targetProjectName);
    }

    @Test
    public void userCanCreateEmptyProject() {
        var initialProjectsCount = application.projectsPage.getProjectsCount();

        application.projectPage.createProject()
            .waitForWelcomePanelAndCloseIt()
            .shouldDisplayCorrectProjectNameInHeader();
        application.projectsPage.open()
            .compareNumberOfProjectsAfterCreatingOne(initialProjectsCount + 1);

    }

    @Test
    public void userCanSearchProjectWithZeroTestsAndReturnToFullList(){
        //search only one visible project from all projects
        application.projectsPage.searchProject(targetProjectName);

        var targetProject = application.projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        application.projectsPage.countOfTestsCasesShouldBeEqualTo(targetProject, 0)
                .open();

        application.projectsPage.totalCountOfProjectsIsVisible()
                .totalCountOfProjectsGraterThan(application.projectsPage.getProjectsCount() - 1);

    }
}
