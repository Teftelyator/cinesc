package qa.cinescope.api.services;

import qa.cinescope.api.assertions.AssertableResponse;
import qa.cinescope.api.payloads.UserPayload;
import io.restassured.response.Response;

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
}
