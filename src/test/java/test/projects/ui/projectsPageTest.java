package test.projects.ui;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.projects.ProjectsMain;
import settings.Constants;
import test.TestBase;

import java.time.Duration;


public class projectsPageTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));




    @Epic("Testing")
    @Feature(value = "Feature 111")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing 111 description")
    @Story(value = "Story 111 description")
    @Test(description = "Login Archivarius",priority = 2)
    @Step("loginArch")
    public void  mainProjectPageAllElements() {


        login.loginArch(Constants.USERNAME_CPE, Constants.PASSWORD_CPE);
        main.clickProjectsMenu();
        projectsMain.checkAllElementsOnPagePresent();


    }
}
