package qa.cinescope.ui;


import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BasePage {
    private String login_button = "[data-qa-id = 'login_page_button']";
    private String profile_page_button = "[data-qa-id = 'profile_page_button']";
    private String more_movie_button = "//button[text()='Подробнее']";

    public void clickLoginPageButton() {
        $(login_button).should(visible)
                .click();
    }

    public void clickMoreMovie() {
        $x(more_movie_button).click();
    }
}
