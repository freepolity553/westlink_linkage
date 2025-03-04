package linkageTests;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;


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
        mainPanel.enterDashboard();
        users.enterUsersPage();
        users.enterText(users.searchModal,"Пользователь Тестирования");
        users.click(users.editUser);
        users.pictureUpload();
        users.enterText(users.phone, users.randomInt(11));
        users.save();

    }

}
