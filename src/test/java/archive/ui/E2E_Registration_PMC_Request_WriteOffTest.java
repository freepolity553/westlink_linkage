package archive.ui;


import archive.ArchivePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class E2E_Registration_PMC_Request_WriteOffTest extends WebDriverSettings {

    ArchivePage objArchivePage;

    @Test(priority=1)
    public void addDocumentVersionTest() {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        RandomValue randomValue = new RandomValue(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();

        //Выбрать тестовый проект
        WebElement project = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='m_label'][contains(.,'Проект')]")));
        project.click();
        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')]")).click();


        //Нажать кнопку Версия
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Версия')]")).click();

        //Выбрать тестовый проект

        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите проект')]")).click();
        driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')])[2]")).click();



        driver.findElement(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите шифр')]")).click();
        driver.findElement(By.xpath("//button[@class='dropdown-item'][contains(.,'ТОМ 1-AQA')]")).click();


        WebElement status = driver.findElement(By.xpath("//div[@class='value'][contains(.,'Служебный')]"));
        String actualStatus = status.getText();
        Assert.assertEquals(actualStatus, "Служебный", "Неправильное значение");


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

    @Test(priority=2)
    public void addPMCTest() {
        LoginPage login = new LoginPage(driver);
        RandomValue randomValue = new RandomValue(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();


        //Выбрать тестовый проект
        objArchivePage.selectTestProject();


        //Выбрать первый документ из списка
        WebElement checkBox = driver.findElement(By.xpath("//app-archive-list-chief/div/div[2]/div[1]/div[1]/app-archive-list-checkbox/app-checkbox/app-icon-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

        //Создание РВИ
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'РВИ 1')]")).click();

        //Номер разрешения
        driver.findElement(By.xpath("//input[contains(@class,'s ng-untouched ng-pristine ng-valid')]")).sendKeys(randomValue.pmcNum(2));

        //Добавить лист
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Добавить лист')]")).click();

        driver.findElement(By.xpath("//textarea[contains(@rows,'3')]")).sendKeys("Содержание изменения");
        driver.findElement(By.xpath("//textarea[contains(@rows,'2')]")).sendKeys("Примечание");



        //Добавить файл
        objArchivePage.uploadFile();


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement file = driver.findElement(By.xpath("//span[contains(@class,'filename')]"));
        Assert.assertNotNull(file);


        //Добавить сотрудников
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        objArchivePage.addEmployees();

        //Изменения внес
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Изменения внес'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[5]")).click();

        //Составил
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Составил'])[1]/following::*[name()='svg'][1]")));
        element.click();
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        element1.click();

        //ГИП
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ГИП'])[1]/following::*[name()='svg'][1]")));
        element2.click();
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        element3.click();

        //Утвердил
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Утвердил'])[1]/following::*[name()='svg'][1]")).click();
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        element5.click();

        //Н. Контр.
        WebElement element7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Н. Контр.'])[1]/following::*[name()='svg'][1]")));
        element7.click();
        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
        element6.click();


        WebElement num = driver.findElement(By.xpath("//div[1]/app-card-input/app-card-row/div/div[2]/div/input"));
        String numPMC = num.getAttribute("value");
        System.out.println("Номер РВИ " + numPMC);

        //Отправить на подписание
        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ОТПРАВИТЬ НА ПОДПИСАНИЕ')]")).click();

        WebElement alert = driver.findElement(By.xpath("//span[contains(.,'Разрешение на внесение изменений отправлено на подпись')]"));
        String actualAlert = alert.getText();
        Assert.assertEquals(actualAlert, "Разрешение на внесение изменений отправлено на подпись", "Неверное подтверждение");
        driver.navigate().refresh();

        //Проверка создания РВИ в БД
//        try {
//            String testData = QueryDBui.data();
//            System.out.println(testData);
//            Assert.assertEquals(testData, numPMC, "Отличия по РВИ");
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test(priority=3)
    public void docRegistrationByGIPTest() {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();

        //Выбрать тестовый проект
        objArchivePage.selectTestProject();

        //Выбрать первый документ из списка
        WebElement checkBox = driver.findElement(By.xpath("//app-archive-list-chief/div/div[2]/div[1]/div[1]/app-archive-list-checkbox/app-checkbox/app-icon-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Регистрация 1')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ОТПРАВИТЬ')]")).click();

        WebElement alertRegistration = driver.findElement(By.xpath("//span[contains(.,'Документы отправлены на регистрацию')]"));
        String actualAlertRegistration = alertRegistration.getText();
        Assert.assertEquals(actualAlertRegistration, "Документы отправлены на регистрацию", "Missing alert");
        driver.navigate().refresh();

    }

    @Test(priority=4)
    public void docRegistrationTestByArch() {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
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

    @Test(priority=5)
    public void docRequestTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как ГИП
        objArchivePage.accessArchive();
        WebElement inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")));
        inventory.click();



        //Выбрать тестовый проект
        objArchivePage.selectTestProject();


        //Выбрать документ для запроса
        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-checkbox[1]/app-icon-button[1]/span[1]/app-icon[1]/span[1]/*[name()='svg'][1]")));
        doc.click();

        //driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Запросить')])[2]")).click();
        WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary'][contains(.,'Запросить выдачу : 1')]")));
        request.click();
        //driver.findElement(By.xpath("//button[@class='primary'][contains(.,'Запросить выдачу : 1')]")).click();




        driver.findElement(By.xpath("//textarea[contains(@class,'ng-untouched ng-pristine ng-valid')]")).sendKeys("Комментарий для выдачи");

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ЗАПРОСИТЬ')]")).click();


//        WebElement status = driver.findElement (By.xpath("(//div[contains(.,'Запрос на выдачу документа отправлен')])[7]"));
//        String actualAlert = status.getText();
//        Assert.assertEquals(actualAlert,"Запрос на выдачу документа отправлен","Запрос не отправлен");


    }
    @Test(priority=6)
    public void docIssueByRequestTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();


        //Выбрать документ для запроса
        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Выдать по запросу')]")));
        doc.click();

        driver.findElement(By.xpath("//app-archive-main/app-archive-out-list/div/div/div[1]/div[1]")).click();

        WebElement issue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Выдать')]")));
        issue.click();

        //driver.findElement(By.xpath("//button[@type='button'][contains(.,'Выдать')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ВЫДАТЬ')]")).click();
        driver.navigate().refresh();

    }
    @Test(priority=7)
    public void docIssueByRequestConfirmationTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginKGIP();


        //Войти в Архив
        objArchivePage.accessArchive();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Инвент. журнал')]")).click();

        WebElement status1 = driver.findElement (By.xpath("(//span[contains(@class,'delivery-status done')])[1]"));
        Assert.assertNotNull(status1 ,"Not null");
        driver.navigate().refresh();

    }
    @Test (priority=8)
    public void writeOffDocumentTest()  {
        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();


        //Выбрать тестовый проект
        objArchivePage.selectTestProjectArch();

        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-archive-book/div/app-archive-list-archivist/div/div[2]/div[1]")));
        version.click();


        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Списать')]")).click();
        WebElement employee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите сотрудника')]")));
        employee.click();
        WebElement employee1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-card-row[1]/div[1]/div[2]/app-dropdown[1]/div[1]/div[1]/button[1]")));
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

