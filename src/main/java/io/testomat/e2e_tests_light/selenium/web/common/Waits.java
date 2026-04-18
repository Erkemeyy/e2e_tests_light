package io.testomat.e2e_tests_light.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class Waits {

    private final By selector;
    private final WebDriverWait wait;

    public Waits(By selector) {
        this.selector = selector;
        this.wait = new WebDriverWait(WebDriverProvider.driver(), Duration.ofSeconds(10));
        this.wait.ignoring(StaleElementReferenceException.class);
        this.wait.pollingEvery(Duration.ofMillis(100));
    }

    public void visibility() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void isHidden() {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(selector)));
    }

    public void hasTest(String expectedText) {
        this.wait.until(ExpectedConditions.textToBe(selector, expectedText));
    }

    public void containsText(String expectedText) {
        this.wait.until(ExpectedConditions.textMatches(selector, Pattern.compile(
                Pattern.quote(expectedText),
                Pattern.CASE_INSENSITIVE
        )));
    }

    public void customWait() {
        this.wait.until(new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    WebElement targetElement = driver.findElement(selector);
                    targetElement.isDisplayed();
                    targetElement.isEnabled();
                    currentValue = driver.findElement(selector).getText();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return "text found by %s to match pattern \"%s\". Current text: \"%s\"";
            }
        });
    }

}
