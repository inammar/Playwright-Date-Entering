package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {

            ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");

            reporter.config().setReportName("Date Picker Automation");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}

