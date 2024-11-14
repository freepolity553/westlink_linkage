package archive.ui;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import archive.ArchivePage;
import settings.WebDriverSettings;
import utilites.LoginPage;
import utilites.RandomValue;

import java.io.File;
import java.time.Duration;

public class APX4_AddDocumentTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void addDocumentTest()  {
        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();



        WebElement addDocument = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Документ')]")));
        addDocument.click();
        //driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите шифр')]")).click();

        //Выбрать тестовый проект и шифр
        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите проект')]")).click();
        driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')])[2]")).click();
        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите шифр')]")).click();
        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'ТОМ 1-AQA')]")).click();

        //Номер версии
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).clear();
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(randomValue.randomInt(1));

        //Добавить файл
        File uploadFile = new File("src/test/resources/Акт_списания.pdf");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());


        WebElement buttonDocRegistryWindow = driver.findElement (By.xpath("(//button[@class='primary'][contains(.,'ЗАРЕГИСТРИРОВАТЬ')])[1]"));
        String actualbuttonDocRegistryWindow = buttonDocRegistryWindow.getText();
        Assert.assertEquals(actualbuttonDocRegistryWindow,"ЗАРЕГИСТРИРОВАТЬ","Missing button");

        WebElement buttonDocCancellationWindow = driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'ОТМЕНА')]"));
        String actualbuttonDocCancellationWindow = buttonDocCancellationWindow.getText();
        Assert.assertEquals(actualbuttonDocCancellationWindow,"ОТМЕНА","Missing button");

        buttonDocRegistryWindow.click();

        WebElement alert = driver.findElement (By.xpath("//span[contains(.,'Версия документа загружена')]"));
        String actualAlert = alert.getText();
        Assert.assertEquals(actualAlert,"Версия документа загружена","Missing alert");



    }
}

