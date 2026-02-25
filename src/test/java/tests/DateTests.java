package tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import sections.DateSection;
import utils.PlaywrightUtils;

public class DateTests {

    Playwright playwright;
    Browser browser;
    Page page;
    DateSection dateSection;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) {

        playwright = Playwright.create();
        browser = PlaywrightUtils.createBrowser(playwright, browserName);
        page = PlaywrightUtils.createPage(browser);

        page.navigate("https://testautomationpractice.blogspot.com/");

        page.locator("#cookieChoiceDismiss").click();

        dateSection = new DateSection(page);
    }

    @Test
    public void datePicker1Test() {

        dateSection.selectDate1("July", "2026");
        String selectedDate = dateSection.getSelectedDate();
        Assert.assertEquals(selectedDate, "07/17/2026");
    }

    @AfterMethod
    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
