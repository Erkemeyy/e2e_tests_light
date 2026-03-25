package io.testomat.e2e_tests_light;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

public class BaseTest {
    public static Dotenv env = Dotenv.load();

    static String userName = env.get("EMAIL");
    static String password = env.get("PASSWORD");

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
