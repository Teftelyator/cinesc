package qa.cinescope.api.services.auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qa.cinescope.api.assertions.AssertableResponse;
import qa.cinescope.api.payloads.UserPayload;

import static io.restassured.RestAssured.baseURI;

public class UserApiService extends ApiService {
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when().log().all()
                .post("/register"));
    }

    public AssertableResponse loginUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("/login"));
    }

    public UserPayload credentialLoginUser() {
        UserPayload user = new UserPayload()
                .fullName("vasya")//(RandomStringUtils.randomAlphanumeric(6))
                .email("mail1@mail.com")
                .password("112233Qq");
        return user;
    }

    public void logoutUser() {
        RestAssured
                .when()
                .get("/logout")
                .then().log().all();
    }

    public String extractTokenUser() {
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(credentialLoginUser())
                .when().log().all()
                .post("/login");
        response.then().log().all();

        return response.jsonPath().getString("accessToken");
    }

    public String extractIdUser() {
        Response idUser = RestAssured.given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(credentialLoginUser())
                .when().log().all()
                .post("/login");
        idUser.then().log().all();
        return idUser.jsonPath().getString("user.id");
    }

    public void confirmEmail() {
        RestAssured.given()
                .baseUri(baseURI)
                .headers("Authorization", "Bearer " + extractTokenUser())
                .contentType(ContentType.JSON)
                .when()
                .get("/confirm")
                .then().log().all();
    }

    public void refresh() {
        try {
            String token = extractTokenUser();
            System.out.println("Токен здесь: " + token);

            Response refreshResponse = RestAssured.given()
                    .baseUri(baseURI)
                    .headers("Authorization", "Bearer " + extractTokenUser())
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/refresh-tokens");
            refreshResponse.then().log().all();

            String newAccessToken = refreshResponse.jsonPath().getString("accessToken");
            System.out.println("Новый токен: " + newAccessToken);
        } catch (Exception e) {
            System.err.println("Ошибка при обновлении токена" + e.getMessage());
            e.printStackTrace();
        }
    }
}
