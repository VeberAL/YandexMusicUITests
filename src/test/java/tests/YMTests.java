package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChartPage;
import pages.HomePage;

public class YMTests extends TestBase {
    HomePage homePage = new HomePage();
    ChartPage chartPage = new ChartPage();


    @Test
    @DisplayName("Проверка отображения карточки исполнителя.")
    @Tag("singer")
    void singerCardExistTest() {
        homePage.openPage()
                .searchButtonClick()
                .searchFieldWrite("Sting")
                .checkArtistCard("Sting");
    }

    @Test
    @DisplayName("Проверка отображения боковой панели с треками исполнителя.")
    @Tag("singer")
    void singerSideTrackPanelExistTest() {
        homePage.openPage()
                .searchButtonClick()
                .searchFieldWrite("Sting")
                .choiceArtistCard("Sting")
                .checkArtistSideBar();
    }

    @Test
    @DisplayName("Проверка наличия треков в списке чарта.")
    @Tag("chart")
    void chartTracksExistTest() {
        chartPage.openPage()
                .checkFirstTrack();
    }

    @Test
    @DisplayName("Проверка наличия кнопки Поделиться в окне чарта.")
    @Tag("chart")
    void chartShareButtonExistTest() {
        chartPage.openPage()
                .checkShareButton();
    }

    @Test
    @DisplayName("Проверка наличия кнопки Поделиться Вконтакте при нажатии кнопки Поделиться.")
    @Tag("chart")
    void chartShareVkButtonExistTest() {
        chartPage.openPage()
                .clickShareButton()
                .checkShareVkButton();
    }


}
