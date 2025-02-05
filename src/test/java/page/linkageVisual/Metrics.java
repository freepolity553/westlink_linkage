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
    public By  constructorMetrics =By.xpath("//div[contains(text(),'Конструктор показателей')]");

    //Конструктор показателей

    private By addTableBtn =By.xpath("//span[@class='ml-3'][contains(.,'Добавить таблицу')]");
    private By inputMetricName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv']");
    private By dataSourceList =By.xpath("//div[@class='Select-module_container__U1UI1 css-2b097c-container']");
    private By dataSourceList1 = By.xpath("//input[@id='select-9']");

    private By sqlTextArea =By.xpath("//textarea[@class='pa-2 TextArea-module_textarea__zZCio TextArea-module_textarea__border--all__0fm5e' and @placeholder='Введите SQL запрос']");

    //Вкладки
    private By constructorRequestTab = (By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
    private By sqlTab = (By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
    private By formulaTab =  (By.xpath("//button[@type='button'][contains(.,'Формула')]"));

    //Выбор показателя

    private By requestValidationBtn = By.xpath("//button[contains(text(),'Проверка запроса')]");
    private By addFlexFilterBtn = By.xpath("//span[contains(text(),'Добавить поля')]");
    private By addFlexFilterName = By.xpath("//input[@id='input-10']");
    private By addFlexFilterColumn = By.xpath("//input[@id='input-11']");

    private By flexFilterType = By.xpath("//*/text()[normalize-space(.)='Тип']/parent::*");
    private By flexFilterTypeSelection = By.xpath("//input[@id='select-13']");

    private By selectStatusBtn = By.xpath("//button[contains(text(),'Черновик')]");
    private By statusReadyForWork = By.xpath("//div[contains(text(),'Готов к работе')]");

    private By addWidget = By.xpath("//button[contains(text(),'Создать виджет')]");


    //input[@id='input-992']
    //date
    private String dataSource = "Локальная витрина";


    public String useMetricName() {
        // Retrieve the extracted value from the shared class
        String value = getMetricName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }

    @Step(value = "Login with  {0} {1} ")
    public Metrics addSQLMetric (){

        click(newMetricBtn );
        click(sqlTab);
        enterText(inputMetricName,useMetricName());
        waitClickable(dataSourceList);
        threadSleep(20000);
        click(dataSourceList);
        WebElement clickable = driver.findElement(dataSourceList1);
        clickable.sendKeys(dataSource);
        clickable.sendKeys(Keys.ENTER);
        enterText(sqlTextArea, Variables.sql);
        click(addFlexFilterBtn);
        click(addFlexFilterName);
        enterText(addFlexFilterName,"Дата");
        click(addFlexFilterColumn);
        enterText(addFlexFilterColumn,"date");
        click(flexFilterType);
        enterText(flexFilterTypeSelection,"Дата");
        pressEnter(flexFilterTypeSelection);
        click(selectStatusBtn);
        click(statusReadyForWork);
        click(requestValidationBtn);
        save();
        click(addWidget);

        return this;
    }
    @Step(value = "Check elements of Metrics page")
    public Metrics checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));

        return this;
    }
}






