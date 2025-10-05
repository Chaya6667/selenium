package Practise_2025;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class api_Testing {
	String baseUrl = "https://reqres.in/api";

    @Test
    public void testGETUser() {
        given()
                .when()
                .get(baseUrl + "/users/2")
                .then()
                .statusCode(200)
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .log().all();
    }

    @Test
    public void testPOSTCreateUser() {
        String requestBody = "{\n" +
                "  \"name\": \"Chayanika\",\n" +
                "  \"job\": \"QA Automation Engineer\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(baseUrl + "/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Chayanika"))
                .body("job", equalTo("QA Automation Engineer"))
                .log().all();
    }

    @Test
    public void testPUTUpdateUser() {
        String requestBody = "{\n" +
                "  \"name\": \"Chayanika Deb\",\n" +
                "  \"job\": \"Senior QA Engineer\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put(baseUrl + "/users/2")
                .then()
                .statusCode(200)
                .body("job", equalTo("Senior QA Engineer"))
                .log().all();
    }

    @Test
    public void testDELETEUser() {
        given()
                .when()
                .delete(baseUrl + "/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }

}
