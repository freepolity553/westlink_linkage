package test;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;



public class CreateOrgTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  createOrgTest() {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
        users.enterUsersPage();
        organization.addOrg();
//        WebElement elm = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-colindex='1' and contains(@class, 'rdg-cell')]"));
//        String newOrg  = elm.getText();
//        System.out.println("Org name1: " + newOrg);
//
//        assertEquals( organization.useOrgName(),newOrg);
//        users.save();


    }

}
