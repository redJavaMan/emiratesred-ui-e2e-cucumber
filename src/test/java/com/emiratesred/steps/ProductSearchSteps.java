package com.emiratesred.steps;
import com.emiratesred.pages.HomePage;
import com.emiratesred.pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class ProductSearchSteps {
        private WebDriver driver;
        private HomePage homePage;
        private SearchResultsPage searchResultsPage;

        @Given("I am on the EmiratesRed homepage")
        public void i_am_on_the_emiratesred_homepage() {
            driver = new ChromeDriver(); // Ensure ChromeDriver is set up correctly
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
            homePage.goToHomePage();
        }

        @When("I enter {string} into the search box")
        public void i_enter_into_the_search_box(String searchText) {
            homePage.enterSearchText(searchText);
        }

        @And("I click the search button")
        public void i_click_the_search_button() {
            homePage.clickSearchButton();
            searchResultsPage = new SearchResultsPage(driver);
        }

        @Then("I should see a list of products related to {string}")
        public void i_should_see_a_list_of_products_related_to(String searchText) {
            assertTrue("Search results not related to search text", searchResultsPage.verifyResults(searchText));
        }

        @Then("I should see a message indicating no products found")
        public void i_should_see_a_message_indicating_no_products_found() {
            assertTrue("No products found message not displayed", searchResultsPage.verifyNoResultsMessage());
        }

        // Implement other steps related to auto-suggestions, filters, and sorting

        // Don't forget to close the WebDriver
        @After
        public void closeBrowser() {
            driver.quit();
        }
    }


