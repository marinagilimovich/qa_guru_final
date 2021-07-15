package final_project.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface MobileBrowserstackConfig extends Config {
    @Key("browserstack.hub.url")
    String hubUrl();

    @Key("browserstack.session.url")
    String sessionUrl();

    @Key("browserstack.user")
    String username();

    @Key("browserstack.key")
    String key();
}
