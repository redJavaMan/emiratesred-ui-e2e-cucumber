package com.emiratesred.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultsPage {
        private WebDriver driver;

        // Example locators - these will need to be updated to match the website's actual locators
        private By resultsLocator = By.cssSelector(".product-list-item"); // Replace with actual CSS selector of product list items
        private By noResultsMessageLocator = By.cssSelector(".no-results-message"); // Replace with actual CSS selector of the 'no results' message

        // Constructor
        public SearchResultsPage(WebDriver driver) {
            this.driver = driver;
        }

        // Method to verify if the results are related to the search term
        public boolean verifyResults(String searchTerm) {
            List<WebElement> results = driver.findElements(resultsLocator);
            for (WebElement result : results) {
                if (!result.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
                    return false;
                }
            }
            return !results.isEmpty();
        }

        // Method to verify the 'no results found' message
        public boolean verifyNoResultsMessage() {
            WebElement noResultsMessage = driver.findElement(noResultsMessageLocator);
            return noResultsMessage.isDisplayed();
        }

        // Additional methods as per the functionality of the search results page can be added
    }


