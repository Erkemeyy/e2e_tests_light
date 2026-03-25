package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProjectPage {

    private static String projectNameForCreatingProject = "Project created with automation";
    private static SelenideElement panelHeader = $("#welcometotestomatio");

    public static void isLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    public static void shouldDisplayCorrectProjectNameInHeader() {
        $(".sticky-header h2").shouldHave(text(projectNameForCreatingProject));
    }

    public static void waitForWelcomePanelAndCloseIt() {
        sleep(10000);
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
