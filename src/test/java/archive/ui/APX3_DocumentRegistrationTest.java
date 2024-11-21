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

public class APX3_DocumentRegistrationTest extends WebDriverSettings {



    @Test(priority=3)
    public void docRegistrationByArch() {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

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

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАРЕГИСТРИРОВАТЬ')]")).click();


        WebElement alertDocRegistryWindow = driver.findElement(By.xpath("//span[contains(.,'Зарегистрирован 1 документ')]"));
        String actualAlertWindow = alertDocRegistryWindow.getText();
        Assert.assertTrue(actualAlertWindow.matches("Зарегистрирован 1 документ"), "Missing alert");
         }

    }


