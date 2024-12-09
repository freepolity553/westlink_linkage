package page;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ArchiveMain extends BasePage{
    public ArchiveMain(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    @Step(value = "Check elements of ArchiveMain page")
    public ArchiveMain checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Документ')]"));
        isElementDisplayed(By.xpath("//button[contains(.,'Принять')]"));
        isElementDisplayed(By.xpath("//span[@class='m_text'][contains(.,'Все проекты')]"));
        isElementDisplayed(By.xpath("//div[@class='mtable__header__col col__number'][contains(.,'Инв. номер')]"));

        return this;
    }

    public ArchiveMain isLoginWrong () {
        isAlertText("Wrong");
        return this;
    }
    public ArchiveMain addNewVersion () {
        WebElement addVersion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Версия')]")));
        addVersion.click();
        return this;
    }
    public void fileUploadTest() {
        //driver.get("https://the-internet.herokuapp.com/upload");
        File uploadFile = new File("src/test/resources/file.txt");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assertions.assertEquals("file.txt", fileName.getText());
    }
}
