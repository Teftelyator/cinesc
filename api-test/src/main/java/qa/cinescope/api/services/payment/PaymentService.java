package qa.cinescope.api.services.payment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import qa.cinescope.api.payloads.CreatePaymentPayload;
import qa.cinescope.api.services.auth.UserApiService;

public class PaymentService {
    UserApiService userApiService = new UserApiService();

    public CreatePaymentPayload credentialPaymentPayload() {
        // Сначала создаем объект карты
        CreatePaymentPayload.Card card = new CreatePaymentPayload.Card()
                .cardNumber("4242424242424242")
                .cardHolder("John Doe")
                .expirationDate("12/25")
                .securityCode(123);

        // Затем создаем основной объект с картой
        CreatePaymentPayload createPaymentPayload = new CreatePaymentPayload()
                .movieId(886)
                .amount(2)
                .card(card); // Передаем созданный объект карты

        return createPaymentPayload;
    }

    public void createPayment() {
        RestAssured.given()
                .baseUri("https://payment.dev-cinescope.t-qa.ru")
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + userApiService.extractTokenUser())
                .when()
                .body(credentialPaymentPayload())
                .post("/create")
                .then().log().all();

    }
}
