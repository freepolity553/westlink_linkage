package test;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.Constants;


public class LoginTest extends TestBase1 {

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Step("login")
    public void  loginTest() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);

    }
    @Epic("Testing")
    @Feature(value = "Feature")
    @Test
    @Step("loginArch")
    public void  loginTest1() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);
        main.clickArchiveMenu();
        archive.checkAllElementsOnPagePresent();

    }
}
