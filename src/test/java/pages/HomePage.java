package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement closePromoButton = $(".pay-promo-close-btn"),
            searchButton = $(".d-search__button__container"),
            searchField = $(".d-input__field"),
            artistSidebarWindow = $(".sidebar-artist");
    private final ElementsCollection artistInfoWindow = $$(".artist__content");

    @Step("Открытие главной страницы сайта и закрытие окна промо (если оно открывается).")
    public HomePage openPage(){
        open("/home");
        if (closePromoButton.exists()) {
            closePromoButton.click();
        }
        return this;
    }

    @Step("Нажатие на кнопку поиска.")
    public HomePage searchButtonClick(){
        searchButton.click();
        return this;
    }

    @Step("Ввод информации в окно поиска.")
    public HomePage searchFieldWrite(String artistName){
        searchField.sendKeys(artistName);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("Выбор карточки исполнителя из появившегося списка.")
    public HomePage choiceArtistCard(String artistName){
        artistInfoWindow.findBy(text(artistName)).click();
        return this;
    }

    @Step("Проверка отображения карточки исполнителя.")
    public HomePage checkArtistCard(String artistName){
        artistInfoWindow.findBy(text(artistName)).shouldBe(exist);
        return this;
    }

    @Step("Проверка отображения боковой панели с треками исполнителя.")
    public HomePage checkArtistSideBar(){
        artistSidebarWindow.shouldBe(exist);
        return this;
    }
}
