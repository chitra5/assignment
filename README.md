PAT-INFORMED Test Cases Assignment 
Below are the Test Cases written under src/test-
- Difference between Grant and Filing Year TC

Tools and Technologies
Selenium WebDriver: Automation tool for web applications.
Java: Programming language used for writing the test scripts.
Firefox WebDriver (GeckoDriver): Driver used to automate Firefox browser interactions.
TestNG:Testing framework for organizing and executing the test cases.
Maven: install dependency and build project

**Steps to Run Project**
## Prerequisites

Before you can run the tests, ensure that you have the following installed:

- **Java Development Kit (JDK)**: Version 8.
- **Maven**: For managing the project build and dependencies.
- **Firefox Browser**: Required for executing tests on Firefox.
- **Geckodriver**: WebDriver for Firefox browser.

## Installation Guide

### 1. Firefox Download and Install

Download and install the Firefox browser from the official Mozilla website:

- [Download Firefox](https://www.mozilla.org/firefox/new/)

### 2. Download Geckodriver Version 35 for Mac/Windows

To run Selenium tests on Firefox, you need to install Geckodriver:

- [Download Geckodriver](https://github.com/mozilla/geckodriver/releases/tag/v0.35.0)

Choose the appropriate version for your operating system (Mac or Windows).

### 3. Set Up Geckodriver Path

After downloading Geckodriver:

1. Extract the downloaded file.
2. Copy the path to the `geckodriver` executable file.
3. Paste the path inside your `AssignmentTestCases` file on **line no. 28**.
4. Example:

```java
System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
```
### 4. Execute the Project
mvn clean install test

