import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import qa.cinescope.api.services.auth.UserApiService;
import qa.cinescope.ui.BasePage;
import qa.cinescope.ui.LoginPage;


public class BaseTest {

    BasePage basePage = new BasePage();
    UserApiService userApiService = new UserApiService();
    LoginPage loginPage = new LoginPage();
    @Test
    public void openPage() {
        //userApiService.loginUser(userApiService.credentialLoginUser());
        userApiService.extractIdUser();
        //Selenide.open("https://dev-cinescope.t-qa.ru/movies/1129/payment");
        Selenide.sleep(3000);
    }

    @Test
    public void testLogin(){
        Selenide.open("https://dev-cinescope.t-qa.ru/");
        basePage.clickLoginPageButton();
        loginPage.enterEmail("mail1@mail.com");
        loginPage.enterPass("112233Qq");
        loginPage.clickSubmitButton();
        Selenide.sleep(3000);
    }
}