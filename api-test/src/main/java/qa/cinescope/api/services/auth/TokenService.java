package qa.cinescope.api.services.auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qa.cinescope.api.assertions.AssertableResponse;
import qa.cinescope.api.payloads.UserPayload;
import qa.cinescope.api.responses.TokenResponse;

import static io.restassured.path.json.JsonPath.given;

public class TokenService {

 /*   public String getAccessToken(String email,String password){
        UserApiService userApiService = new UserApiService();
        UserPayload user = new UserPayload()

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/login")
                .

        TokenResponse tokenResponse = response.as(TokenResponse.class);
        return tokenResponse.getToken();
    }*/
}