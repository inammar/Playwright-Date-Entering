package sections;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DateSection {

    WebDriver driver;
    WebDriverWait wait;

    private final By datepicker1 = By.id("datepicker");
    private final By nextbutton = By.cssSelector(".ui-datepicker-next");
    private final By monthtext = By.className("ui-datepicker-month");
    private final By yeartext = By.className("ui-datepicker-year");
    private final By dayselection1 = By.cssSelector("a[data-date='17']");

    public DateSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getSelectedDate() {
        return driver.findElement(datepicker1).getAttribute("value");
    }

    public void selectDate1(String expectedMonth, String expectedYear) {

        WebElement datePicker = wait.until(
                ExpectedConditions.elementToBeClickable(datepicker1)
        );

        datePicker.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(nextbutton));

        while (true) {
            String currentMonth = driver.findElement(monthtext).getText();
            String currentYear = driver.findElement(yeartext).getText();

            if (currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear)) {
                break;
            }

            driver.findElement(nextbutton).click();
        }

        driver.findElement(dayselection1).click();
    }
}







