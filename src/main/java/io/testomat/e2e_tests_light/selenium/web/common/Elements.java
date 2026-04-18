package io.testomat.e2e_tests_light.selenium.web.common;

import org.openqa.selenium.By;

public class Elements {


    public ElementsActions find(By locator) {
        return new ElementsActions(locator);
    }

    public static ElementsActions find(String locator) {
        By targetLocator = locator.startsWith("/") ? By.xpath(locator) : By.cssSelector(locator);
        return new ElementsActions(targetLocator);
    }

    public static ElementsActions findByText(String targetText) {
        return  new ElementsActions(By.xpath("//*[text()='"+ targetText+"']"));
    }
}
