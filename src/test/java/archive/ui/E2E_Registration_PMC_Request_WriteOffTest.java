package archive.ui;


import archive.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class E2E_Registration_PMC_Request_WriteOffTest extends WebDriverSettings {


    @Test(priority = 1)
    @Description("Загрузка версии документов")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-11", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/11-zagruzka-versii-dokumentov/")
    @Issue("SODIT-342")
    @Epic("Архив")
    @Feature("")
    @Story("Загрузка версии документов")

    public void addDocumentVersionTest() {
        APX11_AddDocumentVersion createVersion = new APX11_AddDocumentVersion(driver);
        createVersion.addVersion();

    }


    @Test(priority = 2)
    @Description("Создание РВИ")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-1", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/1-sozdanie-rvi/")
    @Issue("SODIT-245")
    @Epic("Архив")
    @Feature("")
    @Story("Создание РВИ")

    public void addPMC() {
        APX1_CreatePMC createPMC = new APX1_CreatePMC(driver);
        createPMC.addPMC();
        createPMC.addEmployees();
        createPMC.sendPMCtoSign();
    }

    @Test(priority = 3)
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


    @Test(priority = 4)
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

    @Test(priority = 5)
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


    @Test(priority = 6)
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

    @Test(priority = 6)
    @Description("Выдача документов по запросу-Подтверждение выдачи")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-10", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/10-vydacha-dokumentov-po-zaprosu/")
    @Issue("SODIT-254")
    @Epic("Архив")
    @Feature("")
    @Story("Выдача документов по запросу")
    public void docIssueConfirmationTest() {
        APX10_DocumentIssueConfirmation docConfirmation = new APX10_DocumentIssueConfirmation(driver);
        docConfirmation.docIssueByRequestConfirmation();
    }

    @Test(priority = 7)
    @Description("Списание документов")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-5", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/5-spisanie-dokumentov/")
    @Issue("SODIT-249")
    @Epic("Архив")
    @Feature("")
    @Story("Списание документов")

    public void writeOffDocumentTest() {
        APX5_WriteOffDocument writeOffDocument = new APX5_WriteOffDocument(driver);
        writeOffDocument.writeOffDocument();
    }

    @Test(priority = 8)
    @Description("Аннулирование версий документов")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-6", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/6annulirovanie-dokumentov/")
    @Issue("SODIT-250")
    @Epic("Архив")
    @Feature("")
    @Story("Аннулирование версий документов")

    public void documentCancellationTest() {

        APX11_AddDocumentVersion addVersion = new APX11_AddDocumentVersion(driver);
        addVersion.addVersion();

        APX6_DocumentCancelation documentCancellation = new APX6_DocumentCancelation(driver);
        documentCancellation.docCancelation();
    }

    @Test(priority = 8)
    @Description("Выдача документов во вне")
    @Severity(CRITICAL)
    @Owner("Алексей Нечаев")
    @Link(name = "Арх-7", url = "https://wiki.yandex.ru/homepage/mvp-do-konca-goda/scenarii/arxiv/7vydacha-dokumentov-vo-vne/")
    @Issue("SODIT-251")
    @Epic("Архив")
    @Feature("")
    @Story("Выдача документов во вне")

    public void documentExternalSupplyTest() {

        APX7_DocumentExternalSupply documentExternal = new APX7_DocumentExternalSupply(driver);
        documentExternal.documentExternalSupply();

    }
}

