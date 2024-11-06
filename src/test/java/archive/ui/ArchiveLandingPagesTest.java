package archive.ui;


import archive.ArchivePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArchiveLandingPagesTest extends WebDriverSettings {
    ArchivePage objArchivePage ;

    @Test //Открыть в браузере сайт https://stroytransgaz.april-inn.ru/archive/list/.
    public void urlTest() {
        driver.get(url);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue (url.contains("stroytransgaz"));

    }
    @Test
    public void landingPageEngineerTest()  {


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        objArchivePage = new ArchivePage(driver);
        objArchivePage.clickRoleMenu();
        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'Инженер')]")).click();

        driver.findElement(By.xpath("//input[contains(@placeholder,'Номер, шифр или наименование')]")).click();
        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Проект')]")).click();
        driver.findElement(By.xpath("//span[@class='m_placeholder'][contains(.,'Дата поступления')]")).click();

        WebElement buttonRel=driver.findElement (By.xpath("//div[@class='filter-chip'][contains(.,'Выданные мне')]"));
        String actualbuttonRel = buttonRel.getText();
        Assert.assertEquals(actualbuttonRel,"Выданные мне","Missing button Выданные мне");

        driver.findElement(By.xpath("//app-archive-list-table/div/div[2]/div[1]/div[1]/app-checkbox/app-icon-button/span/app-icon")).click();

        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'Запросить выдачу: 1')]")).click();
    }

    @Test
    public void landingPageGIPTest()  {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        objArchivePage = new ArchivePage(driver);
        objArchivePage.clickRoleMenu();
        driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(.,'ГИП')])[1]")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Номер, шифр или наименование')]")).click();
        driver.findElement(By.xpath("//span[@class='m_placeholder'][contains(.,'Дата поступления')]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);
        WebElement buttonDoc=driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'Документ')]"));
        String actualbuttonDoc = buttonDoc.getText();
        Assert.assertEquals(actualbuttonDoc,"Документ","Missing button");

        WebElement buttonJournal = driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'Инвент. журнал')]"));
        String actualbuttonJournal = buttonJournal.getText();
        Assert.assertEquals(actualbuttonJournal,"Инвент. журнал","Missing button");

        WebElement buttonPmc=driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'РВИ')]"));
        String actualbuttonPMC = buttonPmc.getText();
        Assert.assertEquals(actualbuttonPMC,"РВИ","Missing button");

        WebElement buttonIcs=driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'ИУЛ')]"));
        String actualbuttonIcs = buttonIcs.getText();
        Assert.assertEquals(actualbuttonIcs,"ИУЛ","Missing button");

        driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-archive-list/div/app-archive-list-chief/div/div[2]/div[1]/div[1]/app-archive-list-checkbox/app-checkbox")).click();

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Регистрация 1')]")).click();
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'ОТМЕНА')]")).click();
        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Проект')]")).click();

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    @Test
    public void landingPageArchivistTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        objArchivePage = new ArchivePage(driver);
        objArchivePage.clickRoleMenu();
        driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(.,'Архивариус')])[1]")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Номер, шифр или наименование')]")).click();
        driver.findElement(By.xpath("//span[@class='m_placeholder'][contains(.,'Дата поступления')]")).click();
        //driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Проект')]")).click();
        WebElement invBook = driver.findElement (By.xpath("//span[contains(.,'Инвентраная книга')]"));
        String actualNameBook = invBook.getText();
        Assert.assertEquals(actualNameBook,"Инвентраная книга","Missing title");

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);
        WebElement buttonDoc=driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'Документ')]"));
        String actualbuttonDoc = buttonDoc.getText();
        Assert.assertEquals(actualbuttonDoc,"Документ","Missing button");

        WebElement buttonRec = driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'Принять')]"));
        String actualRec = buttonRec.getText();
        Assert.assertEquals(true,actualRec.contains("Принять"),"Missing title");

        WebElement buttonReq = driver.findElement (By.xpath("//button[@class='primary-outline'][contains(.,'Выдать по запросу')]"));
        String actualReq = buttonReq.getText();
        Assert.assertEquals(true,actualReq.contains("Выдать по запросу"),"Missing title");


    }

}

