package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;

import settings.Variables;

import java.time.Duration;

import static page.SharedData.*;


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
    private By addFlexFilter = By.xpath("//div[1]/div/div[6]/div[2]/div/div/div[1]/div/input");
    private By addFlexFilter2 = By.xpath("//div[1]/div/div[6]/div[2]/div/div[2]/div[1]/div/input");

    private By addFlexFilterColumn = By.xpath("//div[1]/div/div[6]/div[2]/div/div/div[2]/div/input");
    private By addFlexFilterColumn2 = By.xpath("//div[1]/div/div[6]/div[2]/div/div[2]/div[2]/div/input");

    private By flexFilterType = By.xpath("//*/text()[normalize-space(.)='Тип']/parent::*");
    private By flexFilterType2 = By.xpath("//div[6]/div[2]/div/div[2]/div[3]/div/div/div");

    private By flexFilterTypeSelection = By.xpath("//div[6]/div[2]/div/div/div[3]/div/div/div/div/div/div/input");
    private By flexFilterTypeSelection2 = By.xpath("//div[2]/div[3]/div/div/div/div[1]/div[2]/div/input");

//    private By selectStatusBtn = By.xpath("//button[contains(text(),'Черновик')]");
//    private By statusReadyForWork = By.xpath("//div[contains(text(),'Готов к работе')]");

    private By addWidget = By.xpath("//button[contains(text(),'Создать виджет')]");
    private By stayInConstractorBtn  =By.xpath("//button[@class='Button-module_main__lxsaF btnOutlinePrimary ConfirmationModal_btn__uOPAs']");

    private String dataSource = "Локальная витрина";
    private String dataSourceFiltration = "demo_agrotech_set";

//    public String getCityName() {
//
//        WebElement cityName = driver.findElement(By.xpath("/html/body/div[1]/div/div[7]/div[2]/div/div[2]/div[2]"));
//        String value = cityName.getText();
//        System.out.println(value);
//
//        return value;
//    }

    public String useMetricName() {
        // Retrieve the extracted value from the shared class
        String value = getMetricName();


        return value;
    }
    public String useMetricCities() {
        // Retrieve the extracted value from the shared class
        String value = getMetricCities();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    public String useMetricPoints() {
        // Retrieve the extracted value from the shared class
        String value = getMetricPoints();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }



    @Step("add SQL Metric ")
    public Metrics addSQLMetric (){

        click(newMetricBtn );
        click(sqlTab);
        enterText(inputMetricName,useMetricName());
        waitClickable(dataSourceList);
        threadSleep(12000);
        click(dataSourceList);
        WebElement db = driver.findElement(dataSourceList1);
        slowSendKeys(db, dataSource, 70); // 100ms delay between characters
        threadSleep(3000);
        db.sendKeys(Keys.ENTER);
        enterText(sqlTextArea, Variables.sqlBasic);
        click(addFlexFilterBtn);
        click(addFlexFilter);
        enterText(addFlexFilter,"Дата");
        click(addFlexFilterColumn);
        enterText(addFlexFilterColumn,"date");
        click(flexFilterType);
        enterText(flexFilterTypeSelection,"Дата");
        pressEnter(flexFilterTypeSelection);
        threadSleep(3000);
        click(draftBtn);
        click(statusReadyForWork);
        click(requestValidationBtn);
        threadSleep(2000);
        save();
        threadSleep(10000);
        click(stayInConstractorBtn);

        return this;
    }

    @Step("add Cities Metric ")
    public Metrics addCitiesMetric (){

        click(newMetricBtn );
        click(sqlTab);
        enterText(inputMetricName,useMetricCities());
        waitClickable(dataSourceList);
        threadSleep(12000);
        click(dataSourceList);
        WebElement db = driver.findElement(dataSourceList1);
        slowSendKeys(db, dataSourceFiltration, 50); // 100ms delay between characters
        db.sendKeys(Keys.ENTER);
        enterText(sqlTextArea, Variables.sqlCities);
        click(addFlexFilterBtn);
        click(addFlexFilter);
        enterText(addFlexFilter,"Город");
        click(addFlexFilterColumn);
        enterText(addFlexFilterColumn,"public.cities.id");
        click(flexFilterType);
        enterText(flexFilterTypeSelection,"Число");
        pressEnter(flexFilterTypeSelection);
        threadSleep(3000);
        click(draftBtn);
        threadSleep(2000);
        click(statusReadyForWork);
        click(requestValidationBtn);
        threadSleep(2000);
        save();
        threadSleep(10000);
        click(stayInConstractorBtn);

        return this;
    }

    @Step( "addPoints Metric ")
    public Metrics addPointsMetric (){

        click(newMetricBtn );
        click(sqlTab);
        enterText(inputMetricName,useMetricPoints());
        waitClickable(dataSourceList);
        threadSleep(5000);
        click(dataSourceList);
        WebElement db = driver.findElement(dataSourceList1);
        slowSendKeys(db, dataSourceFiltration, 50); // 100ms delay between characters
        db.sendKeys(Keys.ENTER);
        enterText(sqlTextArea, Variables.sqlPoints);
        click(addFlexFilterBtn);
        click(addFlexFilter);
        enterText(addFlexFilter,"Точка");
        click(addFlexFilterColumn);
        enterText(addFlexFilterColumn,"public.points.id");
        click(flexFilterType);
        enterText(flexFilterTypeSelection,"Число");
        pressEnter(flexFilterTypeSelection);
        threadSleep(3000);
        click(addFlexFilterBtn);
        click(addFlexFilter2);
        enterText(addFlexFilter2,"Город");
        click(addFlexFilterColumn);
        enterText(addFlexFilterColumn2,"public.points.city_id");
        click(flexFilterType2);
        enterText(flexFilterTypeSelection2,"Число");
        threadSleep(2000);
//        pressEnter(flexFilterType2);
//        threadSleep(3000);
        click(draftBtn);
        threadSleep(2000);
        click(statusReadyForWork);
        threadSleep(2000);
        click(requestValidationBtn);
        threadSleep(2000);
        save();
        threadSleep(10000);
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