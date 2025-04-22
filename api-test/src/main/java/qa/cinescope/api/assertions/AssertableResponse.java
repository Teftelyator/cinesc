package qa.cinescope.api.assertions;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import qa.cinescope.api.conditions.Condition;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    public AssertableResponse shouldHave(Condition condition){
        log.info("About to check condition{}",condition);
        condition.check(response);
        return this;
    }

    public Headers headers(){
        return response.getHeaders();
    }



}
