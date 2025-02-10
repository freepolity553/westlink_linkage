package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import page.SharedData;
import settings.Variables;

import java.time.Duration;

import static page.SharedData.getMetricName;


public class Metrics extends BasePage {
    public Metrics(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private By newMetricBtn = By.xpath("//button[contains(text(),'Создать показатель')]");
    public By constructorMetrics = By.xpath("//div[contains(text(),'Конструктор показателей')]");

    //Конструктор показателей

    private By addTableBtn = By.xpath("//span[@class='ml-3'][contains(.,'Добавить таблицу')]");
    private By inputMetricName = By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv']");
    private By dataSourceList = By.xpath("//div[@class='Select-module_container__U1UI1 css-2b097c-container']");
    private By dataSourceList1 = By.xpath("//div[@id='root']/div/div[4]/div[2]/div[2]/div/div/div/div/div/input");

    private By sqlTextArea = By.xpath("//textarea[@class='pa-2 TextArea-module_textarea__zZCio TextArea-module_textarea__border--all__0fm5e' and @placeholder='Введите SQL запрос']");

    //Вкладки
    private By constructorRequestTab = (By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
    private By sqlTab = (By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
    private By formulaTab = (By.xpath("//button[@type='button'][contains(.,'Формула')]"));

    //Выбор показателя

    private By requestValidationBtn = By.xpath("//button[contains(text(),'Проверка запроса')]");
    private By addFlexFilterBtn = By.xpath("//span[contains(text(),'Добавить поля')]");
    private By addFlexFilterName = By.xpath("//div[1]/div/div[6]/div[2]/div/div/div[1]/div/input");
    private By addFlexFilterColumn = By.xpath("//div[1]/div/div[6]/div[2]/div/div/div[2]/div/input");

    private By flexFilterType = By.xpath("//*/text()[normalize-space(.)='Тип']/parent::*");
    private By flexFilterTypeSelection = By.xpath("//div[6]/div[2]/div/div/div[3]/div/div/div/div/div/div/input");

//    private By selectStatusBtn = By.xpath("//button[contains(text(),'Черновик')]");
//    private By statusReadyForWork = By.xpath("//div[contains(text(),'Готов к работе')]");

    private By addWidget = By.xpath("//button[contains(text(),'Создать виджет')]");
    private By stayInConstractorBtn  =By.xpath("//button[@class='Button-module_main__lxsaF btnOutlinePrimary ConfirmationModal_btn__uOPAs']");

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
        threadSleep(12000);
        click(dataSourceList);
        WebElement db = driver.findElement(dataSourceList1);
        db.sendKeys(dataSource);
        db.sendKeys(Keys.ENTER);
        enterText(sqlTextArea, Variables.sql);
        click(addFlexFilterBtn);
        click(addFlexFilterName);
        enterText(addFlexFilterName,"Дата");
        click(addFlexFilterColumn);
        enterText(addFlexFilterColumn,"date");
        click(flexFilterType);
        enterText(flexFilterTypeSelection,"Дата");
        pressEnter(flexFilterTypeSelection);
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        click(requestValidationBtn);
        save();
        click(stayInConstractorBtn);

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