package qa.cinescope.ui.services;

import com.codeborne.selenide.Selenide;
import qa.cinescope.ui.BasePage;
import qa.cinescope.ui.LoginPage;

import static qa.cinescope.ui.constants.*;

public class UserService {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    public void loginUser() {
        Selenide.open(BASE_URL);

        basePage.clickLoginPageButton();
        loginPage.enterEmail(VALID_EMAIL);
        loginPage.enterPass(VALID_PASSWORD);
        loginPage.clickSubmitButton();
    }
}
