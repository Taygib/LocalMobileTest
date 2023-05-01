package helpers;


import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
public class Browserstack {
    //https://automationautoma_lxrP0g:6p7oVykLsdXn3zYAyhCD@api.browserstack.com/app-automate/sessions/060bb9110f438fbf184f20a8e721109db21e0112.json

    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic("automationautoma_lxrP0g", "6p7oVykLsdXn3zYAyhCD")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
