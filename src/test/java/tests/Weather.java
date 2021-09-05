package tests;

import PageObject.HomePage;
import PageObject.WeatherPage;
import Utils.BaseTest;
import org.testng.annotations.Test;

public class Weather extends BaseTest {
    String temperature = "";

    @Test
    public void testWeather() {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.setInputText("Mumbai");
        homePage.selectCity("Mumbai, Maharashtra, IN");

        WeatherPage weatherPage = new WeatherPage(driver);
        weatherPage.validateHeader("Mumbai, Maharashtra");
        weatherPage.clickMoreDetails();
        temperature = weatherPage.fetchCurrentTemperature();
    }
}
