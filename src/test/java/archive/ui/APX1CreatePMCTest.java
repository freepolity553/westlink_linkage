package archive.ui;

//import baseSettings.WebDriverSettings;


import archive.ArchivePage;
import archive.QueryDBui;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.LoginPage;
import utilites.RandomValue;

import java.io.File;
import java.sql.*;
import java.time.Duration;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class APX1CreatePMCTest extends WebDriverSettings {


    @Test
    public void addPMCTest()  {
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

        //Выбрать первый документ из списка
        WebElement checkBox = driver.findElement(By.xpath("//app-archive-list-chief/div/div[2]/div[1]/div[1]/app-archive-list-checkbox/app-checkbox/app-icon-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

//        WebElement checkBox1 = driver.findElement(By.xpath("//app-archive-list-chief/div/div[2]/div[3]/div[1]/app-archive-list-checkbox/app-checkbox/app-icon-button"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox1);




        //Создание РВИ
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'РВИ 1')]")).click();

        //Номер разрешения
        driver.findElement(By.xpath("//input[contains(@class,'s ng-untouched ng-pristine ng-valid')]")).sendKeys(randomValue.pmcNum(2));

        //Добавить том из списка
//        driver.findElement(By.xpath("//span[@class='m_text'][contains(.,'ТОМ')]")).click();
//        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'Том QA1')]")).click();

        //Добавить лист
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Добавить лист')]")).click();

        driver.findElement(By.xpath("//textarea[contains(@rows,'3')]")).sendKeys("Содержание изменения");
        driver.findElement(By.xpath("//textarea[contains(@rows,'2')]")).sendKeys("Примечание");

        //Добавить файл
        File uploadFile = new File("src/test/resources/file.txt");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        WebElement file=driver.findElement (By.xpath("//span[contains(@class,'filename')]"));
        Assert.assertNotNull(file);


        //Добавить сотрудников
        //Изменения внес
        driver.findElement(By.xpath("//div[2]/app-archive-permission-person[1]/div/div[2]/app-icon-button/span/app-icon/span")).click();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mtable__col col__fio'][1]")));
        element.click();

        //Составил
        driver.findElement(By.xpath("//div[2]/app-archive-permission-person[2]/div/div[2]/app-icon-button/span/app-icon/span")).click();
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mtable__col col__fio'][1]")));
        element1.click();

        //ГИП
        driver.findElement(By.xpath("//div[2]/app-archive-permission-person[3]/div/div[2]/app-icon-button/span/app-icon/span")).click();
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mtable__col col__fio'][1]")));
        element2.click();


        //Утвердил
        driver.findElement(By.xpath("//div[2]/app-archive-permission-person[4]/div/div[2]/app-icon-button/span/app-icon/span")).click();
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mtable__col col__fio'][1]")));
        element3.click();

        //Н. Контр.
        driver.findElement(By.xpath("//div[2]/app-archive-permission-person[5]/div/div[2]/app-icon-button/span/app-icon/span")).click();
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mtable__col col__fio'][1]")));
        element4.click();

        WebElement num = driver.findElement(By.xpath("//div[1]/app-card-input/app-card-row/div/div[2]/div/input"));
        String numPMC = num.getAttribute("value");
        System.out.println("Номер РВИ " + numPMC);

        //Отправить на подписание
        driver.findElement (By.xpath("//button[@class='primary'][contains(.,'ОТПРАВИТЬ НА ПОДПИСАНИЕ')]")).click();

        WebElement alert=driver.findElement (By.xpath("//span[contains(.,'Разрешение на внесение изменений отправлено на подпись')]"));
        String actualAlert = alert.getText();
        Assert.assertEquals(actualAlert,"Разрешение на внесение изменений отправлено на подпись","Неверное подтверждение");

        //Проверка создания РВИ в БД
        try {
            String testData = QueryDBui.data();
            System.out.println(testData);
            Assert.assertEquals(testData, numPMC,"Отличия по РВИ");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

