package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private SelenideElement searchInput = $("#search");
    public ElementsCollection visibleProjectsOnProjectPage = $$("#grid ul li").filter(visible);

    public void open(){
        Selenide.open("");
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
}

    public ProjectsPage isLoaded(){
        searchInput.shouldBe(visible);
        return this;
    }

    public ProjectsPage searchProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);
        return  this;
}

    public void selectProject(String targetProjectName) {
        $(Selectors.byText(targetProjectName)).click();
    }

    @NotNull
    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return visibleProjectsOnProjectPage.shouldHave(size(expectedSize));
    }

    public void compareNumberOfProjectsAfterCreatingOne(int numberOfProjects) {
        visibleProjectsOnProjectPage.shouldHave(size(numberOfProjects + 1));
    }

    public void totalCountOfProjectsGraterThan(int expectedTotalCount) {
        visibleProjectsOnProjectPage.shouldHave(sizeGreaterThan(expectedTotalCount)) ;
    }

    public void countOfTestsCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(text(expectedCount + " tests"));
    }

    public void totalCountOfProjectsIsVisible(){
        $("#container").shouldBe(visible);
    }

    public void signOutFromAccount() {
        $(".common-flash-success").shouldBe(visible);
        $("#user-menu-button").click();
        $(".block").click();
    }
}
