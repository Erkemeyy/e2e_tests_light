package io.testomat.e2e_tests_light;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_light.utils.StringParser.parseIntegerFromString;

public class ProjectPageTests extends BaseTest{

    static String baseUrl = env.get("BASE_URL");
    static String userName = env.get("PROJECT_USERNAME");
    static String password = env.get("PASSWORD");
    String targetProjectName = "test Project Artem";

    @BeforeAll
    static void openTestomatAndLogin(){
        open(baseUrl);
        loginUser(userName, password);
    }

    @BeforeEach
    void openHomePage(){
        open(baseUrl);
    }

    @Test
    public void userCanFindProjectWithTests() {


        searchProject(targetProjectName);

        selectProject(targetProjectName);

        sleep(10000);

        waitForProjectPageIsLoaded(targetProjectName);
    }

    @Test
    void userCanCreateEmptyProject() {

        createProject();
        waitForWelcomePanelAndCloseIt();

    }


    @Test
    public void anotherTest(){

        searchProject(targetProjectName);

        //search only one visible project from all projects
        SelenideElement targetProject = countOfProjectsShouldBeEqualTo(1).first();

        countOfTestsCasesShouldBeEqualTo(targetProject, 0);

    }

    @NotNull
    private static ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(1));
    }

    private static void countOfTestsCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);
    }

    private static void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    private static void selectProject(String targetProjectName) {
        $(Selectors.byText(targetProjectName)).click();
    }

    private void searchProject(String targetProjectName) {
        $("#search").setValue(this.targetProjectName);
    }

    private static void waitForWelcomePanelAndCloseIt() {
        sleep(10000);
        $("#welcometotestomatio").shouldBe(visible);
        $("#welcometotestomatio").shouldHave(text("Welcome to Testomat.io"));
        $(".detail-view-header-wrapper .third-btn").click();

    }

    private static void createProject() {
        $(".common-btn-primary").click();
        $("[placeholder='My Project']").setValue("Project created with automation");
        $("#project-create-btn .common-btn-primary").click();
    }

    public static void loginUser(String email, String password ) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }
}
