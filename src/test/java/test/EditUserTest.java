package test;

import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;
import utilites.RandomValue;

import java.time.Duration;
import java.util.Random;


public class EditUserTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  editUserTest() {
        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        dashboard.enterDashboard();
        users.enterUsersPage();
        users.enterText(users.usernameSearch,"Пользователь Тестирования");
        users.click(users.editUser);
        users.pictureUpload();
        String str = RandomStringUtils.randomNumeric(11);
        users.enterText(users.phone, str);

    }

}
