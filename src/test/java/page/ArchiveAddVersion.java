package page;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ArchiveAddVersion extends BasePage{
    public ArchiveAddVersion(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    @Step(value = "Check elements of ArchiveMain page for Archivarius")
    public ArchiveAddVersion checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//div[@class='title'][contains(.,'Загрузить версию документа')]"));
        isElementDisplayed(By.xpath("//span[@class='m_placeholder'][contains(.,'Выберите проект')]"));
        isElementDisplayed(By.xpath("//span[@class='m_placeholder'][contains(.,'Выберите шифр')]"));
        isElementDisplayed(By.xpath("//span[@class='file-group__dd__text'][contains(.,'Или претащите файл сюда')]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'ЗАГРУЗИТЬ ФАЙЛ')]"));

        return this;
    }


    public ArchiveAddVersion addNewVersion () {
        WebElement addVersion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'Версия')]")));
        addVersion.click();
        return this;
    }
    public void fileUpload() {
        //driver.get("https://the-internet.herokuapp.com/upload");
        File uploadFile = new File("src/test/resources/file.txt");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        //driver.findElement(By.id("file-submit")).click();
        WebElement fileName = driver.findElement(By.xpath("//span[contains(.,'file.txt')]"));
        Assertions.assertEquals("file.txt", fileName.getText());
    }
}
