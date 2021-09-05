package PageObject;

import Utils.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WeatherPage extends BaseView {
    WebDriver driver;

    public WeatherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".header-loc")
    private WebElement headerText;

    @FindBy(xpath = "//*[contains(text(),'More Details') and @class='text']")
    private WebElement moreDetails;

    @FindBy(css = ".display-temp")
    private WebElement temp;

    public void validateHeader(String expectedHeader) {
        Assert.assertEquals(headerText.getText(),expectedHeader);
    }

    public void clickMoreDetails() {
        click(moreDetails);
    }

    public String fetchCurrentTemperature() {
        return temp.getText();
    }
}
