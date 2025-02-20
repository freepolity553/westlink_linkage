package page.linkageDataPlatform;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.mainPanel.MainPanel;
import settings.Constants;
import settings.Variables;

import java.time.Duration;

import static page.SharedData.getMetricName;


public class Connections extends BasePage {
    public Connections(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



    private By newConnectionBtn = By.xpath("//button[contains(text(),'Создать подключение')]");
    public By constructorConnections = By.xpath("//div[contains(text(),'Подключения')]");



    private By connName = By.name("name");
    private By host = By.xpath("//div[3]/div[2]/div[2]/div/div[2]/div[1]");
    private By port = By.xpath("//div[3]/div[2]/div[2]/div/div[3]/div[1]");
    private By nameBD = By.xpath("//div[3]/div[2]/div[2]/div/div[4]/div[1]");
    private By user = By.xpath("//div[3]/div[2]/div[2]/div/div[5]/div[1]");
    private By password = By.xpath("//div[3]/div[2]/div[2]/div/div[6]/div[1]");

    private By validateConnBtn = By.xpath("//button[contains(text(),'Проверить подключение')]");
    private By saveConnBtn = By.xpath("//button[contains(text(),'Сохранить подключение')]");
    public By adminDashboard =By.xpath("//a[contains(text(),'Панель административного управления')]");





    @Step(value = "Login with  {0} {1} ")
    public Connections addConnection (){

        click(newConnectionBtn);
        threadSleep(1000);
        enterText(connName, Constants.nameBD);

        WebElement host1 = driver.findElement(host);
        new Actions(driver)
                .moveToElement(host1)
                .click()
                .pause(Duration.ofSeconds(1))
                    .sendKeys(Constants.host)
                .perform();

        WebElement port1 = driver.findElement(port);
        new Actions(driver)
                .moveToElement(port1)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys(Constants.port)
                .perform();

        WebElement nameBD1 = driver.findElement(nameBD);
        new Actions(driver)
                .moveToElement(nameBD1)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys(Constants.nameBD)
                .perform();

        WebElement user1 = driver.findElement(user);
        new Actions(driver)
                .moveToElement(user1)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys(Constants.user)
                .perform();

        WebElement password1 = driver.findElement(password);
        new Actions(driver)
                .moveToElement(password1)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys(Constants.password)
                .perform();

        click(checkbox);
        threadSleep(1000);
        click(validateConnBtn);
        threadSleep(1000);
        click(saveConnBtn);
        threadSleep(2000);
        click(adminDashboard);
        click(constructorConnections);


        return this;
    }
    @Step(value = "Check elements of Metrics page")
    public Connections checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));

        return this;
    }
}