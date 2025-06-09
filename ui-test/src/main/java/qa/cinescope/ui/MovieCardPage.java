package qa.cinescope.ui;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MovieCardPage {
    private String buyTicketButton = "//button[contains(., 'Купить билет')]";
    private String reviewField = "[data-qa-id= 'movie_review_input']";
    private String movieRatingSelect = "[data-qa-id= 'movie_rating_select']";
    private String movieReviewSubmitButton = "[data-qa-id= 'movie_review_submit_button']";
    private String reviewerName = "[class='text-xl w-fit']";

    public void clickBuyTicket() {
        $x(buyTicketButton)
                .shouldBe(visible)
                .click();
    }

    public void writeReview() {
        $(reviewField).val("Это отзыв");
        //$(movieRatingSelect).click();
        //$(movieRatingSelect).selectOptionByValue("4");
        $(movieReviewSubmitButton).click();
    }

    public void getReviewerName(){
        $x("//*[@class='text-xl w-fit']")
                .shouldBe(visible)
                .shouldHave(text("Vasya")) // если нужно проверить текст
                .click();
    }

}
