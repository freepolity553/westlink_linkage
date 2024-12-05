package page;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import settings.Constants;

public class Login extends BasePage{

//    WebDriver driver;



    public Login(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    private By menuBtn =By.xpath("//div[2]/div[1]/div/app-icon-button/span/app-icon/span");
    private By usernameInput =By.xpath("//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input");
    private By passwordInput =By.xpath("//input[contains(@type,'password')]");
    private By submitBtn =By.xpath("//button[@class='primary'][contains(.,'ВОЙТИ')]");


//    //Method to click role menu
//    public void clickRoleMenu() {
//        driver.findElement(menuBtn).click();
//    }
//
//    //Method to enter username
//    public void enterUsername(String userername) {
//        driver.findElement(usernameInput).sendKeys(userername);
//    }
//
//    //Method to enter password
//    public void enterPassword(String password) {
//        driver.findElement(passwordInput).sendKeys(password);
//    }
//
//    //Method to click on Login button
//    public void clickLogin() {
//        driver.findElement(submitBtn).click();
//    }
@Step("Login")
    public Login loginArch (String username, String password){
        //public MainPage doLogin (String username,String password) {
            driver.get(Constants.URL);
            click(menuBtn);
            enterText(usernameInput,password);
            //enterUsername(username);
            enterText(passwordInput,password);
            //enterPassword(password);
            click(submitBtn);
            return this;

    }
}
