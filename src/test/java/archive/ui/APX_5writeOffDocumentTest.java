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

import java.io.File;
import java.time.Duration;

public class APX_5writeOffDocumentTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test
    public void writeOffDocumentTest()  {
        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        QueryDBui db = new QueryDBui();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();


        //Выбрать тестовый проект
        objArchivePage.selectTestProjectArch();

        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'mtable__col col__name')])[1]")));
        version.click();

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Списать')]")).click();
        WebElement employee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите сотрудника')]")));
        employee.click();
        WebElement employee1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'dropdown-item')])[22]")));
        employee1.click();

        driver.findElement(By.xpath("//textarea[contains(@rows,'8')]")).clear();
        driver.findElement(By.xpath("//textarea[contains(@rows,'8')]")).sendKeys("Списать документ");

        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'СПИСАТЬ')]")).click();

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.xpath("(//span[contains(.,'Скачать акт списания на подпись')])[2]")).click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.switchTo().window(winHandleBefore);

        WebElement buttonWriteOff = driver.findElement (By.xpath("//div[@class='actions__status'][contains(.,'Документ ожидает списания')]"));
        String actualbuttonWriteOff = buttonWriteOff.getText();
        Assert.assertEquals(actualbuttonWriteOff,"Документ ожидает списания","Текст отсутствует");

        //Добавить файл
        File uploadFile = new File("src/test/resources/Акт_списания.pdf");
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        WebElement writeOff = driver.findElement (By.xpath("//button[@class='primary'][contains(.,'СПИСАТЬ')]"));
        writeOff.click();

        WebElement writeOffAct = driver.findElement (By.xpath("//h4[contains(.,'Документ списан')]"));
        String actualwriteOffAct = writeOffAct.getText();
        Assert.assertEquals(actualwriteOffAct,"Документ списан","Текст отсутствует");
    }
}

