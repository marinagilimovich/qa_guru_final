package final_project.tests.uitests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("mhilimovich")
@Feature("Main page")
public class MainPageTests extends TestBase {
    String mainPageURL = "https://www.profitero.com/";

    @Test
    @Story("Verification of the main page")
    @Tags({@Tag("web"), @Tag("ui")})
    @DisplayName("Opening the main page")
    public void checkMainPageTitleTest() {
        step("Open the main page", () -> {
            open(mainPageURL);
        });

        step("Check product title", () -> {
            $("title").shouldHave(attribute("text",
                    "Profitero | Accelerate your eCommerce sales"));
        });
    }


    @Test
    @Story("Verification of the main page")
    @Tags({@Tag("web"), @Tag("ui")})
    @DisplayName("Checking menu items on the main page")
    public void checkMenuItemsTest() {
        step("Open the main page", () -> {
            open(mainPageURL);
        });

        step("Check names of all menu items", () -> {
            $("#megamenu__platform-tab").shouldHave(text("Platform"));
            $("#megamenu__who-we-help-tab").shouldHave(text("Who we help"));
            $("#megamenu__in-the-news-tab").shouldHave(text("In the news"));
            $("#megamenu__resources-tab").shouldHave(text("Resources"));
            $("#megamenu__about-us-tab").shouldHave(text("About us"));
        });
    }

    @Test
    @Story("Verification of the main page")
    @Tags({@Tag("web"), @Tag("ui")})
    @DisplayName("Checking Login page is available")
    public void loginPageAvailabilityTest() {
        step("Open the main page", () -> {
            open(mainPageURL);
        });

        step("Go to Login page", () -> {
            $(byText("Login")).click();
        });

        step("Check that Login page is open", () -> {
            $("h1").shouldHave(text("Login"));
        });
    }

    @Test
    @Story("Verification of the main page")
    @Tags({@Tag("web"), @Tag("ui")})
    @DisplayName("Verify that Forgot Password page is available")
    public void loginWithEmptyFieldTest() {
        step("Open the main page", () -> {
            open(mainPageURL);
        });

        step("Go to Login page", () -> {
            $(byText("Login")).click();
            $("h1").shouldHave(text("Login"));
        });

        step("Go to Forgot Password page", () -> {
            $(".forgot-password-link.link").click();
        });

        step("Check that the Forgot Password page is open", () -> {
            $("h1").shouldHave(text("Request to reset password"));
        });
    }

    @Test
    @Story("Verification of the main page")
    @Tags({@Tag("web"), @Tag("ui")})
    @DisplayName("Successful opening Request Demo page")
    public void requestDemoPageTest() {
        step("Open the main page", () -> {
            open(mainPageURL);
        });

        step("Go to Request Demo page", () -> {
            $(byText("Request a demo")).click();
        });

        step("Check that Request Demo page is open", () -> {
            $x("//h2/span").shouldHave(text("Accelerate your eCommerce sales"));
            $("#hs_cos_wrapper_widget_1612362065267_ p").shouldHave(text("Book your demo to see how these brands"));
        });
    }
}
