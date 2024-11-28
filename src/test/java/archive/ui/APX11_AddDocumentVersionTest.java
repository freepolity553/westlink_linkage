package archive.ui;


import archive.ArchivePage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import pages.LoginPage;

import java.time.Duration;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class APX11_AddDocumentVersionTest extends WebDriverSettings {

    @Test(priority=1)
    @Description("Загрузка версии документов")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-11", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/11-zagruzka-versii-dokumentov/")
    @Issue("SODIT-342")
    @Epic("Архив")
    @Feature("")
    @Story("Загрузка версии документов")
    public void addDocumentVersionTest() {
        step1();
        step2();
        step3();

    }
    @Step("Выбор проекта и тома для загрузки новой версии")
    public void step1(){
        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
    }
    @Step("Проверка статуса для версии - Служебный")
    public void step2(){
        WebElement status = driver.findElement(By.xpath("//div[@class='value'][contains(.,'Служебный')]"));
        String actualStatus = status.getText();
        Assert.assertEquals(actualStatus, "Служебный", "Неправильное значение");
    }

    @Step("Загрузка файла и версии документа")
    public void step3(){
        ArchivePage objArchivePage = new ArchivePage(driver);
        //Добавить файл
        objArchivePage.uploadFile();

        WebElement buttonDocCancellationWindow = driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'ОТМЕНА')]"));
        String actualbuttonDocCancellationWindow = buttonDocCancellationWindow.getText();
        Assert.assertEquals(actualbuttonDocCancellationWindow, "ОТМЕНА", "Missing button");

        driver.findElement(By.xpath("(//button[@class='primary'][contains(.,'ЗАГРУЗИТЬ')])[2]")).click();

        WebElement alertVersion = driver.findElement(By.xpath("//div[@class='toasts__item'][contains(.,'Версия документа загружена')]"));
        String actualAlertVersion = alertVersion.getText();
        Assert.assertEquals(actualAlertVersion, "Версия документа загружена", "Missing alert");
    }
}

