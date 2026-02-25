package listeners;

import com.aventstack.extentreports.*;
import org.testng.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import com.microsoft.playwright.Page;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    private Page page;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed: " + result.getThrowable());

        Object currentPage = result.getTestContext().getAttribute("page");
        if (currentPage != null && currentPage instanceof Page) {
            page = (Page) currentPage;
            String screenshotPath = "target/screenshots/" + result.getMethod().getMethodName() + ".png";
            page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get(screenshotPath)));
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) { }
}


