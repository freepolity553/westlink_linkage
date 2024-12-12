package page.projects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;

import java.io.File;

public class ProjectsMain extends BasePage {
    public ProjectsMain(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    @Step(value = "Check elements of ProjectMain page")
    public ProjectsMain checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'СОЗДАТЬ')]"));
        isElementDisplayed(By.xpath("//span[contains(.,'Проектная документация')]"));
        isElementDisplayed(By.xpath("//span[contains(.,'Рабочая документация')]"));

        return this;
    }

    public ProjectsMain isLoginWrong () {
        isAlertText("Wrong");
        return this;
    }
    public ProjectsMain createProject () {
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
