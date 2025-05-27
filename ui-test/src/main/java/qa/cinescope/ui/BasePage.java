package qa.cinescope.ui;


import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private String login_button = "[data-qa-id = 'login_page_button']";
        public void clickLoginPageButton() {
            $(login_button).click();

        }
}
