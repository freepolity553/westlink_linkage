package test;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;


public class MetricsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("")
    public void  addMetricRequestTest() {
        login.loginAdmin(Constants.USERNAME_ADMIN, Constants.PASSWORD_ADMIN);
        dashboard.enterDashboard();
        metrics.enterMetricsConstructor();
        metrics.addMetric("Показатель "+ randomValue.randomInt(3));



    }

}
