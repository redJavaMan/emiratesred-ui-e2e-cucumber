package com.emiratesred.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // Web element locators
    private By searchBox = By.id("searchBoxId");
    private By searchButton = By.id("searchButtonId");
    private By closePopUp = By.xpath("//div[@class='close']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the homepage
    public void goToHomePage() {
        driver.get("https://www.emiratesred.com");
        driver.findElement(closePopUp).click();
    }

    // Method to enter search text
    public void enterSearchText(String text) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.clear();
        searchBoxElement.sendKeys(text);
    }

    // Method to click the search button
    public SearchResultsPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}
