package qa.cinescope.api.assertions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import qa.cinescope.api.conditions.Condition;

@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    public AssertableResponse shouldHave(Condition condition){
        condition.check(response);
        return this;
    }


}
