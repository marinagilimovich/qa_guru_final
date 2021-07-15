package final_project.config;

import org.aeonbits.owner.ConfigFactory;

public class MobileProjectConfig {
    public static final MobileBrowserstackConfig MOBILE_BROWSERSTACK_CONFIG =
            ConfigFactory.create(MobileBrowserstackConfig.class, System.getProperties());
    public static final MobileAndroidConfig MOBILE_ANDROID_CONFIG =
            ConfigFactory.create(MobileAndroidConfig.class, System.getProperties());
}