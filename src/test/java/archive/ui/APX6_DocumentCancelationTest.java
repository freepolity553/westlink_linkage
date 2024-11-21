package archive.ui;


import archive.QueryDBui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import archive.ArchivePage;
import settings.WebDriverSettings;
import utilites.ui.LoginPage;
import utilites.ui.RandomValue;

import java.time.Duration;


public class APX6_DocumentCancelationTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void docCancelationTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        QueryDBui db = new QueryDBui();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//app-icon-button[@class='close-btn'][1]"));
        action.click(element).perform();



    }
}

