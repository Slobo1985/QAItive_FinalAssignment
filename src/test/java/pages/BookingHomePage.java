package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingHomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BookingHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-modal-id='language-selection']")
    WebElement languageIcon;

    String languageLinkXpath = "//div[@class='bui-group bui-group--large']/div[2]//div[contains(text(),'$')]/../..";

    @FindBy(css = "#ss")
    WebElement location;

    @FindBy(css = ".xp__dates.xp__group")
    WebElement dates;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    WebElement next;

    @FindBy(css = "#xp__guests__toggle")
    WebElement accommodation;

    @FindBy ( css=".sb-group__field.sb-group__field-adults > div > .bui-stepper__wrapper> .bui-button--secondary.bui-stepper__add-button")
    WebElement adults;

    @FindBy(css = ".sb-group__field.sb-group-children > div > div.bui-stepper__wrapper>.bui-button--secondary.bui-stepper__add-button")
    WebElement childrenNumber;

    @FindBy(css =".sb-group__children__field.clearfix > select")
    WebElement childrenAge;

    //#xp__guests__inputs-container > div > div > div.sb-group__children__field.clearfix > select

    @FindBy(css = ".sb-group__field.sb-group__field-rooms > div > div.bui-stepper__wrapper> .bui-button--secondary.bui-stepper__add-button")
    WebElement unit;

    @FindBy(css = ".xp__button")
    WebElement searchButton;

    @FindBy(css = "//*[@class='c-autocomplete__input sb-searchbox__input sb-destination__input']")
    WebElement name;

    @FindBy(css =".sb-dates__col.--checkin-field> div .sb-date-field__display")
    WebElement dateOfEntry;

    @FindBy(css =".sb-dates__col.--checkout-field> div .sb-date-field__display")
    WebElement dateOfExit;

    public void selectLanguage(String language) {
        click(languageIcon);
        click(driver.findElement(By.xpath(languageLinkXpath.replace("$", language))));
    }

    public void enterLocation(String locationValue) {
        typeText(location, locationValue);
    }

    public void assertName(WebElement name, String nameText) {
        assertEquals(name, nameText);
    }


    /**
     * Selects start and end date
     *
     * @param startDate format DD month YYYY
     * @param endDate   format DD month YYYY
     */
    public void selectDates(String startDate, String endDate) {
        click(dates);

        while (true) {
            List<WebElement> startDateList = driver.findElements(By.xpath("//span[@aria-label='" + startDate + "']"));

            if (startDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + startDate + "']")));
                break;
            }
        }

        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//span[@aria-label='" + endDate + "']"));

            if (endDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + endDate + "']")));
                break;
            }
        }
    }


    public void clickAccommodation() {
        click(accommodation);
    }

    public void clickAdults(){
        click(adults);
    }

    public void clickChildrenNumber() {
        click(childrenNumber);
    }

    public void selectChildrenAge() {
        selectByValue(childrenAge,"1");
    }

    public void clickUnit(){
        click(unit);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

}

