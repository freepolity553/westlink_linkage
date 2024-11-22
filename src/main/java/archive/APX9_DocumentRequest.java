package archive;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.ui.LoginPage;
import utilites.ui.WebDriverSettings;

import java.time.Duration;


public class APX9_DocumentRequest {

    private final WebDriver driver;

    public APX9_DocumentRequest(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Запрос на выдачу документа")
    public void docRequestTest()  {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(WebDriverSettings.url);
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Войти в Архив как КГИП
        objArchivePage.accessArchive();

        WebElement inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")));
        inventory.click();


        //Выбрать тестовый проект
        WebElement projectMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='m_label'][contains(.,'Проект')]")));
        projectMenu.click();
        WebElement project = driver.findElement(By.xpath("//button[@class='dropdown-item dd-menu__item'][contains(.,'AQA123 AQA Проект')]"));
        action.moveToElement(project).click().perform();


        //Выбрать документ для запроса
        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-checkbox[1]/app-icon-button[1]/span[1]/app-icon[1]/span[1]/*[name()='svg'][1]")));
        doc.click();
//        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'mtable__col col__name')])[1]")));
//        version.click();

        //driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")).click();
        WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary'][contains(.,'Запросить выдачу')]")));
        request.click();

//        WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")));
//        request.click();
//        driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")).click();


        driver.findElement(By.xpath("//textarea[contains(@class,'ng-untouched ng-pristine ng-valid')]")).sendKeys("Комментарий для выдачи");

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАПРОСИТЬ')]")).click();


//        WebElement status = driver.findElement (By.xpath("(//div[contains(.,'Запрос на выдачу документа отправлен')])[7]"));
//        String actualAlert = status.getText();
//        Assert.assertEquals(actualAlert,"Запрос на выдачу документа отправлен","Запрос не отправлен");
    }
}

