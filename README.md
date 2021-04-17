# test-automation-practice

The repo to test automation practice on http://automationpractice.com/index.php

### Problem statement

Go to http://automationpractice.com/index.php and using Java, write an automated test/s to verify
that summer dresses can be added to the cart and it’s possible to proceed to the Sign in section.

### Pre-requisites

- Java 11
- Maven
- [Chrome driver](https://chromedriver.chromium.org/downloads)

### How to setup project

1. Please install tools listed in **Pre-requisites** section.
2. Download appropriate version of [chrome driver](https://chromedriver.chromium.org/downloads)
   based on OS and local chrome browser version.
3. Copy chrome driver into **<project-dir>/chrome/** directory.

**P.S:** The project is already configured with **chrome driver version 89** for **MacOS**. Please
ignore step 2 and step 3 if you are using **MacOS** and **Chrome version 89**.

### How to run tests

`# mvn clean test`

### How to run test from IDE

Go to class **RunCucumberTest** in **com.test.automation** package and run it.

Or

Go to **automation-practice.feature** in test resources directory and run it (Make sure cucumber
plugin is installed in IDE)

### Test reports

The test reports are published to https://reports.cucumber.io/, the unique test report link is
generated after test execution and can be found on console.

### Libraries & Frameworks

- JUnit 5.7.1
- Selenium 4.0.0-beta-2
- Cucumber 6.10.3
