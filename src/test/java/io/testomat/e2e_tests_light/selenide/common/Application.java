package io.testomat.e2e_tests_light.selenide.common;

import io.testomat.e2e_tests_light.selenide.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.selenide.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.selenide.web.pages.ReadmePage;
import io.testomat.e2e_tests_light.selenide.web.pages.SignInPage;

public class Application {
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final SignInPage signInPage = new SignInPage();
    public final ReadmePage readmePage = new ReadmePage();
}
