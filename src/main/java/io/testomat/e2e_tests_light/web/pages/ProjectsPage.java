package io.testomat.e2e_tests_light.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {
    public void open(){
        Selenide.open("");
    }

    public static void searchProject(String targetProjectName) {
        $("#search").setValue(targetProjectName);
    }

    public static void selectProject(String targetProjectName) {
        $(Selectors.byText(targetProjectName)).click();
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
    }
}
