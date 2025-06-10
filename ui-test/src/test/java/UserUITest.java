import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import qa.cinescope.ui.BasePage;
import qa.cinescope.ui.MovieCardPage;
import qa.cinescope.ui.PaymentPage;
import qa.cinescope.ui.services.UserService;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.cinescope.ui.constants.BASE_URL;
import static qa.cinescope.ui.constants.VALID_NAME;


public class UserUITest {

    UserService userService = new UserService();
    BasePage basePage = new BasePage();
    MovieCardPage movieCardPage = new MovieCardPage();
    PaymentPage paymentPage = new PaymentPage();

    @Test
    public void testLogin() {
        userService.loginUser();
        $(basePage.getProfile_page_button())
                .shouldHave(Condition.visible);
    }

    @Test
    public void testBuyTicket() {
        userService.loginUser();
        basePage.clickMoreMovie();
        movieCardPage.clickBuyTicket();
        paymentPage.inputValidDataCard();
        paymentPage.clickSubmitButton();
        paymentPage.clickMainPageButton();
        String currentURL = WebDriverRunner
                .getWebDriver()
                .getCurrentUrl();
        assertEquals(BASE_URL, currentURL);
    }

    @Test
    public void testWriteReview() {
        userService.loginUser();
        basePage.clickMoreMovie();
        movieCardPage.writeReview();
        assertEquals(movieCardPage.getReviewerName(), VALID_NAME);
    }
}