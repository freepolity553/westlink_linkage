package test;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.Constants;


public class CreateNewUserTest extends TestBase {


    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  createNewUserTest() {
        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
        users.enterUsersPage();
        users.click(users.addUserBtn);
        users.pictureUpload();
        users.enterText(users.phone, users.randomInt(11));
        users.enterText(users.lastName, users.useLastName());
        users.enterText(users.firstName, "Тест");
        users.enterText(users.email, users.mockEmail);
        users.enterText(users.login, users.mockName);
        System.out.println(users.mockName);
        users.enterText(users.password, users.mockName);
        users.threadSleep(3000);
        users.save();
        users.back();
//        users.waitVisibility(users.userStatus);


    }

}
