package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class RedirectedPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public RedirectedPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }
    public void checkHotelName() {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.booking.com/hotel/rs/stara-bacija");
        Assert.assertEquals(driver.findElement(By.cssSelector("#hp_hotel_name>span")).getText(), "Apartmani");
        driver.switchTo().window(tabs.get(0));
    }

}