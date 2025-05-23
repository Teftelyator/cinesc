package qa.cinescope.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(fluent = true)
public class UserInfoPayload {

    @JsonProperty("user")
    User user;

    @JsonProperty("accessToken")
    String accessToken;

    @JsonProperty("refreshToken")
    String refreshToken;

    @JsonProperty("expiresIn")
    int expiresIn;

    @Getter
    @Setter
    @Accessors(fluent = true)
    public class User {

        @JsonProperty("id")
        String id;

        @JsonProperty("email")
        String email;

        @JsonProperty("fullName")
        String fullName;

        @JsonProperty("roles")
        String roles;
    }

}
