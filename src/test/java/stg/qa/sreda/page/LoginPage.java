package stg.qa.sreda.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//    private final String menu ="";
//    private final String username ="";
//    private final String password  = "";
//    private final String submit = "" ;

    protected WebDriver driver;

    @FindBy(xpath="//div[2]/div[1]/div/app-icon-button/span/app-icon/span")
    private WebElement menuBtn;

    @FindBy(xpath = "//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input")
    @CacheLookup
    private WebElement usernameInput;

    @FindBy (xpath = "//input[contains(@type,'password')]")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@class='primary'][contains(.,'ВОЙТИ')]")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage doLogin (String username,String password) {

        menuBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
        return new MainPage(driver);


    }

}
