package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class ChartPage {
    private final SelenideElement closePromoButton = $(".pay-promo-close-btn"),
            shareButton = $(".d-share-popup_btn"),
            shareVkButton = $(".d-share-popup__popup").$(".ya-share2__link");
    private final ElementsCollection chartTracksList = $$(".lightlist__cont");

    @Step("Открытие страницы чартов и закрытие окна промо (если оно открывается).")
    public ChartPage openPage() {
        open("/chart");
        if (closePromoButton.exists()) {
            closePromoButton.click();
        }
        return this;
    }

    @Step("Проверка наличия треков в списке чарта.")
    public ChartPage checkFirstTrack() {
        chartTracksList.first().shouldBe(exist);
        return this;
    }
    @Step("Нажатие кнопки Поделиться в окне чарта.")
    public ChartPage clickShareButton() {
        shareButton.click();
        return this;
    }

    @Step("Проверка наличия кнопки Поделиться в окне чарта.")
    public ChartPage checkShareButton() {
        shareButton.shouldBe(exist);
        return this;
    }

    @Step("Проверка наличия кнопки Поделиться Вконтакте при нажатии кнопки Поделиться.")
    public ChartPage checkShareVkButton() {
        shareVkButton.text().equals("Вконтакте");
        return this;
    }
}
