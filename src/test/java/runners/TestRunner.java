package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ExtentReportManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        ExtentReportManager.initReports();
    }

    @AfterClass
    public static void tearDown() {
        ExtentReportManager.flushReports();
    }
}
