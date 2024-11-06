package archive.ui;


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

import java.time.Duration;

public class APX_13versionRegistrationTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void versionRegistrationTest()  {

        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        QueryDBui db = new QueryDBui();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Регистрация 1')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ОТПРАВИТЬ')]")).click();


//        //Перейти в карточку документа
//        driver.findElement(By.xpath("//div[@class='mtable__col col__name'][contains(.,'ТОМ 1-AQA')]")).click();
//        //Выбрать версию со статусом Служебный
//        driver.findElement(By.xpath("(//div[@class='mtable__col col__status'][contains(.,'Служебный')])")).click();
//        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Зарегистрировать')]")).click();
//
//        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАРЕГИСТРИРОВАТЬ')]")).click();


        WebElement alertRegistration = driver.findElement (By.xpath("//span[contains(.,'Документы отправлены на регистрацию')]"));
        String actualAlertRegistration = alertRegistration.getText();
        Assert.assertEquals(actualAlertRegistration,"Документы отправлены на регистрацию","Missing alert");

    }
}

