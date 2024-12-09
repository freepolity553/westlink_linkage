package test;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.Constants;


public class LoginTest extends TestBase1 {

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  loginTest() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);

    }
    @Epic("Testing")
    @Feature(value = "Feature 111")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing 111 description")
    @Story(value = "Story 111 description")
    @Test(description = "Login Archivarius",priority = 2)
    @Step("loginArch")
    public void  loginTest1() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);
        main.clickArchiveMenu();
        archiveMain.checkAllElementsOnPagePresent();

    }

    @Epic("Testing")
    @Feature(value = "Feature 111")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing 111 description")
    @Story(value = "Story 111 description")
    @Test(description = "Login Archivarius",priority = 2)
    @Step("loginArch")
    public void  addNewVersion() {


        login.loginArch(Constants.USERNAME_CPE, Constants.PASSWORD_CPE);
        main.clickArchiveMenu();
        archiveMain.addNewVersion();
        archiveAddVersion.fileUpload();


    }
}
