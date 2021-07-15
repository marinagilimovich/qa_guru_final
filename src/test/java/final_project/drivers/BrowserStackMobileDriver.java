package final_project.drivers;

import com.codeborne.selenide.WebDriverProvider;
import final_project.config.MobileProjectConfig;
import final_project.helpers.MobileBrowserstack;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        return getAndroidDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "qa_guru_20");
        capabilities.setCapability("build", "Android");
        capabilities.setCapability("name", "MobileTests");
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", MobileProjectConfig.MOBILE_ANDROID_CONFIG.device());
        capabilities.setCapability("os_version", MobileProjectConfig.MOBILE_ANDROID_CONFIG.osVersion());
        capabilities.setCapability("app", MobileProjectConfig.MOBILE_ANDROID_CONFIG.app());

        return new AndroidDriver(MobileBrowserstack.getBrowserstackUrl(), capabilities);
    }
}