package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private static String projectNameForCreatingProject = "Project created with automation";
    private static SelenideElement panelHeader = $("#welcometotestomatio");

    public static void isLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    public ProjectPage openReadme() {
        $(byLinkText("Readme")).click();
        return this;
    }

    public ProjectPage clickOnEdit() {
        $(byLinkText("Edit")).click();
        return this;
    }

    public static void shouldDisplayCorrectProjectNameInHeader() {
        $(".sticky-header h2").shouldHave(text(projectNameForCreatingProject));
    }

    public static void waitForWelcomePanelAndCloseIt() {
        $("#welcometotestomatio").shouldBe(visible);
        $("#welcometotestomatio").shouldHave(text("Welcome to Testomat.io"));
        $(".detail-view-header-wrapper .third-btn").click();

    }

    public static void createProject() {
        $(".common-btn-primary").click();
        $("[placeholder='My Project']").setValue(projectNameForCreatingProject);
        $("#project-create-btn .common-btn-primary").click();
    }
}
