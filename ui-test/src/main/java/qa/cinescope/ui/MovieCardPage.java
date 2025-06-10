package qa.cinescope.ui;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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

    public String getReviewerName() {
        return $x(reviewerName)
                .shouldBe(visible).getText();
    }

}
