package test.dataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settings.Constants;
import test.TestBase1;

import java.io.IOException;


public class LoginDataProviderTest extends TestBase1 {

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData() {
        Object[][] data = {{"testccep", "testcce"}, {"testarc", "testarch"}};
        return data;
    }

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String lg, String ps) {
        driver.get(Constants.URL);
        driver.findElement(By.xpath("//div[2]/div[1]/div/app-icon-button/span/app-icon/span")).click();
        driver.findElement(By.xpath("//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input")).sendKeys(lg);
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(ps);
        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ВОЙТИ')]")).click();

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

//        WebElement alert=driver.findElement (By.xpath("//span[contains(.,'Что-то пошло не так')]"));
//        String actualAlert = alert.getText();
//        System.out.println(actualAlert);
    }
}
