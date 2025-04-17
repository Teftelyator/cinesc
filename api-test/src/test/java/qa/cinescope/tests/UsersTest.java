package qa.cinescope.tests;

import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qa.cinescope.api.conditions.Conditions;
import qa.cinescope.api.payloads.UserPayload;
import qa.cinescope.api.services.UserApiService;




public class UsersTest {
    private final UserApiService userApiService = new UserApiService();

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://auth.dev-cinescope.t-qa.ru/";
    }

    @Test
    public void testRegisterNewUser() {
        //given
        UserPayload user = new UserPayload()
                .fullName(RandomStringUtils.randomAlphanumeric(6))
                .email("mail1@mail.com")
                .password("112233Qq")
                .passwordRepeat("112233Qq");

        //expect
        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(201));
    }

    @Test
    public void testLoginUser() {
        //given
        UserPayload user = new UserPayload()
                .email("mail1@mail.com")
                .password("112233Qq");

        //expect
        userApiService.loginUser(user)
                .shouldHave(Conditions.statusCode(201));
    }
}
