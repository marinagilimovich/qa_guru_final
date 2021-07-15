package final_project.tests.mobile;

import com.codeborne.selenide.ClickMethod;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;
import static java.nio.channels.Selector.open;

public class BrowserStackTests extends MobileTestBase {
    @Tag("selenide_android")
    @Test
    @DisplayName("Search on Wikipedia test")
    void simpleWikiSearchTest() {
        step("Open app", () -> {
            open();
        });

        step("If opened onboarding page - press back button", () -> {
            if ($(MobileBy.id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).isDisplayed()) {
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            }
        });

        step("Click on 'Search Wikipedia'", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
        });

        step("Type 'MobileBrowserstack'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("MobileBrowserstack");
        });

        step("Verify success search", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
    }
}