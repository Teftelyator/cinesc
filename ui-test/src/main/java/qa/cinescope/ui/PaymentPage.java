package qa.cinescope.ui;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static qa.cinescope.ui.constants.*;

public class PaymentPage {
    private String payment_amount_input = "[data-qa-id = 'payment_amount_input']";
    private String payment_card_number_input = "[data-qa-id = 'payment_card_number_input']";
    private String payment_card_holder_input = "[data-qa-id = 'payment_card_holder_input']";

    private String payment_card_month_select = "[data-qa-id = 'payment_card_month_select']";
    private String payment_card_year_select = "[data-qa-id = 'payment_card_year_select']";
    private String payment_card_cvc_input = "[data-qa-id = 'payment_card_cvc_input']";
    private String select = "div[role='option']";

    private String payment_submit_button = "[data-qa-id = 'payment_submit_button']";

    private String back_main_page_button = "//button[text() = 'Вернуться на главную']";


    public void inputValidDataCard() {
        $(payment_amount_input)
                .should(Condition.visible)
                .val("1");
        $(payment_card_number_input)
                .val(VALID_CARD_NUMBER);
        $(payment_card_holder_input)
                .val(VALID_NAME);

        $(payment_card_month_select)
                .click();
        $$(select)
                .findBy(text(VALID_MONTH_CARD))
                .click();

        $(payment_card_year_select)
                .click();
        $$(select)
                .findBy(text(VALID_YEAR_CARD))
                .click();

        $(payment_card_cvc_input)
                .val(VALID_CVC_CARD);
    }

    public void clickSubmitButton() {
        $(payment_submit_button)
                .click();
    }

    public void clickMainPageButton() {
        $x(back_main_page_button).click();
    }
}


