package archive;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import utilites.ui.WebDriverSettings;

import java.time.Duration;

public class APX3_DocumentRegistration  {

    private final WebDriver driver;

    public APX3_DocumentRegistration(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Прием документов на хранение (регистрация)")
    public void docRegistrationByArch() {


        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(WebDriverSettings.url);
        objArchivePage.clickRoleMenu();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как Архивариус
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


