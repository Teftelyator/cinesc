package qa.cinescope.ui;

import com.codeborne.selenide.SelenideElement;
import qa.cinescope.api.conditions.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static qa.cinescope.ui.constants.VALID_NAME;

public class MovieCardPage {
    private String buyTicketButton = "//button[contains(., 'Купить билет')]";
    private String reviewField = "[data-qa-id= 'movie_review_input']";
    private String movieRatingSelect = "button[role='combobox'][aria-controls^='radix-']";
    private String movieReviewSubmitButton = "[data-qa-id= 'movie_review_submit_button']";
    private String reviewerName = "//*[@class='text-xl w-fit']";
    private String select = "div[role='option']";


    public void clickBuyTicket() {
        $x(buyTicketButton)
                .shouldBe(visible)
                .click();
    }

    public void writeReview() {
        $(reviewField).val("Это отзыв");
        $(movieRatingSelect).shouldBe(visible).click();
        $$(select)
                .findBy(text("4"))
                .click();
        $(movieReviewSubmitButton).click();
    }

    public SelenideElement getReviewerNameEl(){
        return $$x(reviewerName)
                .findBy(exactText(VALID_NAME));
    }

    public String getReviewerName() {
        return getReviewerNameEl()
                .shouldBe(visible).getText();
    }
}
