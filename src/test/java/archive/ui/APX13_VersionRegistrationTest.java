package archive.ui;


import archive.ArchivePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import pages.LoginPage;

import java.time.Duration;

public class APX13_VersionRegistrationTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void versionRegistrationTest()  {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();

        //Выбрать тестовый проект
        objArchivePage.selectTestProject();

        //Выбрать первый документ из списка
        WebElement checkBox = driver.findElement(By.xpath("//app-archive-list-chief/div/div[2]/div[1]/div[1]/app-archive-list-checkbox/app-checkbox/app-icon-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Регистрация 1')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ОТПРАВИТЬ')]")).click();

        WebElement alertRegistration = driver.findElement(By.xpath("//span[contains(.,'Документы отправлены на регистрацию')]"));
        String actualAlertRegistration = alertRegistration.getText();
        Assert.assertEquals(actualAlertRegistration, "Документы отправлены на регистрацию", "Missing alert");
        driver.navigate().refresh();

    }
}

