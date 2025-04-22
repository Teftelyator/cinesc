package qa.cinescope.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.processing.Generated;


@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class UserPayload {

    @JsonProperty("email")
    private String email;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("passwordRepeat")
    private String passwordRepeat;
}