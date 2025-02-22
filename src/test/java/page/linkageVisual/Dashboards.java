package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.Assert;
import page.BasePage;

import java.util.List;

import static page.SharedData.getDashboardAgrotech;
import static page.SharedData.getDashboardName;

public class Dashboards extends BasePage {
    public Dashboards(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}



    public By constructorDashboards =By.xpath("//div[contains(text(),'Конструктор дашбордов')]");
    private By newDashboardtBtn =By.xpath("//button[contains(text(),'Создать дашборд')]");
    private By inputDashboardName =By.xpath("//input[@placeholder='Введите название']");
    private By addWidgetBtn =By.xpath("//div[@class='TopBar_icon__cgG0k'][contains(text(),'Добавить')]");
    private By searchForWidget =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder='Введите название']");
    private By checkboxWidget = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск по названию'])[1]/following::*[name()='svg'][2]");
    private By addWidgetModalBtn = By.xpath("//button[contains(text(),'Добавить на холст')]");
    private By addFilteringBtn = By.xpath("//div[@class='FiltersData_filterData__qnQxY']");
    private By dataFilter = By.xpath("//span[@class='ButtonFilter_label__t8Ut2']");
    private By selectOperation = By.xpath("//div[@class='slct__value-container slct__value-container--has-value css-1hwfws3']");
    private By enterDate =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pr-6']");
    private By datePicker = By.xpath("//div[@class='InputText-module_icon__8XMHv InputText-module_icon_inner__dPCVH InputText-module_icon_inner_right__cJwjN']");
    private By oper = By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary mr-2']");
    private By metricCheckbox2 = By.xpath("//div[3]/div[2]/div[2]/div/div[1]/div/label");
    private By filterSettings1 = By.cssSelector("svg.FilterItem_checkBox__icon__hXCuZ");
    private By filterSettings2 = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Настроить созависимую фильтрацию'])[1]/following::*[name()='svg'][4]");
    private By filterMetricBtn = By.xpath("//div[@role='presentation']//div[3]//div[1]//label[1]");
    private By addMetricBtn = By.xpath("//button[contains(text(),'Добавить показатель')]");
    private By inputMetric = By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder ='Введите название показателя' ]");
    private By addMetric = By.xpath("//button[contains(text(),'Вставить')]");
    private By addKey = By.xpath("//div[2]/div/div/div[1]/div[2]/div/input");
    private By selectKey = By.xpath("//div[3]/div[2]/div/div/div/div/div/input");
    private By addName = By.xpath("//div[3]/div/div/div[1]/div[2]/div/input");
    private By selectName = By.xpath("//div[3]/div[3]/div/div/div/div/div/input");
    private By save = By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary mr-2']");
    private By selectFilters = By.xpath("//button[contains(text(),'Выбор фильтров')]");
    private By setCodependentFilteringBtn = By.xpath("//button[contains(text(),'Настроить созависимую фильтрацию')]");
    private By createConnectionBtn = By.xpath("//button[contains(text(),'Создать связь')]");
    private By inputFilter1 = By.xpath("//div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private By inputFilter2 = By.xpath("//div[3]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/input");
    private By selectCity = By.xpath("//div[contains(text(),'Город')]");
    private By selectPoint = By.xpath("//div[contains(text(),'Точка')]");
    private By connectBtn = By.xpath("//button[@class='Button-module_main__lxsaF Button-module_auto_width__Fgo4W Button-module_icon__xIuVv Button-module_icon_only__EcUq- FilterChains_chainBtn__67HiG FilterChains_chainBtn__error__SQn5w']//*[name()='svg']");
    private By selectField1 = By.xpath("//div[3]/div[2]/div/div/div/div/div/div[2]");
    private By selectField2 = By.xpath("//div[3]/div[2]/div/div[3]/div[2]/div[1]/div/div[1]/div[2]/div/input");
    private By field1 = By.xpath("//div[3]/div[2]/div/div/div[2]/div/div[2]/div/div");
    private By field2 = By.xpath("//div[2]/div/div[2]/div/div[2]");
    private By back =By.cssSelector("svg.AddWidgetFilter_arrowBack__OXzcF > path");

    private By firstDropdown = By.xpath("//div[4]/div/div[1]/div[1]/div[1]/div/div[1]/div/div");
    private By searchFirstDropdown = By.xpath("//div/div/div/div/div/div/input");
    public By secondDropdown = By.xpath("//div[4]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div");
    public By secondDropdownList = By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[2]/div/div[2]");




    public String useDashboardName() {
        String value = getDashboardName();
        return value;
    }

    public String useDashboardAgrotech() {
        String value = getDashboardAgrotech();
        return value;
    }

    Widgets w = new Widgets(driver);
    String widgetCitiesName = w.useWidgetCitiesName();
    String widgetPointsName = w.useWidgetPointsName();

    Metrics m = new Metrics(driver);
    String metricPoints = m.useMetricPoints();
    String metricCities = m.useMetricCities();


    @Step(value = " ")
    public Dashboards addDashboardSimple(){
        Widgets w = new Widgets(driver);
        String widgetTableName = w.useWidgetTableName();
        String widgetDiagrammeName = w.useWidgetDiagrammeName();

        click(newDashboardtBtn );
        enterText(inputDashboardName,useDashboardName());
        click(addWidgetBtn);
        enterText(searchForWidget,widgetTableName);
        threadSleep(2000);
        click(checkboxWidget);
        click(addWidgetModalBtn);
        click(addWidgetBtn);
        enterText(searchForWidget, widgetDiagrammeName);
        threadSleep(2000);
        click(checkboxWidget);
        click(addWidgetModalBtn);
        threadSleep(2000);
        click(draftBtn);
        threadSleep(2000);
        click(statusReadyForWork);
        threadSleep(3000);
        save();
        threadSleep(4000);
        click(addFilteringBtn);
        click(checkbox);
        click(oper);
        threadSleep(2000);
        click(dataFilter);
        threadSleep(2000);
        click(selectOperation);
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Равно']/parent::*")).click();
        click(datePicker);
        click(By.xpath("//button[contains(text(),'Готово')]"));
        click(By.xpath("//button[contains(text(),'Применить')]"));
        threadSleep(2000);
        back();

        return this;
    }

    @Step(value = " ")
    public Dashboards addDashboardAgrotech(){

        click(newDashboardtBtn );
        enterText(inputDashboardName,useDashboardAgrotech());
        click(addWidgetBtn);
        enterText(searchForWidget,widgetCitiesName);
        threadSleep(2000);
        click(checkboxWidget);
        click(addWidgetModalBtn);
        click(addWidgetBtn);
        enterText(searchForWidget, widgetPointsName);
        threadSleep(2000);
        click(checkboxWidget);
        click(addWidgetModalBtn);
        threadSleep(2000);
        click(draftBtn);
        threadSleep(2000);
        click(statusReadyForWork);
        threadSleep(3000);
        save();
        threadSleep(3000);

        return this;
    }
    @Step(value = " ")
    public Dashboards addFilteringData(){
        click(addFilteringBtn);
        click(checkbox);
        click(oper);
        threadSleep(2000);
        click(dataFilter);
        threadSleep(2000);
        click(selectOperation);
        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Равно']/parent::*")).click();
        click(datePicker);
        click(By.xpath("//button[contains(text(),'Готово')]"));
        click(By.xpath("//button[contains(text(),'Применить')]"));

        return this;
    }
    public void setMetricCities() {
        WebElement ulElement = driver.findElement(By.xpath("//ul[@class='MetricsDrawer_metricsUl__kI5dd mt-3']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement li : liElements) {
            if (li.getText().equals(metricCities)) {
                li.click();
                break;
            }
        }
    }
    public void setMetricPoints() {
        WebElement ulElement = driver.findElement(By.xpath("//ul[@class='MetricsDrawer_metricsUl__kI5dd mt-3']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement li : liElements) {
            if (li.getText().equals(metricPoints)) {
                li.click();
                break;
            }
        }
    }
    @Step(value = " ")
    public Dashboards addCodependentFiltering(){
        //Add Cities filter
        click(addFilteringBtn);
        click(checkbox);
        click(filterSettings1);
        threadSleep(1000);
        click(filterMetricBtn);
        click(addMetricBtn);
        threadSleep(1000);
        click(inputMetric);
        threadSleep(1000);
        setMetricCities();
        threadSleep(1000);
        click(addMetric);
        threadSleep(1000);
        click(addKey);
        threadSleep(2000);
        enterText(addKey,"id");
        threadSleep(2000);
        pressEnter(selectKey);
        threadSleep(2000);
        click(addName);
        threadSleep(2000);
        enterText(addName,"city_name");
        threadSleep(2000);
        pressEnter(selectName);
        threadSleep(2000);
        click(save);

        //Add Points filter
        click(metricCheckbox2);
        click(filterSettings2);
        threadSleep(1000);
        click(filterMetricBtn);
        click(addMetricBtn);
        click(inputMetric);
        setMetricPoints();
        click(addMetric);
        threadSleep(3000);
        click(addKey);
        threadSleep(3000);
        enterText(addKey,"id");
        threadSleep(3000);
        pressEnter(selectKey);
        threadSleep(2000);
        click(addName);
        threadSleep(3000);
        enterText(addName,"point_name");
        pressEnter(selectName);
        threadSleep(2000);
        click(save);
        threadSleep(1000);
        click(save);
        threadSleep(3000);

        //setCodependentFiltering
        click(selectFilters);
        click(setCodependentFilteringBtn);
        threadSleep(2000);
        click(createConnectionBtn);
        threadSleep(2000);
        click(inputFilter1);
        threadSleep(2000);
        click(selectCity);
        click(inputFilter2);
        threadSleep(1000);
        click(inputFilter2);
        click(selectPoint);
        threadSleep(1000);
        click(connectBtn);
        threadSleep(2000);
        click(selectField1);
        threadSleep(3000);
        click(field1);
        threadSleep(1000);
        click(selectField2);
        click(selectField2);
        click(field2);
        click(save);
        click(save);
        click(back);
        click(save);
        save();
        threadSleep(3000);
        click(firstDropdown);
        enterText(searchFirstDropdown,"Москва");
        pressEnter(searchFirstDropdown);
        threadSleep(5000);
        click(secondDropdown);
        threadSleep(2000);


        return this;
    }

    @Step(value = "Check elements of Dashboard page")
    public Dashboards checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));
        
        return this;
    }
}






