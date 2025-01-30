package page;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By addBtn =By.xpath("//button[@class='Button-module_main__lxsaF btnPrimary mr-2'][contains(.,'Добавить')]");
    private By saveBtn =By.xpath("//button[contains(text(),'Сохранить')]");

    public By  search =By.xpath("//input[contains(@placeholder,'Введите название')]");
    public By checkbox =By.xpath("//label[@class='Checkbox-module_label__JBaRm']");
    private By backArrow =By.cssSelector("svg.ArrowBack_icon__EvMez");


    public BasePage() {

    }
    //Кнопка Добавить
    public void back() {
        waitVisibility(backArrow);
        WebElement element = driver.findElement(backArrow);
        element.click();
    }


    //Add randomInt
    public String randomInt(int length) {
        String str = RandomStringUtils.randomNumeric(length);
        return str;
    }

//    public  String randomAlphabetic(int count ){
//        String str1 = RandomStringUtils.randomAlphabetic(4);
//        return str1;
//    };

    public String randomestring()
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }


    //Кнопка Добавить
    public void addRecord() {
        waitVisibility(addBtn);
        WebElement element = driver.findElement(addBtn);
        element.click();
    }

    //Кнопка Сохранить
    public void save () {
        waitVisibility(saveBtn);
        WebElement element = driver.findElement(saveBtn);
        element.click();
    }
    //Wait method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void threadSleep(int length) {
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Click method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Send Keys method
    public void  enterText (By elementBy,String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    //Is element Displayed
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    public void isAlertText(String message){
        assertEquals(message,driver.switchTo().alert().getText());
    }

    public void isElementNotDisplayed(By elementBy){
        assertTrue(driver.findElements(elementBy).isEmpty());
    }

    public void fileUpload() {
        File uploadFile = new File("src/test/resources/600_600.jpg");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        //driver.findElement(By.id("file-submit")).click();
//        WebElement fileName = driver.findElement(By.xpath("//span[contains(.,'file.txt')]"));
//        Assertions.assertEquals("file.txt", fileName.getText());
    }
    public void fileUploadTest() {

        File uploadFile = new File("src/test/resources/600_600.jpg");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
//
//        WebElement fileName = driver.findElement(By.id("uploaded-files"));
//        Assertions.assertEquals("file.txt", fileName.getText());
    }



}
