package io.testomat.e2e_tests_light;

import io.testomat.e2e_tests_light.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest{


    @BeforeEach
    void openProjectsPage(){
        application.projectsPage.open();
        application.projectsPage.isLoaded();

    }

    //TODO: Delete method for project which created after automation

    @Test
    public void userCanFindProjectWithTests() {

        application.projectsPage.isLoaded();

        application.projectsPage.searchProject(targetProjectName);

        application.projectsPage.selectProject(targetProjectName);

        application.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void userCanCreateEmptyProject() {
        var numberOfProjects = application.projectsPage.visibleProjectsOnProjectPage.size();

        application.projectPage.createProject();

        application.projectPage.waitForWelcomePanelAndCloseIt();

        application.projectPage.shouldDisplayCorrectProjectNameInHeader();

        application.projectsPage.open();

        application.projectsPage.compareNumberOfProjectsAfterCreatingOne(numberOfProjects);

    }

    @Test
    public void userCanSearchProjectWithZeroTestsAndReturnToFullList(){

        application.projectsPage.searchProject(targetProjectName);

        //search only one visible project from all projects
        var targetProject = application.projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        application.projectsPage.countOfTestsCasesShouldBeEqualTo(targetProject, 0);

        application.projectsPage.open();

        application.projectsPage.totalCountOfProjectsIsVisible();

        application.projectsPage.totalCountOfProjectsGraterThan(3);

    }
}
