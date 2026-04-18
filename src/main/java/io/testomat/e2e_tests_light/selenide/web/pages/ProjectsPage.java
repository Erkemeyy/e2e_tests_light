package io.testomat.e2e_tests_light.selenide.web.pages;

import com.codeborne.selenide.*;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private SelenideElement searchInput = $(".common-page-header #search");
    public ElementsCollection visibleProjectsOnProjectPage = $$("#grid ul li").filter(visible);

    public ProjectsPage open() {
        Selenide.open("");
        return this;
    }

    public ProjectsPage signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
        return this;
    }

    public ProjectsPage isLoaded() {
        searchInput.shouldBe(visible);
        return this;
    }

    public ProjectsPage searchProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);
        return this;
    }

    public ProjectsPage selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
        return this;
    }

    @NotNull
    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return visibleProjectsOnProjectPage.shouldHave(size(expectedSize));
    }

    public ProjectsPage compareNumberOfProjectsAfterCreatingOne(int numberOfProjects) {
        visibleProjectsOnProjectPage.shouldHave(size(numberOfProjects));
        return this;
    }

    public ProjectsPage totalCountOfProjectsGreaterThan(int expectedTotalCount) {
        visibleProjectsOnProjectPage.shouldHave(sizeGreaterThan(expectedTotalCount));
        return this;
    }

    public ProjectsPage countOfTestsCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(text(expectedCount + " tests"));
        return this;
    }

    public int getProjectsCount() {
        return visibleProjectsOnProjectPage.size();
    }

    public ProjectsPage totalCountOfProjectsIsVisible() {
        $("#container").shouldBe(visible);
        return this;
    }

    public ProjectsPage signOutFromAccount() {
        $("#user-menu-button").click();
        $(".block").click();
        return this;
    }

    public ProjectsPage compareEachProjectCountOfTests() {
        var labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.exactText("0 tests"));
        }
        return this;
    }
}
