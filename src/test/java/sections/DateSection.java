package sections;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class DateSection {

    Page page;

    private final String datepickerSelector = "#datepicker";
    private final String nextButtonSelector = ".ui-datepicker-next";
    private final String monthTextSelector = ".ui-datepicker-month";
    private final String yearTextSelector = ".ui-datepicker-year";
    private final String daySelector = "a[data-date='17']";

    public DateSection(Page page) {
        this.page = page;
    }

    public String getSelectedDate() {
        return page.locator(datepickerSelector).inputValue();
    }

    public void selectDate1(String expectedMonth, String expectedYear) {

        Locator datepicker = page.locator(datepickerSelector);
        datepicker.click();

        page.locator(nextButtonSelector).waitFor();

        while (true) {
            String currentMonth = page.locator(monthTextSelector).innerText();
            String currentYear = page.locator(yearTextSelector).innerText();

            if (currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear)) {
                break;
            }

            page.locator(nextButtonSelector).click();
        }

        page.locator(daySelector).click();
    }
}






