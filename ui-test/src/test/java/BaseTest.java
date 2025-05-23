import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import qa.cinescope.api.services.auth.UserApiService;


public class BaseTest {
    @Test
    public void openPage() {
        UserApiService userApiService = new UserApiService();
        userApiService.loginUser(userApiService.credentialLoginUser());
        //userApiService.extractIdUser();
        Selenide.open("https://dev-cinescope.t-qa.ru/movies/1129/payment");

    }
}