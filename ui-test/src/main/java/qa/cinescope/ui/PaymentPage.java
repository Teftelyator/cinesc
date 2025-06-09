package qa.cinescope.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private String payment_amount_input = "[data-qa-id = 'payment_amount_input']";
    private String payment_card_number_input = "[data-qa-id = 'payment_card_number_input']";
    private String payment_card_holder_input = "[data-qa-id = 'payment_card_holder_input']";

    private String payment_card_month_select = "[data-qa-id = 'payment_card_month_select']";
    private String payment_card_year_select = "[data-qa-id = 'payment_card_year_select']";
    private String payment_card_cvc_input = "[data-qa-id = 'payment_card_cvc_input']";

    private String payment_submit_button = "[data-qa-id = 'payment_submit_button']";

    //разобраться с селектами!!!
    public void inputValidDataCard(){
        $(payment_amount_input).should(Condition.visible).val("1");
        $(payment_card_number_input).val("4242424242424242");
        $(payment_card_holder_input).val("John Doe");
        $(payment_card_month_select).click();
        $("div[role='option']:contains('Декабрь')").click();

        Selenide.sleep(2000);
        //$(payment_card_year_select).click();
        //$("select option[value='25']").click();
        //$(payment_card_year_select).selectOption("2025");
        $(payment_card_cvc_input).val("123");


        $(payment_submit_button).click();
    }
}


