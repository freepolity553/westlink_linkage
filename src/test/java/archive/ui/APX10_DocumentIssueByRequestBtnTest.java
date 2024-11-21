package archive.ui;

import archive.ArchivePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.ui.LoginPage;

import java.time.Duration;


public class APX10_DocumentIssueByRequestBtnTest extends WebDriverSettings {




    @Test(priority=6)
    public void docIssueByRequestBtnTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();


        //Выбрать документ для запроса
        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Выдать по запросу')]")));
        doc.click();

        WebElement doc1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выдать документы'])[1]/following::*[name()='svg'][1]")));
        doc1.click();

        WebElement issue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Выдать')]")));
        issue.click();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ВЫДАТЬ')]")).click();
        driver.navigate().refresh();

    }
}

