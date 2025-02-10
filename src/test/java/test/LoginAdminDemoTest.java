package test;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class LoginAdminDemoTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  loginAdminTest() {
        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        login.checkAllElementsOnPagePresent();

    }
    @Test(description = "Login",priority = 2)
    @Step("login into Admin MainPanel")
    public void  loginDashboardTest() {
        mainPanel.enterDashboard();
    }
}
