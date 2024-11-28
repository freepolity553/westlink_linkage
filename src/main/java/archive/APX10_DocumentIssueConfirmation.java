package archive;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.LoginPage;
import utilites.ui.WebDriverSettings;

import java.time.Duration;


public class APX10_DocumentIssueConfirmation {

    private final WebDriver driver;

    public APX10_DocumentIssueConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Подтверждение выдачи документа по запросу")
    public void docIssueByRequestConfirmation() {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(WebDriverSettings.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();


        //Войти в Архив
        objArchivePage.accessArchive();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")).click();

        WebElement status1 = driver.findElement(By.xpath("(//span[contains(@class,'delivery-status done')])[1]"));
        Assert.assertNotNull(status1, "Not null");
        driver.navigate().refresh();

    }
}

