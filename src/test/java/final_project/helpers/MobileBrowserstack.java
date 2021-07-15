package final_project.helpers;


import final_project.config.MobileProjectConfig;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class MobileBrowserstack {

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(MobileProjectConfig.MOBILE_BROWSERSTACK_CONFIG.username(), MobileProjectConfig.MOBILE_BROWSERSTACK_CONFIG.key())
                .when()
                .get(MobileProjectConfig.MOBILE_BROWSERSTACK_CONFIG.sessionUrl() + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(String.format(MobileProjectConfig.MOBILE_BROWSERSTACK_CONFIG.hubUrl(), MobileProjectConfig.MOBILE_BROWSERSTACK_CONFIG.username(),
                    MobileProjectConfig.MOBILE_BROWSERSTACK_CONFIG.key()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
