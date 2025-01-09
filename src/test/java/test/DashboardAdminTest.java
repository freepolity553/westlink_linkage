package test;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;


public class DashboardAdminTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  loginAdminTest() {
        login.loginAdmin(Constants.USERNAME_ADMIN, Constants.PASSWORD_ADMIN);
        login.checkAllElementsOnPagePresent();
        dashboard.enterDashboard();
        dashboard.checkAllElementsOnPagePresent();
    }

}
