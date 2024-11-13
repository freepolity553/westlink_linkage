package archive;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.LoginPage;

import java.time.Duration;


public class APX10_DocumentIssueByRequestBtn {

    private final WebDriver driver;

    public APX10_DocumentIssueByRequestBtn(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выдача документов по запросу")
    public void docIssueByRequestBtn()  {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        driver.get(utilites.WebDriverSettings.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        objArchivePage.clickRoleMenu();
        login.loginArch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();


        //Выбрать документ для запроса
        WebElement doc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primary-outline'][contains(.,'Выдать по запросу')]")));
        doc.click();

        WebElement doc1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выдать документы'])[1]/following::*[name()='svg'][1]")));
        doc1.click();

        WebElement issue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Выдать')]")));
        issue.click();

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'ВЫДАТЬ')]")).click();
        driver.navigate().refresh();

    }
}

