package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportNG {


    @Test
    public static ExtentReports reportConfig() {

        String path = (System.getProperty("user.dir") + "/test-output/extentReport.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Swag Lab Demo Report");
        reporter.config().setReportName("Test Report");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Project Name" , "Swag Lab Demo");
        return extent;


    }


}
