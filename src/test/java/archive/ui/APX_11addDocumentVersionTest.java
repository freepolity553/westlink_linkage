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

import java.io.File;
import java.time.Duration;

public class APX_11addDocumentVersionTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test(invocationCount = 1)
    public void addDocumentVersionTest()  {

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


        //Нажать кнопку Версия
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Версия')]")).click();
        //Выбрать тестовый проект
        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите проект')]")).click();
        driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')])[2]")).click();

        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите шифр')]")).click();
        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'ТОМ 1-AQA')]")).click();


        WebElement status = driver.findElement (By.xpath("//div[@class='value'][contains(.,'Служебный')]"));
        String actualStatus = status.getText();
        Assert.assertEquals(actualStatus,"Служебный","Неправильное значение");


        //Добавить файл
        File uploadFile = new File("src/test/resources/Акт_списания.pdf");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        WebElement buttonDocCancellationWindow = driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'ОТМЕНА')]"));
        String actualbuttonDocCancellationWindow = buttonDocCancellationWindow.getText();
        Assert.assertEquals(actualbuttonDocCancellationWindow,"ОТМЕНА","Missing button");

        driver.findElement(By.xpath("(//button[@class='primary'][contains(.,'ЗАГРУЗИТЬ')])[2]")).click();

        WebElement alertVersion = driver.findElement (By.xpath("//div[@class='toasts__item'][contains(.,'Версия документа загружена')]"));
        String actualAlertVersion = alertVersion.getText();
        Assert.assertEquals(actualAlertVersion,"Версия документа загружена","Missing alert");





    }
}

