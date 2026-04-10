package io.testomat.e2e_tests_light;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionOfElementsTests extends BaseTest{

    @Test
    @DisplayName("find all product experiments")
    void findAllProductExperiments(){
        ElementsCollection labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .shouldHave(CollectionCondition.)


    }
}
