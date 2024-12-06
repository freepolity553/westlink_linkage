package test;

import io.qameta.allure.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import settings.Constants;


public class LoginCrossBrTest extends CrossBr {

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")
    @Parameters({ "browser" })
    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  loginTest() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);
        cookies = driver.manage().getCookies();

    }
    @Epic("Testing")
    @Feature(value = "Feature 111")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing 111 description")
    @Story(value = "Story 111 description")
    @Parameters({ "browser" })
    @Test(description = "Login Archivarius",priority = 2)
    @Step("loginArch")
    public void  loginTest1() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);
        main.clickArchiveMenu();
        archive.checkAllElementsOnPagePresent();
        cookies = driver.manage().getCookies();

    }
}
