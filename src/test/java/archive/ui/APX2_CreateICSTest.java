package archive.ui;


import archive.ArchivePage;
import archive.QueryDBui;
import org.openqa.selenium.By;
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

public class APX2_CreateICSTest extends WebDriverSettings {



    @Test
    public void addICSTest()  {

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

        //Выбрать  документ из списка
        WebElement project1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-archive-list-chief/div/div[2]/div/div[1]/app-archive-list-checkbox/app-checkbox")));
        project1.click();
//        WebElement checkBox1 = driver.findElement(By.xpath("//app-archive-chief/div/app-archive-list-chief/div/div[1]/div[1]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox1);

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'ИУЛ')]")).click();

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

        WebElement buttonSignICS=driver.findElement (By.xpath("//button[@class='primary'][contains(.,'ОТПРАВИТЬ НА ПОДПИСАНИЕ')]"));
        String actualbuttonSignICS = buttonSignICS.getText();
        Assert.assertEquals(actualbuttonSignICS,"ОТПРАВИТЬ НА ПОДПИСАНИЕ","Missing button");

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'ОТМЕНА')]")).click();

//        WebElement buttonDoc=driver.findElement (By.xpath("//span[contains(.,'Информационно-удостоверяющие листы для 1 документа отправлены на подписание')]"));
//        String actualbuttonDoc = buttonDoc.getText();
//        Assert.assertTrue(actualbuttonDoc.matches("Информационно-удостоверяющие листы для 1 документа отправлены на подписание"),"Missing alert");


    }
}

