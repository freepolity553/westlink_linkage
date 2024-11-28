package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.ui.WebDriverSettings;

public class LoginPage extends WebDriverSettings {

    private String usernameGIP = "testccpe";
    private String passwordGIP = "testccpe";
    private String usernameArch = "testarch";
    private String passwordArch = "testarch";

    WebDriver driver;

    @FindBy(xpath = "//div[2]/app-login/app-overflow-modal/div/div[2]/div[2]/section/div[1]/input")
    @CacheLookup
    private WebElement username;

    @FindBy (xpath = "//input[contains(@type,'password')]")
    private WebElement password;

    @FindBy (xpath = "//button[@class='primary'][contains(.,'ВОЙТИ')]")
    private WebElement btnEnter;

    @FindBy(xpath="//div[2]/div[1]/div/app-icon-button/span/app-icon/span")
    private WebElement roleMenu;

    @FindBy(xpath="//span[@class='hidden'][contains(.,'Архив')]")
    private WebElement menuArchive;

    @FindBy(xpath = "//span[@class='hidden'][contains(.,'Проекты')]")
    private WebElement menuProjects;


    // constructor method
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginKGIP() {
        username.sendKeys(usernameGIP);
        password.sendKeys(passwordGIP);
        btnEnter.click();
    }

    public void loginArch() {
        username.sendKeys(usernameArch);
        password.sendKeys(passwordArch);
        btnEnter.click();
    }

    public void clickRoleMenu () {
        roleMenu.click();
    }
    public void accessArchive () {
        menuArchive.click();
    }
    public void accessProjects () {
        menuProjects.click();
    }

}

