# Selenium

[![CI - Java](https://github.com/SeleniumHQ/selenium/actions/workflows/ci-java.yml/badge.svg)](https://github.com/SeleniumHQ/selenium/actions/workflows/ci-java.yml)

[Hassan Qayyum -- Hafiz Zeeshan](https://github.com/PMO-Tracker/API-Automation)

<a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="180" alt="Selenium"/></a>

Selenium is an umbrella project encapsulating a variety of tools and
libraries enabling web browser automation. Selenium specifically
provides an infrastructure for the [W3C WebDriver specification](https://w3c.github.io/webdriver/)
— a platform and language-neutral coding interface compatible with all
major web browsers.

The project is made possible by volunteer contributors who've
generously donated thousands of hours in code development and upkeep.

Selenium's source code is made available under the [Apache 2.0 license](https://github.com/SeleniumHQ/selenium/blob/trunk/LICENSE).

## Documentation

Narrative documentation:

* [User Manual](https://selenium.dev/documentation/)

API documentation:

* [Java](https://seleniumhq.github.io/selenium/docs/api/java/index.html)

## Requirements

    1.  Update the pom.xml file for successful tests execution.
    2.  brew install allure

## Directory Structure
    src/main/java/pages: Each page contains its locators and functions
    src/main/java/utils: It contains common code snippets like auth file etc
    src/main/java/resources: It contains global resources like global properties etc
    src/test/java/: It contains all test files like base test login test etc
    allure-results: It contains test results in the form of json files
    allure-report: It contains html report of all tests


## Commands
    mvn clean test: Cleans the project and removes all files generated by the previous build.
    mvn compile: Compiles source code of the project. 
    mvn test-compile: Compiles the test source code. 
    mvn test: Runs tests for the project.
    allure generate --clean: It generates the allure report
    allure serve: It displays the html report of all executed tests

## Important Files
    pom.xml: It contains all of the project plugins & dependencies
    testng.xml: It contains test the settings
