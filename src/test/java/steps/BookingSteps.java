package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.BookingHomePage;
import pages.RedirectedPage;
import pages.SearchResultPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.ArrayList;

public class BookingSteps extends BaseTest {

    @Before
    public void initCucumber() {
        init("Chrome", "96", 30);
    }

    @After
    public void tearDown() throws IOException {
        reportScreenshot("Test", "TestAllure");
        quitDriver();
    }

    @Given("I am on booking home page")
    public void iAmOnBookingHomePage() {
        driver.get("https://www.booking.com/");
    }

    @When("I change language to {string}")
    public void iChangeLanguageTo(String language) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.selectLanguage(language);
    }

    @And("I add destination {string}")
    public void iAddDestination(String location) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.enterLocation(location);
    }

    @And("I add start and end date {string} {string}")
    public void iAddStartAndEndDate(String start, String end) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.selectDates(start, end);
    }

    @And("I add accommodation")
    public void iAddAccommodation() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.clickAccommodation();
        bookingHomePage.clickAdults();
        bookingHomePage.clickChildrenNumber();
        bookingHomePage.selectChildrenAge();
        bookingHomePage.clickUnit();


    }

    @And("I click search button {string}")
    public void iClickSearchButton(String arg0) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.clickSearchButton();

    }

    @And("I should see results")
    public void iShouldSeeResults() {
        SearchResultPage searchResultPage = new SearchResultPage(driver,wdWait);
        searchResultPage.checkResults();
    }


    @And("I click filter")
    public void iClickFilter() throws InterruptedException {
        SearchResultPage searchResultPage = new SearchResultPage(driver,wdWait);
        searchResultPage.clickFilter();

    }

    @And("I click a hotel button")
    public void iClickAHotelButton() {
        SearchResultPage searchResultPage = new SearchResultPage(driver,wdWait);
        searchResultPage.clickShowHotel();

    }

    @Then("I am on redirected page")
    public void iAmOnRedirectedPage() throws InterruptedException {
        RedirectedPage redirectedPage = new RedirectedPage(driver,wdWait);
        redirectedPage.checkHotelName();
    }
}



