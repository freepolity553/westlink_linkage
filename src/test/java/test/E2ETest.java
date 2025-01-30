package test;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.linkageAdministration.Groups;
import settings.Constants;

import java.time.Duration;


public class E2ETest extends TestBase {

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
        groups.enterGroupsPage();
        groups.createGroup();
        groups.back();
        users.click(users.usersTab);
        users.click(users.addUserBtn);
        users.pictureUpload();
        users.enterText(users.phone, users.randomInt(11));
        users.addGroup();
//        users.save();

    }
}
