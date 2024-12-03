package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.Main;
import stg.qa.sreda.page.MainPage;
import test.TestBase;

public class Login extends BasePage{

//    WebDriver driver;



    public Login(WebDriver driver) {
        super(driver);
    }

    private By menuBtn =By.xpath("//div[2]/div[1]/div/app-icon-button/span/app-icon/span");
    private By usernameInput =By.xpath("//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input");
    private By passwordInput =By.xpath("//input[contains(@type,'password')]");
    private By submitBtn =By.xpath("//button[@class='primary'][contains(.,'ВОЙТИ')]");


    //Method to enter username
    public void clickRoleMenu() {
        driver.findElement(menuBtn).click();
    }

    //Method to enter username
    public void enterUsername(String userername) {
        driver.findElement(usernameInput).sendKeys(userername);
    }

    //Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    //Method to click on Login button
    public void clickLogin() {
        driver.findElement(submitBtn).click();
    }

    public Login loginArch (String username, String password){
        //public MainPage doLogin (String username,String password) {
            driver.get(TestBase.SITE_URL);
            clickRoleMenu();
            enterUsername(username);
            enterPassword(password);
            clickLogin();
            return this;

    }
}
