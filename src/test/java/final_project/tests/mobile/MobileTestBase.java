package final_project.tests.mobile;

import com.codeborne.selenide.Configuration;
import final_project.drivers.BrowserStackMobileDriver;
import final_project.helpers.MobileAttach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static final_project.helpers.MobileAttach.getSessionId;

public class MobileTestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = BrowserStackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        MobileAttach.screenshotAs("Last screenshot");
        MobileAttach.pageSource();
        closeWebDriver();

        MobileAttach.attachVideo(sessionId);
    }
}
