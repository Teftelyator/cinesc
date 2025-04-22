package qa.cinescope.api.services.auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
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
        return  new AssertableResponse( setup()
                .body(user)
                .when()
                .post("/login"));
    }
    public void logoutUser() {
        RestAssured
                .when()
                .get("/logout")
                .then().log().all();
    }

    public String extractTokenUser() {
        UserPayload user = new UserPayload()
                .fullName("vasya")//(RandomStringUtils.randomAlphanumeric(6))
                .email("mail1@mail.com")
                .password("112233Qq");
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(user)
                .when().log().all()
                .post("/login");
response.then().log().all();

        return response.jsonPath().getString("accessToken");
    }

    public void confirmEmail(){
        RestAssured.given()
                .baseUri(baseURI)
                .pathParam("Authorization", "Bearer " + extractTokenUser())
                .contentType(ContentType.JSON)
                .when()
                .get("/confirm")
                .then().log().all();
    }

    public void refresh(){

        System.out.println("токен тута"+extractTokenUser());
        RestAssured.given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " + extractTokenUser())
                .contentType(ContentType.JSON)
                .when()
                .get("/refresh-tokens")
                .then().log().all()
                .extract().statusCode();

        //System.out.println( "новый токен тута"+jsonPath.getString("accessToken"));

    }

    public void refresh1() {
// Получаем токен один раз, чтобы не делать лишний запрос
        try {
            String token = extractTokenUser();
            System.out.println("Токен здесь: " + token);

            // Выполняем запрос на обновление токенов
            Response refreshResponse = RestAssured.given()
                    .baseUri(baseURI)
                    .auth().oauth2(token)
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/refresh-tokens");
            refreshResponse.then().log().all();

            // Если нужно извлечь новый токен из ответа
            String newAccessToken = refreshResponse.jsonPath().getString("accessToken");
            System.out.println("Новый токен: " + newAccessToken);
        } catch (Exception e) {
            System.err.println("Ошибка при обновлении токена" + e.getMessage());
            e.printStackTrace();
        }
    }
}
