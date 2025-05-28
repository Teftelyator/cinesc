import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import qa.cinescope.api.services.auth.UserApiService;
import qa.cinescope.ui.BasePage;
import qa.cinescope.ui.LoginPage;
import qa.cinescope.ui.PaymentPage;
import qa.cinescope.ui.services.UserService;

import static com.codeborne.selenide.Selenide.$;


public class UserUITest {

    UserService userService = new UserService();
    BasePage basePage = new BasePage();
    UserApiService userApiService = new UserApiService();
    LoginPage loginPage = new LoginPage();
    PaymentPage paymentPage = new PaymentPage();
    @Test
    public void openPage() {
        userApiService.extractIdUser();
        Selenide.sleep(3000);
    }

    @Test
    public void testLogin() {
        userService.loginUser();
        loginPage.clickSubmitButton();
        $(basePage.getProfile_page_button())
                .shouldHave(Condition.visible);
    }

    @Test
    public void testBuyTicket() {
        userService.loginUser();
        basePage.clickMoreMovie("1146");
        basePage.clickBuyTicket();
        paymentPage.inputValidDataCard();
        Selenide.sleep(3000);
    }
}