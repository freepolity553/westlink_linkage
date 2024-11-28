package archive.ui;

//import baseSettings.WebDriverSettings;


import archive.ArchivePage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class APX1_CreatePMCTest extends WebDriverSettings {

    @Test(priority = 2)
    @Description("Загрузка версии документов")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-11", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/11-zagruzka-versii-dokumentov/")
    @Issue("SODIT-342")
    @Epic("Архив")
    @Feature("")
    @Story("Загрузка версии документов")
    public void addPMCTest() {

        LoginPage login = new LoginPage(driver);
        Actions action = new Actions(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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


        //Выбрать первый документ из списка
        WebElement checkBox = driver.findElement(By.xpath("//app-archive-list-chief/div/div[2]/div[1]/div[1]/app-archive-list-checkbox/app-checkbox/app-icon-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

        //Создание РВИ
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'РВИ 1')]")).click();

        //Номер разрешения
        driver.findElement(By.xpath("//input[contains(@class,'s ng-untouched ng-pristine ng-valid')]")).sendKeys(randomValue.pmcNum(2));

        //Добавить лист
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Добавить лист')]")).click();

        driver.findElement(By.xpath("//textarea[contains(@rows,'3')]")).sendKeys("Содержание изменения");
        driver.findElement(By.xpath("//textarea[contains(@rows,'2')]")).sendKeys("Примечание");


        //Добавить файл
        objArchivePage.uploadFile();


        WebElement file = driver.findElement(By.xpath("//span[contains(@class,'filename')]"));
        Assert.assertNotNull(file);


        //Добавить сотрудников
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        objArchivePage.addEmployees();

        //Изменения внес
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Изменения внес'])[1]/following::*[name()='svg'][1]")));
        elem.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement elem1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        elem1.click();
//            driver.findElement(By.xpath("")).click();
//            driver.findElement(By.xpath("")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Составил
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Составил'])[1]/following::*[name()='svg'][1]")));
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        element1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //ГИП
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ГИП'])[1]/following::*[name()='svg'][1]")));
        element2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        element3.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Утвердил
        WebElement elem2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Утвердил'])[1]/following::*[name()='svg'][1]")));
        elem2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[5]")));
        element5.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Н. Контр.
        WebElement element7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Н. Контр.'])[1]/following::*[name()='svg'][1]")));
        element7.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[5]")));
        element6.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement num = driver.findElement(By.xpath("//div[1]/app-card-input/app-card-row/div/div[2]/div/input"));
        String numPMC = num.getAttribute("value");
        System.out.println("Номер РВИ " + numPMC);

        //Отправить на подписание
        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ОТПРАВИТЬ НА ПОДПИСАНИЕ')]")).click();

        WebElement alert = driver.findElement(By.xpath("//span[contains(.,'Разрешение на внесение изменений отправлено на подпись')]"));
        String actualAlert = alert.getText();
        Assert.assertEquals(actualAlert, "Разрешение на внесение изменений отправлено на подпись", "Неверное подтверждение");
        driver.navigate().refresh();

        //Проверка создания РВИ в БД
//        try {
//            String testData = QueryDBui.data();
//            System.out.println(testData);
//            Assert.assertEquals(testData, numPMC, "Отличия по РВИ");
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}


