package io.testomat.e2e_tests_light.selenium;

import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light.selenium.common.LoginTestomat;
import io.testomat.e2e_tests_light.selenium.common.WebDriverLifeCycleExtension;
import io.testomat.e2e_tests_light.selenium.web.pages.LoginPageSelenium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light.selenium.web.common.Elements.findByText;
import static io.testomat.e2e_tests_light.selenium.web.common.WebDriverProvider.driver;

@ExtendWith({WebDriverLifeCycleExtension.class, LoginTestomat.class})
public class ProjectTests {
    protected static Dotenv env = Dotenv.load();
    protected static String userName = env.get("EMAIL");
    protected static String password = env.get("PASSWORD");


    @Test
    @DisplayName("Projects possible to find by name")
    void projectsPossibleToFindByName() {

        find("#container .common-flash-success");

        //search project
        String targetProjectName = "test Project Artem";
        find(".common-page-header #search").sendKeys(targetProjectName);

        //select project
        findByText(targetProjectName).click();

        //wait for project is loaded
        find(".first h2").waitFor().containsText(
                targetProjectName);

    }
}
