package io.testomat.e2e_tests_light;

import io.testomat.e2e_tests_light.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest{

    static String targetProjectName = "test Project Artem";
    private static ProjectsPage projectsPage = new ProjectsPage();
    private ProjectPage projectPage = new ProjectPage();
    private static SignInPage signInPage = new SignInPage();
    private static BaseTest baseTest = new BaseTest();


    @BeforeAll
    static void openTestomatAndLogin(){
        signInPage.open();
        signInPage.loginUser(userName, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage(){
        projectsPage.open();
        projectsPage.isLoaded();

    }

    //TODO: Delete method for project which created after automation

    @Test
    public void userCanFindProjectWithTests() {

        projectsPage.isLoaded();

        projectsPage.searchProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void userCanCreateEmptyProject() {
        var numberOfProjects = projectsPage.visibleProjectsOnProjectPage.size();

        projectPage.createProject();

        projectPage.waitForWelcomePanelAndCloseIt();

        projectPage.shouldDisplayCorrectProjectNameInHeader();

        projectsPage.open();

        projectsPage.compareNumberOfProjectsAfterCreatingOne(numberOfProjects);

    }

    @Test
    public void userCanSearchProjectWithZeroTestsAndReturnToFullList(){

        projectsPage.searchProject(targetProjectName);

        //search only one visible project from all projects
        var targetProject = projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        projectsPage.countOfTestsCasesShouldBeEqualTo(targetProject, 0);

        projectsPage.open();

        projectsPage.totalCountOfProjectsIsVisible();

        projectsPage.totalCountOfProjectsGraterThan(3);

    }
}
