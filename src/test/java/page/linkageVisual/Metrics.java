package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import settings.Variables;

import java.time.Duration;

import static page.SharedData.getMetricName;

public class Metrics extends BasePage {
    public Metrics(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    private By newMetricBtn =By.xpath("//button[contains(text(),'Создать показатель')]");
    public By constructorMetrics =By.xpath("//div[contains(text(),'Конструктор показателей')]");

    //Конструктор показателей

    private By addTableBtn =By.xpath("//span[@class='ml-3'][contains(.,'Добавить таблицу')]");
    private By inputMetricName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv']");
    private By dataSourceList =By.xpath("//div[@class='Select-module_container__U1UI1 css-2b097c-container']");

    private By sqlTextArea =By.xpath("//textarea[@class='pa-2 TextArea-module_textarea__zZCio TextArea-module_textarea__border--all__0fm5e' and @placeholder='Введите SQL запрос']");

    //Вкладки
    private By constructorRequestTab = (By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
    private By sqlTab = (By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
    private By formulaTab =  (By.xpath("//button[@type='button'][contains(.,'Формула')]"));

    //Выбор показателя
    //private By addMetricField =By.xpath("(//span[contains(.,'Добавить поля')])[1]");
    private By requestValidationBtn = By.xpath("//button[contains(text(),'Проверка запроса')]");
    private By addFlexFilterBtn = By.xpath("//span[contains(text(),'Добавить поля')]");
    private By addFlexFilterName = By.id("input-992");
    private By addFlexFilterColumn = By.id("input-993");
    private By flexFilterTypeBtn = By.xpath("//div[@class='slct__indicators css-1wy0on6']");
    private By flexFilterTypeSelection = By.xpath("//*/text()[normalize-space(.)='Текст']/parent::*");
    private By selectStatusBtn = By.xpath("//button[contains(text(),'Черновик')]");

    //date
    private String dataSource = "Локальная витрина";


    public String useMetricName() {
        // Retrieve the extracted value from the shared class
        String value = getMetricName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }

//    @Step(value = "Enter Metrics ")
//    public Metrics enterMetricsConstructor (){
//        click(newMetricBtn);
//        return this;
//    }

    @Step(value = "Login with  {0} {1} ")
    public Metrics addSQLMetric (){
        //WebElement dataSourceListElm = driver.findElement(By.xpath("//div[@class='Select-module_container__U1UI1 css-2b097c-container']"));
        click(newMetricBtn );
        click(sqlTab);
        enterText(inputMetricName,useMetricName());

        waitClickable(dataSourceList);
        threadSleep(15000);
        click(dataSourceList);
        WebElement clickable = driver.findElement(dataSourceList);
        slowSendKeys(clickable,dataSource,100);
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(2))
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(dataSource)
                .pause(Duration.ofSeconds(2))
                .perform();
        //enterText(dataSourceList,dataSource);
        clickable.sendKeys(Keys.ENTER);
        click(addTableBtn);
        enterText(sqlTextArea, Variables.sql);
        click(addFlexFilterBtn);
        enterText(addFlexFilterName,"Дата");
        enterText(addFlexFilterColumn,"date");
        click(flexFilterTypeBtn);
        click(flexFilterTypeSelection);
        save();
        click(requestValidationBtn);

        return this;
    }
    @Step(value = "Check elements of Metrics page")
    public Metrics checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));

        //
//        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор дашбордов')])[9]"));
//
//        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор АРМ')])[9]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Data Platform (Платформа данных)')]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Administration (Администрирование)')]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Digital Twin (Цифровой двойник)')]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Configurator (Конфигуратор)')]"));

        return this;
    }
}






