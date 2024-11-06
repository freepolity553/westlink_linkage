package archive.ui;

import archive.ArchivePage;
import archive.QueryDBui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.LoginPage;
import utilites.RandomValue;

import java.time.Duration;


public class APX_9docRequestTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void docRequestTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        QueryDBui db = new QueryDBui();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();

        //Выбрать тестовый проект
        WebElement project = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='m_label'][contains(.,'Проект')]")));
        project.click();
        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')]")).click();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")).click();


        driver.findElement(By.xpath("(//div[contains(@class,'mtable__col col__payload')])[1]")).click();

        driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")).click();


//        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'Запросить выдачу : 1')]")).click();

        driver.findElement(By.xpath("//textarea[contains(@class,'ng-untouched ng-pristine ng-valid')]")).sendKeys("Комментарий для выдачи");

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАПРОСИТЬ')]")).click();



//        WebElement status = driver.findElement (By.xpath("(//div[contains(.,'Запрос на выдачу документа отправлен')])[7]"));
//        String actualStatus = status.getText();
//        Assert.assertEquals(true,actualStatus.contains("Запрос на выдачу документа отправлен"),"Запрос не отправлен");

        WebElement status = driver.findElement (By.xpath("(//div[contains(.,'Запрос на выдачу документа отправлен')])[7]"));
        String actualAlert = status.getText();
        Assert.assertEquals(actualAlert,"Запрос на выдачу документа отправлен","Запрос не отправлен");


//        WebElement version = driver.findElement (By.xpath("//div[@class='top__item__label'][contains(.,'Версия:')]"));
//        String actualVersion = version.getText();
//        Assert.assertEquals(true,actualVersion.contains("Версия"),"Missing version");

    }
}

