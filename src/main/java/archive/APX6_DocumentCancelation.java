package archive;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilites.LoginPage;
import utilites.RandomValue;

import java.time.Duration;


public class APX6_DocumentCancelation  {

    private final WebDriver driver;

    public APX6_DocumentCancelation(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Аннулирование версий документов")
    public void docCancelation()  {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(utilites.WebDriverSettings.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Выбрать тестовый проект
        objArchivePage.selectTestProject();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //objArchivePage.addDocVersion();

        //Выбрать тестовый проект
        objArchivePage.selectTestProject();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("(//div[contains(@class,'mtable__col col__payload')])[1]")).click();

        driver.findElement(By.xpath("(//div[@class='mtable__col col__status'][contains(.,'Служебный')])[1]")).click();

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Аннулировать')]")).click();


        WebElement alertCancelation = driver.findElement (By.xpath("//div[@class='footer__ask'][contains(.,'Вы хотите аннулировать документ?')]"));
        String actualalertCancelation = alertCancelation.getText();
        Assert.assertEquals(actualalertCancelation,"Вы хотите аннулировать документ?","Missing alert");

        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'АННУЛИРОВАТЬ')]")).click();

        WebElement cancelation = driver.findElement (By.xpath("//span[@class='canceled'][contains(.,'Аннулирован')]"));
        String actualCancelation = cancelation.getText();
        Assert.assertEquals(actualCancelation,"Аннулирован","Missing Confirmation");

        //Восстановить аннулированную версию
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Восстановить')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ВОССТАНОВИТЬ')]")).click();

        WebElement status = driver.findElement (By.xpath("//div[@class='top__item__value'][contains(.,'Служебный')]"));
        String actualstatus = status.getText();
        Assert.assertEquals(actualstatus,"Служебный","Некорректный статус версии");


        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//app-icon-button[@class='close-btn'][1]"));
        action.click(element).perform();



    }
}

