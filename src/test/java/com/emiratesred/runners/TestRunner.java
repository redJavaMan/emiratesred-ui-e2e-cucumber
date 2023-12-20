package com.emiratesred.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // path to your feature files
        glue = "your.stepdefinition.package", // path to your step definition package
        tags = "@YourTag", // specify tags to run specific tests
        plugin = {"pretty", "html:target/cucumber-reports"}, // plugins for reporting
        monochrome = true // set to true for more readable console output
)
public class TestRunner {
    // No code is required inside the runner class
}

