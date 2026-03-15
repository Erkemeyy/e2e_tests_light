package io.testomat.e2e_tests_light.utils;

import org.jetbrains.annotations.NotNull;

public class StringParser {
    @NotNull
    public static Integer parseIntegerFromString(String countOfTests) {
        String digitText = countOfTests.replaceAll("\\D+","");
        return Integer.parseInt(digitText);
    }
}
