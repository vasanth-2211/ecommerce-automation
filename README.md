#Ecommerce Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange)
![Selenium](https://img.shields.io/badge/Selenium-Automation-green)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)

------------------------------------------------------------------------

##Overview

A scalable and production-ready UI Automation Framework built using
**Java + Selenium + TestNG**, following real-world SDET practices.

------------------------------------------------------------------------

##Features

- Locator-based Page Object Model (By instead of WebElement)
- Centralized reusable actions (BasePage)
- Smart WaitUtils for stability
- Extent Reports with screenshots
- JSON Data-driven testing
- Retry mechanism for flaky tests
- Parallel execution (Chrome/Firefox)
- Environment-based configuration

------------------------------------------------------------------------

## Project Structure

    src
     ├── main/java
     │   ├── base
     │   ├── pages
     │   ├── utils
     │
     ├── test/java
     │   ├── tests
     │   ├── listeners
     │
     ├── test/resources
     │   ├── testng-*.xml
     │   ├── config-*.properties
     │   ├── testdata

------------------------------------------------------------------------

## Run Tests

### Chrome

    mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng-chrome.xml

### Firefox

    mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng-firefox.xml

### Safari

    mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng-safari.xml

------------------------------------------------------------------------

## Environment Support

    mvn test -Denvironment=qa

Supports: - QA - DEV - STAGE (extendable)

------------------------------------------------------------------------

## Reports

Generated at:

    /reports/extent-report.html

Includes: - Step logs - Screenshots - Pass/Fail status

------------------------------------------------------------------------

## Retry Logic

    maxRetries=3

Automatically retries failed tests.

------------------------------------------------------------------------

## Highlights

- Clean architecture (no driver misuse)
- Thread-safe execution
- Production-level logging
- Highly maintainable & scalable

------------------------------------------------------------------------

## Author

**Vasanth R**
QA Automation Engineer | Aspiring SDET

------------------------------------------------------------------------
