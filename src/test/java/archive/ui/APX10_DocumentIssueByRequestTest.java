package archive.ui;

import archive.ArchivePage;
import archive.QueryDBui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import pages.LoginPage;
import utilites.ui.RandomValue;

import java.time.Duration;


public class APX10_DocumentIssueByRequestTest extends WebDriverSettings {




    @Test
    public void docRequestGipTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        QueryDBui db = new QueryDBui();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();

//        //Выбрать тестовый проект
//        objArchivePage.selectTestProjectArch();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //Выбрать документ для запроса
        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Выдать по запросу')]")));
        doc.click();


//        WebElement addDocument = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Документ')]")));
//        addDocument.click();
//        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Выдать по запросу')]")).click();
        driver.findElement(By.xpath("//app-archiveMain-main/app-archiveMain-out-list/div/div/div[1]/div[1]")).click();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Выдать')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ВЫДАТЬ')]")).click();

//        WebElement alert = driver.findElement (By.xpath("//span[contains(.,'Выдан 1документ')]"));
//        String actualAlert1 = alert.getText();
//        Assert.assertEquals(actualAlert1 ,"Выдан 1документ","Нет подтверждения");

        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        //Войти в Архив
        objArchivePage.accessArchive();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")).click();

        WebElement status1 = driver.findElement (By.xpath("(//span[contains(@class,'delivery-status done')])[1]"));
//        String actualstatus = status.getText();
        Assert.assertNotNull(status1 ,"Not null");



    }
}

