package io.testomat.e2e_tests_light.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light.playwright.common.PWExtention;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectsPlaywright {

    @RegisterExtension
    static PWExtention pw = new PWExtention();


    @Test
    void projectPossibleToFilterPWTest() {
        var page = pw.page();

        Dotenv env = Dotenv.load();
        String userName = env.get("EMAIL");
        String password = env.get("PASSWORD");
        String targetProjectName = "test Project Artem";
        String baseUrl = env.get("BASE_URL");

        // Open the website
        page.navigate(baseUrl);

        // Login user
        page.locator("#content-desktop #user_email").fill(userName);
        page.locator("#content-desktop #user_password").fill(password);
        page.locator("#content-desktop #user_remember_me").click();
        page.locator("#content-desktop [name=\"commit\"]").click();

        // Wait for success message
        page.locator(".common-flash-success").isVisible();

        // Search project
        page.locator("#search").fill(targetProjectName);

        // Select project
        page.locator("text=" + targetProjectName).click();

        // Wait for project to load
        assertThat(page.locator("h2").first()).containsText(targetProjectName);



    }
}
