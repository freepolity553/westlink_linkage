package archive;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.LoginPage;

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
        driver.get(utilites.WebDriverSettings.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Войти в Архив как КГИП
        objArchivePage.accessArchive();

        WebElement inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")));
        inventory.click();


        //Выбрать тестовый проект
        objArchivePage.selectTestProject();


        //Выбрать документ для запроса
//        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-checkbox[1]/app-icon-button[1]/span[1]/app-icon[1]/span[1]/*[name()='svg'][1]")));
//        doc.click();
        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'mtable__col col__name')])[1]")));
        version.click();

        //driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")).click();
//        WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary'][contains(.,'Запросить выдачу')]")));
//        request.click();

        WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")));
        request.click();
//        driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")).click();


        driver.findElement(By.xpath("//textarea[contains(@class,'ng-untouched ng-pristine ng-valid')]")).sendKeys("Комментарий для выдачи");

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАПРОСИТЬ')]")).click();


//        WebElement status = driver.findElement (By.xpath("(//div[contains(.,'Запрос на выдачу документа отправлен')])[7]"));
//        String actualAlert = status.getText();
//        Assert.assertEquals(actualAlert,"Запрос на выдачу документа отправлен","Запрос не отправлен");
    }
}

