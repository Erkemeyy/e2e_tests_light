package io.testomat.e2e_tests_light.web.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ReadmePage {
    public ReadmePage clickOnEditReadme() {
        $(byText("Edit Readme")).click();
        switchTo().frame($("#modal-overlays iframe[src='/ember-monaco/frame.html']"));
        return this;
    }

    public ReadmePage editFirstLineInEditor(String targetText) {
        $(".view-lines div").click();
        $("textarea").setValue(targetText);
        return this;
    }

    public ReadmePage clickOnUpdate() {
        switchTo().defaultContent();
        $(byText("Update")).click();
        return this;
    }

    public ReadmePage clickOnCancel() {
        switchTo().defaultContent();
        $(byText("Cancel")).click();
        return this;
    }

    public ReadmePage isLoaded() {
        $(".setting-header").shouldHave(text("Readme"));
        return this;
    }

    public ReadmePage verifyReadmeContainsNewText(String expectedText) {
        $$("div span").findBy(text(expectedText)).shouldBe(visible);

        return this;
    }
}
