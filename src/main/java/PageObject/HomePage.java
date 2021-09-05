package PageObject;

import Utils.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BaseView {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".search-input")
     private WebElement searchInputText;

    @FindBy(css =".search-bar-result.search-result")
    private List<WebElement> cityList;

    public void setInputText(String text) {
        setText(searchInputText,text);
    }

    public void selectCity(String city) {
        for (WebElement element : cityList) {
            if (element.getText().equals(city)) {
                element.click();
                break;
            }
        }
    }



}
