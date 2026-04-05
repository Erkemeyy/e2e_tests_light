package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private static String projectNameForCreatingProject = "Project created with automation";
    private static SelenideElement panelHeader = $("#welcometotestomatio");

    public ProjectPage isLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
        return this;
    }

    public ProjectPage openReadme() {
        $(byLinkText("Readme")).click();
        return this;
    }

    public ProjectPage clickOnEdit() {
        $(byLinkText("Edit")).click();
        return this;
    }

    //recheck
    public ProjectPage shouldDisplayCorrectProjectNameInHeader() {
        $(".sticky-header h2").shouldHave(text(projectNameForCreatingProject));
        return this;
    }

    public ProjectPage waitForWelcomePanelAndCloseIt() {
        $(panelHeader).shouldBe(visible);
        $(panelHeader).shouldHave(text("Welcome to Testomat.io"));
        $(".detail-view-header-wrapper .third-btn").click();
        return this;

    }

    public ProjectPage createProject() {
        $(".common-btn-primary").click();
        $("[placeholder='My Project']").setValue(projectNameForCreatingProject);
        $("#project-create-btn .common-btn-primary").click();
        return this;
    }
}
