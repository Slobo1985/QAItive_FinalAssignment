package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchResultPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public SearchResultPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver,wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Stara Bačija')]")
    WebElement showHotel;

    public void clickFilter(){
       driver.findElement(By.xpath("//*[@id='searchboxInc']//..//h3[contains(text(),'Broj zvezdica')]//..//..//.//div[contains(text(),'2 zvezdice')]/../div")).click();

    }

    public void checkResults(){
        Assert.assertEquals(driver.findElement(By.cssSelector("#ss")).getAttribute("placeholder"),"Kopaonik");
        Assert.assertEquals(driver.findElement(By.cssSelector(".sb-dates__col.--checkin-field> div .sb-date-field__display")).getText(),"sreda, 15. decembar 2021.");
        Assert.assertEquals(driver.findElement(By.cssSelector(".sb-dates__col.--checkout-field> div .sb-date-field__display")).getText(),"subota, 18. decembar 2021.");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='xp__guests__toggle']/span/span[1]")).getText(),"3 odrasla");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='xp__guests__toggle']/span/span[2]")).getText(),"1 dete");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='xp__guests__toggle']/span/span[3]")).getText(),"2 jedinice");
    }

    public void clickShowHotel() {
        click(showHotel);
    }

}