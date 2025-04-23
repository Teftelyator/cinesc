package qa.cinescope.tests;

import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa.cinescope.api.conditions.Conditions;
import qa.cinescope.api.payloads.UserPayload;
import qa.cinescope.api.services.auth.UserApiService;
import qa.cinescope.api.services.payment.PaymentService;


public class UsersTest {
    private final UserApiService userApiService = new UserApiService();
    private final PaymentService paymentService = new PaymentService();

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://auth.dev-cinescope.t-qa.ru/";
    }

    @Tag("AuthTests")
    @Test
    public void testRegisterNewUser() {
        //given
        UserPayload user = new UserPayload()
                .fullName("Vasya")
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
       /* UserPayload user = new UserPayload()
                .email("mail1@mail.com")
                .password("112233Qq");*/

        //expect
        userApiService.loginUser(userApiService.credentialLoginUser())
                .shouldHave(Conditions.statusCode(201));
    }
    @Test
    public void testLogoutUser() {
        userApiService.logoutUser();
    }

    @Test
    public void testRefreshToken(){
        //userApiService.extractTokenUser();
        userApiService.refresh1();
    }

    @Test
    public void testConfirmEmail(){
        userApiService.confirmEmail();
    }
    @Test
    public void testCreatePayment(){
        paymentService.createPayment();
    }
}
