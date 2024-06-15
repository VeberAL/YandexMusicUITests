package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://music.yandex.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;

//Для параметризированного запуска
//          Configuration.baseUrl = System.getProperty("baseUrl");
//          Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
//          Configuration.remote = System.getProperty("remote");
//          Configuration.browser = System.getProperty("browser");
//          Configuration.browserVersion = System.getProperty("browserVersion");

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
    }

//    @BeforeEach
//    void beforeEach() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }
//
//    @AfterEach
//    void addAttachments() {
//
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWindow();
    }
}
