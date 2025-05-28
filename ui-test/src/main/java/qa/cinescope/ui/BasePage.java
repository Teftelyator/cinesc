package qa.cinescope.ui;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    private String login_button = "[data-qa-id = 'login_page_button']";
    private String profile_page_button = "[data-qa-id = 'profile_page_button']";

    public void clickLoginPageButton() {
        $(login_button).should(visible)
                .click();
    }


    public String selectCardMovie(String movieId) {
        String MovieCardGenerator = "movie_more_" + movieId;
        String xpathMovieCard = "[data-qa-id = " + "'" + MovieCardGenerator + "'";
        return xpathMovieCard;
    }

    public void clickMoreMovie(String movieId) {
        $(selectCardMovie(movieId))
                .click();
    }

    public void clickBuyTicket() {
        $x("//*[@id='root']/div[1]/main/section/div[1]/div[2]/button")
                .shouldBe(visible)
                .click();
    }

    public String getLogin_button() {
        return login_button;
    }

    public String getProfile_page_button() {
        return profile_page_button;
    }

}
