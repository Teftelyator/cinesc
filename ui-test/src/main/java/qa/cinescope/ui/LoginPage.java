package qa.cinescope.ui;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String email = "[id = 'email']";
    private final String password = "[id = 'password']";
    private final String submit_button = "[data-qa-id = 'login_submit_button']";

    public void enterEmail(String mail) {
        $(email)
                .val(mail);
    }

    public void enterPass(String pass) {
        $(password)
                .val(pass);
    }

    public void clickSubmitButton() {
        $(submit_button)
                .click();
    }
}
