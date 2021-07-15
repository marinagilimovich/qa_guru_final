package final_project.tests.mobile;

import com.codeborne.selenide.Configuration;
import final_project.config.MobileDeviceHost;
import final_project.config.MobileProjectData;
import final_project.drivers.MobileAndroidMobileDriver;
import final_project.helpers.MobileAttachHelper;
import final_project.helpers.MobileBrowserStackHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static final_project.helpers.MobileAttachHelper.getSessionId;

public class BaseTest {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = MobileAndroidMobileDriver.class.getName();
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
        MobileAttachHelper.screenshotAs("Last screenshot");

        if (!MobileProjectData.deviceHost().equals(MobileDeviceHost.LOCAL)) {
            String sessionId = getSessionId();
            MobileAttachHelper.attachVideo(sessionId);
            if (MobileProjectData.deviceHost().equals(MobileDeviceHost.BROWSER_STACK))
                MobileAttachHelper.attachAsText("Browserstack build link",
                        MobileBrowserStackHelper.getBSPublicLink(sessionId));
        }

        closeWebDriver();
    }
}
