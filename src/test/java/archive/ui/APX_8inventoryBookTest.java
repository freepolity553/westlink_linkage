package archive.ui;

import archive.ArchivePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.ui.LoginPage;

import java.time.Duration;


public class APX_8inventoryBookTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void inventoryBookTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();

//Выбрать тестовый проект
        WebElement projectMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='m_label'][contains(.,'Проект')]")));
        projectMenu.click();
        WebElement project = driver.findElement(By.xpath("//button[@class='dropdown-item dd-menu__item'][contains(.,'AQA123 AQA Проект')]"));
        action.moveToElement(project).click().perform();

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

