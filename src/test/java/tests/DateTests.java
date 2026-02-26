package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import sections.DateSection;
import utils.WebDriverUtils;

public class DateTests {

    WebDriver driver;
    DateSection dateSection;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {

        System.out.println(">>> TestNG browser = " + browser);

        driver = WebDriverUtils.initializeDriver(browser);
        driver.get("https://testautomationpractice.blogspot.com/");

        WebDriverWait wait = WebDriverUtils.createWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieChoiceDismiss"))).click();

        dateSection = new DateSection(driver);
    }

    @Test
    public void datePicker1Test() {

        dateSection.selectDate1("July", "2026");
        String selectedDate = dateSection.getSelectedDate();
        Assert.assertEquals(selectedDate, "07/17/2026");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}



