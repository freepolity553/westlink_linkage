package page.login;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import page.BasePage;
import settings.Constants;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    private By usernameInput =By.xpath("//input[contains(@name,'log')]");
    private By passwordInput =By.xpath("//input[contains(@type,'password')]");
    private By submitBtn =By.xpath("//button[contains(@type,'submit')]");


    @Step(value = "Login with Admin Demo ")
    public Login loginAdminDemo(String username, String password){


            driver.get(Constants.URL_AUTH_DEMO);
            isElementDisplayed(By.xpath("//p[contains(.,'Если у вас возникли проблемы, обратитесь в техподдержку')]"));
            enterText(usernameInput,username);
            enterText(passwordInput,password);
            click(submitBtn);




            return this;
    }
    @Step(value = "Login with Admin Dev ")
    public Login loginAdminDev(String username, String password){
        driver.get(Constants.URL_AUTH_DEV);
        isElementDisplayed(By.xpath("//p[contains(.,'Если у вас возникли проблемы, обратитесь в техподдержку')]"));
        enterText(usernameInput,password);
        enterText(passwordInput,password);
        click(submitBtn);
        return this;
    }
    @Step(value = "Check elements of Login page")
    public Login  checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//p[@class='SelectARM_welcomeText__hello__X3t-0'][contains(.,'Здравствуйте')]"));
        isElementDisplayed(By.xpath("//p[contains(@class,'SelectARM_cardName__ARdPm')]"));
        isElementDisplayed(By.xpath("//p[contains(@class,'SelectARM_hint__ZVVoP')]"));
        return this;
    }
}
