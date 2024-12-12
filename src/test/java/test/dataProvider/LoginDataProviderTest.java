package test.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BasePage;
import settings.Constants;
import test.TestBase;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class LoginDataProviderTest extends TestBase {

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData() {
        Object[][] data = {{"testccep", "testcce"}, {"testarch", "testarch"}};
        return data;
    }

    BasePage base = new BasePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String lg, String ps) {
        driver.get(Constants.URL);
        driver.findElement(By.xpath("//div[2]/div[1]/div/app-icon-button/span/app-icon/span")).click();
        driver.findElement(By.xpath("//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input")).sendKeys(lg);
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(ps);
        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ВОЙТИ')]")).click();

        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-left-pane/div/div[2]/div[1]/div/span")));

        WebElement elm = driver.findElement(By.xpath("//app-left-pane/div/div[2]/div[1]/div/span"));
        //base.waitVisibility(By.xpath("//app-left-pane/div/div[2]/div[1]/div/span"));
        assertTrue(elm.isDisplayed());

        //base.isElementDisplayed(By.xpath("//app-left-pane/div/div[2]/div[1]/div/span"));

//        WebElement alert=driver.findElement (By.xpath("//span[contains(.,'Что-то пошло не так')]"));
//        String actualAlert = alert.getText();
//        System.out.println(actualAlert);
//        Assert.assertTrue(actualAlert.matches("Что-то пошло не так"),"Missing alert");
//        Assert.assertEquals("Что-то пошло не так",driver.switchTo().alert().getText());

    }

    @DataProvider(name = "LoginExcelDataProvider2")
    public Object[][] excelData() throws IOException {
        return new ReadXls().readExcel();
    }

    @Test(dataProvider = "LoginExcelDataProvider2", dataProviderClass = ReadXls.class)
    public void loginCredentialsTest(String login, String password) {
        driver.get(Constants.URL);
        driver.findElement(By.xpath("//div[2]/div[1]/div/app-icon-button/span/app-icon/span")).click();
        driver.findElement(By.xpath("//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input")).sendKeys(login);
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ВОЙТИ')]")).click();

        WebElement elm = driver.findElement(By.xpath("//app-left-pane/div/div[2]/div[1]/div/span"));
        base.waitVisibility(By.xpath("//app-left-pane/div/div[2]/div[1]/div/span"));
        assertTrue(elm.isDisplayed());

    }
}
