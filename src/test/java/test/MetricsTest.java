package test;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.Constants;

//import java.time.Duration;


public class MetricsTest extends TestBase {


    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "",priority = 1)
    @Step("")
    public void  addMetricRequestTest() {
        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
        metrics.click(metrics.constructorMetrics);
        metrics.addSQLMetric();



    }

}
