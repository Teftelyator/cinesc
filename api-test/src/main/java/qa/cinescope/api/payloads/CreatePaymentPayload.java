package qa.cinescope.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Setter
public class CreatePaymentPayload {

    @JsonProperty("movieId")
    int movieId;

    @JsonProperty("amount")
    int amount;

    @JsonProperty("card")
    Card card;

    @Accessors(fluent = true)
    @Getter
    @Setter
    public static class Card {

        @JsonProperty("cardNumber")
        String cardNumber;

        @JsonProperty("cardHolder")
        String cardHolder;

        @JsonProperty("expirationDate")
        String expirationDate;

        @JsonProperty("securityCode")
        int securityCode;
    }
}