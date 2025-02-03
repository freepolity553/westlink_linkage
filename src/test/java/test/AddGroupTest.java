package test;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class AddGroupTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  addGroupTest() {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        dashboard.enterDashboard();
        users.enterUsersPage();
        groups.click(groups.groupsTab);
//        groups.threadSleep(5000);
        groups.createGroup();
        users.save();

    }

}
