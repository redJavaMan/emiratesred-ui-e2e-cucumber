# EmiratesRed UI E2E Testing Framework

This repository contains an end-to-end (E2E) UI testing framework for the Emirates Red e-commerce platform using Cucumber, Selenium WebDriver, and Java.

## Overview

The framework implements Behavior-Driven Development (BDD) principles using Cucumber to create human-readable specifications that serve as both documentation and automated tests. The project structure follows the Page Object Model (POM) design pattern to create a maintainable and scalable test automation framework.

## Prerequisites

- Java JDK 11 (Corretto-11)
- Maven
- Chrome browser
- ChromeDriver (matching your Chrome browser version)

## Project Structure

```
emiratesred-ui-e2e-cucumber/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── emiratesred/
│       │           ├── config/
│       │           │   └── WebDriverManager.java
│       │           ├── hooks/
│       │           │   └── Hooks.java
│       │           ├── pages/
│       │           │   ├── HomePage.java
│       │           │   └── SearchResultsPage.java
│       │           ├── runners/
│       │           │   └── TestRunner.java
│       │           └── steps/
│       │               └── ProductSearchSteps.java
│       └── resources/
│           └── features/
│               └── ProductSearch.feature
└── pom.xml
```

## Components

### Page Objects

- **HomePage**: Represents the EmiratesRed homepage, providing methods to interact with search functionality.
- **SearchResultsPage**: Represents the search results page, providing methods to verify results and messages.

### Step Definitions

- **ProductSearchSteps**: Implements the steps defined in the ProductSearch.feature file, connecting the Gherkin language with the Java code.

### Hooks

- **Hooks**: Contains setup and teardown methods for each scenario, including screenshot capture for failed tests.

### Configuration

- **WebDriverManager**: Manages WebDriver instances, handling initialization and cleanup.

### Test Runner

- **TestRunner**: JUnit runner configured with Cucumber options to execute the feature files.

### Feature Files

- **ProductSearch.feature**: Contains Gherkin scenarios for testing the search functionality, including valid searches, no results, auto-suggestions, filters, and sorting.

## Getting Started

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/emiratesred-ui-e2e-cucumber.git
   ```

2. Navigate to the project directory:
   ```
   cd emiratesred-ui-e2e-cucumber
   ```

3. Install dependencies:
   ```
   mvn clean install
   ```

### Running Tests

To run all tests:
```
mvn test
```

To run specific tests using tags:
```
mvn test -Dcucumber.filter.tags="@YourTag"
```

## Configuration

Before running the tests, make sure to:

1. Update the `TestRunner.java` file with the correct path to your step definition package:
   ```java
   @CucumberOptions(
           features = "src/test/resources/features",
           glue = "com.emiratesred.steps", // Update this path
           tags = "@YourTag",
           plugin = {"pretty", "html:target/cucumber-reports"},
           monochrome = true
   )
   ```

2. Ensure ChromeDriver is correctly set up and accessible in your system PATH.

## Reporting

Test execution reports are generated in the `target/cucumber-reports` directory in HTML format. These reports provide detailed information about test execution, including pass/fail status and screenshots of failed tests.

## Best Practices

- Keep feature files focused on business scenarios, not technical implementation.
- Follow the Page Object Model pattern for better maintainability.
- Write reusable methods in page classes.
- Use descriptive names for methods and variables.
- Add comments for clarity where necessary.
- Handle dynamic elements and waits appropriately.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Author
Mohammed Lukmanudin M - [GitHub Profile](https://github.com/redJavaMan)
