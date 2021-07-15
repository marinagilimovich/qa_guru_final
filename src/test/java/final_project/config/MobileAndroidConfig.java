package final_project.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/android.properties"
})
public interface MobileAndroidConfig extends Config {
    @Key("browserstack.device")
    String device();

    @Key("browserstack.os")
    String osVersion();

    @Key("browserstack.app.url")
    String app();
}