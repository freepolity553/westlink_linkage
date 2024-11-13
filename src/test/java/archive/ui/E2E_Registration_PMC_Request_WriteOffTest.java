package archive.ui;


import archive.*;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.LoginPage;

import java.io.File;
import java.time.Duration;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class E2E_Registration_PMC_Request_WriteOffTest extends WebDriverSettings {


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
        APX11_AddDocumentVersion createVersion =new APX11_AddDocumentVersion(driver);
        createVersion.selectProjectVolume();
        createVersion.versionStatusAssert();
        createVersion.createVersion();
    }


    @Test(priority=2)
    @Description("Создание РВИ")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-1", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/1-sozdanie-rvi/")
    @Issue("SODIT-245")
    @Epic("Архив")
    @Feature("")
    @Story("Создание РВИ")

    public void addPMC() {
        APX1_CreatePMC createPMC =new APX1_CreatePMC(driver);
        createPMC.addPMC();
        createPMC.addEmployees();
        createPMC.sendPMCtoSign();
    }

    @Test(priority=3)
    @Description("Отправка версии документа на регистрацию")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-13", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/13-otpravka-dokumenta-na-registraciju/")
    @Issue("SODIT-344")
    @Epic("Архив")
    @Feature("")
    @Story("Отправка версии документа на регистрацию")

    public void versionRegistrationByGIPTest() {
        APX13_VersionRegistration versionRegistration = new APX13_VersionRegistration(driver);
       versionRegistration.docRegistrationByKGIP();

    }


    @Test(priority=4)
    @Description("Прием документов на хранение (регистрация)")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-3", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/3-priem-dokumentov-na-xranenie-registracija/")
    @Issue("SODIT-247")
    @Epic("Архив")
    @Feature("")
    @Story("Прием документов на хранение (регистрация)")

    public void docRegistrationTestByArch() {
        APX3_DocumentRegistration docRegistration = new APX3_DocumentRegistration(driver);
        docRegistration.docRegistrationByArch();

    }


    @Test(priority=5)
    @Description("Запрос на выдачу документа")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-9", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/9-zapros-na-vydachu-dokumenta/")
    @Issue("SODIT-253")
    @Epic("Архив")
    @Feature("")
    @Story("Запрос на выдачу документа")

    public void docRequestTest() {
        APX9_DocumentRequest docRequest = new APX9_DocumentRequest(driver);
        docRequest.docRequestTest();
    }



    @Test(priority=6)
    @Description("Выдача документов по запросу")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-10", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/10-vydacha-dokumentov-po-zaprosu/")
    @Issue("SODIT-254")
    @Epic("Архив")
    @Feature("")
    @Story("Выдача документов по запросу")

    public void docIssueTest() {
        APX10_DocumentIssueByRequestBtn docIssue = new APX10_DocumentIssueByRequestBtn(driver);
        docIssue.docIssueByRequestBtn();
    }
    public void docIssueConfirmationTest() {
        APX10_DocumentIssueConfirmation docConfirmation = new APX10_DocumentIssueConfirmation(driver);
        docConfirmation.docIssueByRequestConfirmation();
    }

    @Test (priority=8)
    public void writeOffDocumentTest()  {
        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();


        //Выбрать тестовый проект
        objArchivePage.selectTestProjectArch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-archive-book/div/app-archive-list-archivist/div/div[2]/div[1]/div[2]")));
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

