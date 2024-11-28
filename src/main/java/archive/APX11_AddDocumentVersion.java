package archive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import utilites.ui.WebDriverSettings;

import java.time.Duration;


public class APX11_AddDocumentVersion {

    private final WebDriver driver;

    public APX11_AddDocumentVersion (WebDriver driver) {
        this.driver = driver;
    }

    public void addVersion() {

    LoginPage login = new LoginPage(driver);
    ArchivePage objArchivePage = new ArchivePage(driver);
    Actions action = new Actions(driver);
    driver.get(WebDriverSettings.url);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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


        //Нажать кнопку Версия
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Версия')]")).click();

        //Выбрать тестовый проект
        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите проект')]")).click();
        WebElement projectVersion = driver.findElement(By.xpath("(//button[@class='dropdown-item dd-menu__item'][contains(.,'AQA123 AQA Проект')])[2]"));
        action.moveToElement(projectVersion).click().perform();

        //Выбрать шифр тома проекта
        WebElement code = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите шифр')]")));
        code.click();

        WebElement projectCode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/app-dropdown/div/div/button")));
        projectCode.click();

        WebElement status = driver.findElement(By.xpath("//div[@class='value'][contains(.,'Служебный')]"));
        String actualStatus = status.getText();
        Assert.assertEquals(actualStatus, "Служебный", "Неправильное значение");

        //Добавить файл
        objArchivePage.uploadFile();

        WebElement buttonDocCancellationWindow = driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'ОТМЕНА')]"));
        String actualbuttonDocCancellationWindow = buttonDocCancellationWindow.getText();
        Assert.assertEquals(actualbuttonDocCancellationWindow, "ОТМЕНА", "Missing button");

        WebElement createVersion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='primary'][contains(.,'ЗАГРУЗИТЬ')])[2]")));
        createVersion.click();

        //WebElement alertVersion = driver.findElement(By.xpath("//div[@class='toasts__item'][contains(.,'Версия документа загружена')]"));
        WebElement alertVersion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='toasts__item'][contains(.,'Версия документа загружена')]")));
        String actualAlertVersion = alertVersion.getText();
        Assert.assertEquals(actualAlertVersion, "Версия документа загружена", "Missing alert");
    }
}

