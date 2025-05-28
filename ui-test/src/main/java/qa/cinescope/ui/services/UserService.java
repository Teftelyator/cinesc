package qa.cinescope.ui.services;

import com.codeborne.selenide.Selenide;
import qa.cinescope.ui.BasePage;
import qa.cinescope.ui.LoginPage;

public class UserService {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    public void loginUser() {
        Selenide.open("https://dev-cinescope.t-qa.ru/");

        basePage.clickLoginPageButton();
        loginPage.enterEmail("mail1@mail.com");
        loginPage.enterPass("112233Qq");
        loginPage.clickSubmitButton();
    }
}
