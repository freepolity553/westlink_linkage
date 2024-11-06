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

public class APX_3docRegistrationTest extends WebDriverSettings {



    @Test
    public void docRegistrationTest()  {

        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        QueryDBui db = new QueryDBui();
        driver.get(url);
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();

        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Принять')]")));
        register.click();

        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-archive-main/app-archive-acceptance/div/div/div[2]/div[1]")));
        doc.click();

       // WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-right-modal/div/div[2]/div[1]/section/div[3]/div[2]/div[2]")));

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАРЕГИСТРИРОВАТЬ')]")).click();

        WebElement alertDocRegistryWindow = driver.findElement (By.xpath("//span[contains(.,'Зарегистрирован')]"));
        String actualAlertWindow = alertDocRegistryWindow.getText();
        Assert.assertTrue(actualAlertWindow.matches("Зарегистрированы"),"Missing alert");



    }
}

