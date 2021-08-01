package final_project.tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

@Owner("mhilimovich")
@Feature("RegresIn site")
public class RegressInTests {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    @Story("Get requests")
    @DisplayName("Get a single resource")
    @Tags({@Tag("web"), @Tag("api")})
    void singleResourceSuccessfulTest() {
        given()
                .when()
                .get("/api/unknown/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.name", is("fuchsia rose"));
    }


    @Test
    @Story("Get requests")
    @DisplayName("Get a single resource, negative test")
    @Tags({@Tag("web"), @Tag("api")})
    void singleResourceFailedTest() {
        given()
                .when()
                .get("/api/unknown/23")
                .then()
                .statusCode(404);
    }


    @Test
    @Story("Post requests")
    @DisplayName("Successful registration test")
    @Tags({@Tag("web"), @Tag("api")})
    void registrationSuccessfulTest() {
        given()
                .contentType(JSON)
                .body("{ \"email\": \"eve.holt@reqres.in\", " +
                        "\"password\": \"pistol\" }")
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }


    @Test
    @Story("Post requests")
    @DisplayName("Successful login test")
    @Tags({@Tag("web"), @Tag("api")})
    void loginSuccessfulTest() {
        given()
                .contentType(JSON)
                .body("{ \"email\": \"eve.holt@reqres.in\", " +
                        "\"password\": \"cityslicka\" }")
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }


    @Test
    @Story("Put requests")
    @DisplayName("Successful update of user data")
    @Tags({@Tag("web"), @Tag("api")})
    void updateUserSuccessfulTest() {
        given()
                .contentType(JSON)
                .body("{ \"name\": \"morpheus\", " +
                        "\"job\": \"zion resident\" }")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }
}
