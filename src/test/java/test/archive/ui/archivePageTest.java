package test.archive.ui;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;
import test.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class archivePageTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));


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
