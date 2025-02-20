package test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;


public class LoginAdminDevTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")


    @Test(description = "Login",priority = 2)
    @Step("login into Admin MainPanel")
    public void  loginDashboardTest() {
        driver.findElement(By.xpath("//p[@class='SelectARM_cardName__ARdPm'][contains(.,'АРМ Администратора')]")).click();
        //mainPanel.enterDashboard();
    }
}
