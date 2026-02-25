package utils;

import com.microsoft.playwright.*;

public class PlaywrightUtils {
    public static Browser createBrowser(Playwright playwright, String browserName) {

        BrowserType browserType;

        if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        } else {
            browserType = playwright.chromium();
        }

        return browserType.launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
    }

    public static Page createPage(Browser browser) {
        BrowserContext context = browser.newContext();
        return context.newPage();
    }
}

