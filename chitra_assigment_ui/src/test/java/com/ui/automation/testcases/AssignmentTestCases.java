package com.ui.automation.testcases;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class AssignmentTestCases {
    public static Log log = LogFactory.getLog(AssignmentTestCases.class);
    public WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public boolean testSetUp()
            throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/chitrapaliwal/Desktop/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("moz:loggingPrefs", "{\"browser\": \"ALL\"}");
        driver = new FirefoxDriver();
        driver.get("https://patinformed.wipo.int/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        return true;
    }
    @Test()
    public void assignment() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//input[@class='searchField']")).sendKeys("tavaborole");
            driver.findElement(By.xpath("//button[@class='green']")).click();
            List<WebElement> ele = driver.findElements(By.xpath("//tbody//tr//td//ul//li"));
            ele.get(0).click();
            List<Map<String, String>> map = new ArrayList<>();
            List<WebElement> row = driver.findElements(By.xpath("//family-details//ul[@class='results flex space-between']//li"));
            Thread.sleep(5000);
            for (int i = 1; i < row.size(); i++) {
                List<WebElement> columns = driver.findElements(By.xpath("//family-details//ul[@class='results flex space-between']//li[" + i + "]//tr"));
                Map<String, String> data = new HashMap<>();
                for (int j = 1; j < columns.size(); j++) {
                    List<WebElement> rowData = driver.findElements(By.xpath("//family-details//ul[@class='results flex space-between']//li[" + i + "]//tr[" + j + "]//td"));
                    data.put(rowData.get(0).getText(), rowData.get(1).getText());
                }

                map.add(data);
            }
            for (Map<String, String> mp : map) {
                if (mp.getOrDefault("Jurisdiction", "temp").equals("US- United States")) {
                    String filing_date_str = mp.get("Filing date");
                    String grant_date_str = mp.get("Grant date");
                    String extracted_filing_date_string = filing_date_str.substring(0, 10);
                    String extracted_grant_date_string = grant_date_str.substring(0, 10);
                    LocalDate date1 = LocalDate.parse(extracted_filing_date_string);
                    LocalDate date2 = LocalDate.parse(extracted_grant_date_string);
                    Period difference = Period.between(date1, date2);
                    log.info("Difference is "
                            + difference.getYears() + " years, "
                            + difference.getMonths() + " months, and "
                            + difference.getDays() + " days.");
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(true, "Test Execution Completed !!");
    }
        @AfterMethod(alwaysRun = true)
    public boolean testCleanUp() {
       driver.quit();
        return true;
    }
}


