package tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Test
    void successfulSearchTest() {
        step("Search java", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
        //find(byText("java"));
        // $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        //shouldHave(text("java"));
    }

    @Test
    void searchNumberPi() {
        step("Search pi", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("what is pi equal");
            $(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(text("pi"));
            //find(withText("3.14"));
        });
    }

    @Test
    void searchCO2() {
        step("Search Carbon dioxide", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("CO2");
            $(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(text("Carbon dioxide"));
            //shouldHave(text("Carbon dioxide"));
            //find(byText("Carbon dioxide"));
            //org.wikipedia.alpha:id/fragment_main_coordinator
            //	org.wikipedia.alpha:id/fragment_main_view_pager
        });
    }
}