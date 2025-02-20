package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import page.BasePage;


import java.util.List;

import static page.SharedData.*;

public class Widgets extends BasePage {
    public Widgets(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}



    public By constructorWidgets =By.xpath("//div[contains(text(),'Конструктор виджетов')]");
    private By newWidgetBtn =By.xpath("//button[contains(text(),'Создать виджет')]");

    //Конструктор виджетов

    private By selectGraph =By.xpath("//div[@class='SelectWidgetType_dropDown__MyHeG Dropdown-module_dropdown__HMCqD']");
    private By inputWidgetName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv'and @placeholder='Введите заголовок виджета']");


    private By addMetricBtn =By.xpath("//button[contains(text(),'Добавить показатель')]");
    private By searchForMetric =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder='Введите название показателя']");

    private By metric = By.xpath("//li[@class='MetricSelectItem_item__R26gp MetricSelectItem_itemSelectable__U35rY']");

    private By addMetric = By.xpath("//button[contains(text(),'Вставить')]");

    private By refreshField = By.xpath("//div[3]/div[1]/div[2]/div[2]/div[8]/div[2]/div/div/div/input");
    private By stayInConstructorBtn =By.xpath("//button[@class='Button-module_main__lxsaF btnOutlinePrimary ConfirmationModal_btn__uOPAs']");

    private By statusSavedWidget  =By.xpath("//p[@class='WidgetTopBar_attention__nameDone__m1cSM']");

    private By metricSettingsBtn = By.xpath("//button[contains(text(),'Настройки показателей')]");

    private By transferWidget  =By.xpath("//div[@id='root']/div/div[3]/div/div[2]/div[2]/div/div[2]/div/div[14]/div[2]/div/div[2]/label");
    private By searchForWidget =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv SelectInfiniteCore_inputClass__GpexQ pr-6' and @placeholder='Выберите виджет']");

    private By selectTransferWidget = By.xpath("//div[2]/div[2]/div[2]/div[2]/div/p");


    public String useWidgetTableName() {
        // Retrieve the extracted value from the shared class
        String value = getWidgetTableName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }

    public String useWidgetDiagrammeName() {
        // Retrieve the extracted value from the shared class
        String value = getWidgetDiagrammeName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    public String useWidgetCitiesName() {
        // Retrieve the extracted value from the shared class
        String value = getWidgetCitiesName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    public String useWidgetPointsName() {
        // Retrieve the extracted value from the shared class
        String value = getWidgetPointsName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    public void setGraphTableSelection() {
        WebElement ulElement = driver.findElement(By.xpath("//ul[@class='SelectWidgetType_dropDownChildWrapper__xB01v']"));
        // Find all <li> elements within the parent
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Iterate through the <li> elements and click on a specific one
        for (WebElement li : liElements) {
            if (li.getText().equals("Таблица")) {
                li.click(); // Click the <li> element
                break; // Exit the loop after clicking
            }
        }
    }
    public void setDiagrammeSelection() {
        WebElement ulElement = driver.findElement(By.xpath("//ul[@class='SelectWidgetType_dropDownChildWrapper__xB01v']"));
        // Find all <li> elements within the parent
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Iterate through the <li> elements and click on a specific one
        for (WebElement li : liElements) {
            if (li.getText().equals("Диаграмма области")) {
                li.click(); // Click the <li> element
                break; // Exit the loop after clicking
            }
        }
    }


    @Step(value = " ")
    public Widgets addTableWidget (){
        Metrics m = new Metrics(driver);
        String metricName = m.useMetricName();

        click(newWidgetBtn );
        click(selectGraph);
        setGraphTableSelection();
        enterText(inputWidgetName,useWidgetTableName());
        click(addMetricBtn);
        enterText(searchForMetric, metricName);
        click(metric);
        click(addMetric);
        enterText(refreshField,"5");
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        save();
        threadSleep(3000);
        click(stayInConstructorBtn);
        back();

        return this;
    }

    @Step(value = " ")
    public Widgets addDiagrammeWidget (){
        Metrics m = new Metrics(driver);
        String metricName = m.useMetricName();

        click(newWidgetBtn );
        click(selectGraph);
        setDiagrammeSelection();
        enterText(inputWidgetName,useWidgetDiagrammeName());
        click(addMetricBtn);
        enterText(searchForMetric, metricName);
        click(metric);
        click(addMetric);
        enterText(refreshField,"5");
        click(metricSettingsBtn);
        click(transferWidget);
        enterText(searchForWidget, useWidgetTableName());
        threadSleep(2000);
        click(selectTransferWidget);
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        save();
        threadSleep(2000);
        click(stayInConstructorBtn);
        back();

        return this;
    }

    @Step(value = " ")
    public Widgets addCitiesWidget (){
        Metrics m = new Metrics(driver);
        String metricName = m.useMetricCities();

        click(newWidgetBtn );
        click(selectGraph);
        setGraphTableSelection();
        enterText(inputWidgetName,useWidgetCitiesName());
        click(addMetricBtn);
        enterText(searchForMetric, metricName);
        click(metric);
        click(addMetric);
        enterText(refreshField,"5");
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        save();
        threadSleep(3000);
        click(stayInConstructorBtn);
        back();

        return this;
    }

    @Step(value = " ")
    public Widgets addPointsWidget (){
        Metrics m = new Metrics(driver);
        String metricName = m.useMetricPoints();

        click(newWidgetBtn );
        click(selectGraph);
        setGraphTableSelection();
        enterText(inputWidgetName,useWidgetPointsName());
        click(addMetricBtn);
        enterText(searchForMetric, metricName);
        click(metric);
        click(addMetric);
        enterText(refreshField,"5");
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        threadSleep(2000);
        save();
        threadSleep(3000);
        click(stayInConstructorBtn);
        back();

        return this;
    }
    @Step(value = "Check elements of Metrics page")
    public Widgets checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));
        
        return this;
    }
}






