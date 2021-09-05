package Utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BaseView {

    public WebDriver driver;

    @FindBy(css = ".page-title")
    protected WebElement pageTitleElement;

    public String getPageTitle() {
        return getTextFromElement(pageTitleElement);
    }

    protected String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (StaleElementReferenceException sere) {
            PageFactory.initElements(driver, this);
            return element.getText();
        } catch (Throwable throwable) {
            System.out.println("Exception in getting text from element");
        }
        return null;
    }

    public void validatePageTitle(String pageTitle) {
        if (pageTitle == null) {
            throw new RuntimeException("Page Title is not Set for this Page!");
        }
        Assert.assertEquals(getPageTitle(), pageTitle, "Page Title");
    }

    public void setText(WebElement element, String text) {
                element.clear();
                element.sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }
}
