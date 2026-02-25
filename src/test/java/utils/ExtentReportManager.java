package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.nio.file.Paths;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {

            String reportPath = Paths.get(System.getProperty("user.dir"), "target", "extent-report.html").toString();

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            reporter.config().setReportName("Date Picker Automation");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}





