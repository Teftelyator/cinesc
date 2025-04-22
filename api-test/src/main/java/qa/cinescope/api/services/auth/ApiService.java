package qa.cinescope.api.services.auth;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    protected RequestSpecification setup(){
        return RestAssured
                .given().contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
    }
}
