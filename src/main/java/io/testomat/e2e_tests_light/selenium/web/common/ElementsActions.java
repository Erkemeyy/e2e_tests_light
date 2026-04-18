package io.testomat.e2e_tests_light.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.testomat.e2e_tests_light.selenium.web.common.WebDriverProvider.driver;

public class ElementsActions {

    private final By selector;

    public ElementsActions(By selector) {
        this.selector = selector;
    }

    public void click() {
        waitFor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitFor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.selector);
    }
}
