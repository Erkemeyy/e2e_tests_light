package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light.utils.StringParser;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.System.currentTimeMillis;

public class ProjectPage {

    private static String projectNameForCreatingProject = "Project created with automation";
    private String testSuiteName = "Test suite " + currentTimeMillis();
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

    public ProjectPage createSuite() {
        $("#item-title").setValue(testSuiteName);
        $(".ml-16 .mt-1 .primary-btn").click();
        return this;

    }

    public ProjectPage verifyTestSuiteIsCreated() {
        $(byText(testSuiteName)).shouldBe(visible);
        $(byText(testSuiteName)).shouldHave(text(testSuiteName));
        return this;
    }

    public ProjectPage verifyTestSuiteHasZeroTest(int expectedCount) {
        $(".gap-x-2 small").shouldBe(visible);
        String text = $(".gap-x-2 small").text();
        int countOfTestsAfterCreationSuite = StringParser.parseIntegerFromString(text);
        Assertions.assertEquals(expectedCount, countOfTestsAfterCreationSuite);
        return this;
    }

    public ProjectPage openTestSuiteWindow() {
        $(byText(testSuiteName)).click();
        return this;
    }

    public ProjectPage verifyHeaderNameOfSuiteWindow() {
        $(".mb-4 .text-lg").shouldBe(visible);
        $(".mb-4 .text-lg").shouldHave(text(testSuiteName));
        return this;
    }

    public ProjectPage openDropdown() {
        $(".detail-view-header-wrapper .ember-basic-dropdown").click(); //.sticky-header .space-x-2
        return this;
    }

    public ProjectPage deleteTestSuit() {
        $(".red").click();
        confirm();

        return this;
    }

}
