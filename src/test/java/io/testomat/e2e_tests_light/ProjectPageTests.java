package io.testomat.e2e_tests_light;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.pages.SignInPage;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_light.utils.StringParser.parseIntegerFromString;

public class ProjectPageTests extends BaseTest{

    static String baseUrl = env.get("BASE_URL");
    static String userName = env.get("EMAIL");
    static String password = env.get("PASSWORD");
    static String targetProjectName = "test Project Artem";
    static String projectNameForCreatingProject = "Project created with automation";
    ElementsCollection visibleProjectsOnProjectPage = $$("#grid ul li").filter(visible);
    private static ProjectsPage projectsPage = new ProjectsPage();
    private ProjectPage projectPage = new ProjectPage();
    private static SignInPage signInPage = new SignInPage();


    @BeforeAll
    static void openTestomatAndLogin(){
        signInPage.open();
        signInPage.loginUser(userName, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage(){
        projectsPage.open();

    }

    //TODO: Delete method for project which created after automation
//    @AfterAll
//    static void deleteCreatedProject(){
//        searchProject(projectNameForCreatingProject);
//        $("[title='Project created with automation']").click();
//        $(".sticky-header h2").shouldHave(text(projectNameForCreatingProject));
//        $("[aria-describedby='ember23-popper']").click();
//        $(".red-btn").shouldBe(visible).click();
//
//
//    }

    @Test
    public void userCanFindProjectWithTests() {

//        projectsPage.isLoaded();

        projectsPage.searchProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void userCanCreateEmptyProject() {
        int numberOfProjects = visibleProjectsOnProjectPage.size();

        createProject();

        waitForWelcomePanelAndCloseIt();

        shouldDisplayCorrectProjectNameInHeader();

        projectsPage.open();

        compareNumberOfProjectsAfterCreatingOne(numberOfProjects);

    }

    @Test
    public void userCanSearchProjectWithZeroTestsAndReturnToFullList(){

        ProjectsPage.searchProject(targetProjectName);

        //search only one visible project from all projects
        SelenideElement targetProject = countOfProjectsShouldBeEqualTo(1).first();

        countOfTestsCasesShouldBeEqualTo(targetProject, 0);

        projectsPage.open();

        totalCountOfProjectsGraterThan(3);

    }

    @NotNull
    private ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return visibleProjectsOnProjectPage.shouldHave(size(expectedSize));
    }

    private void compareNumberOfProjectsAfterCreatingOne(int numberOfProjects) {
        visibleProjectsOnProjectPage.shouldHave(CollectionCondition.size(numberOfProjects + 1));
    }

    private void totalCountOfProjectsGraterThan(int expectedTotalCount) {
        int numberOfProjects = visibleProjectsOnProjectPage.size();
        Assertions.assertTrue(numberOfProjects > expectedTotalCount);
    }

    private static void shouldDisplayCorrectProjectNameInHeader() {
        $(".sticky-header h2").shouldHave(text(projectNameForCreatingProject));
    }

    private static void countOfTestsCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);
    }

    private static void waitForWelcomePanelAndCloseIt() {
        sleep(10000);
        $("#welcometotestomatio").shouldBe(visible);
        $("#welcometotestomatio").shouldHave(text("Welcome to Testomat.io"));
        $(".detail-view-header-wrapper .third-btn").click();

    }

    private static void createProject() {
        $(".common-btn-primary").click();
        $("[placeholder='My Project']").setValue(projectNameForCreatingProject);
        $("#project-create-btn .common-btn-primary").click();
    }
}
