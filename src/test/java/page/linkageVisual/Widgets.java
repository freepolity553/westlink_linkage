package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import page.BasePage;
import page.SharedData;
import page.linkageAdministration.Groups;
import settings.Variables;

import java.util.List;

import static page.SharedData.getMetricName;
import static page.SharedData.getWidgetName;

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

    private By refreshField = By.xpath("//input[@id='input-67']");
    private By stayInConstractorBtn  =By.xpath("//button[@class='Button-module_main__lxsaF btnOutlinePrimary ConfirmationModal_btn__uOPAs']");

    private By statusSavedWidget  =By.xpath("//p[@class='WidgetTopBar_attention__nameDone__m1cSM']");

    private By selectStatusBtn = By.xpath("//button[contains(text(),'Черновик')]");
    private By statusReadyForWork = By.xpath("//div[contains(text(),'Готов к работе')]");






    //input[@id='input-992']
    //date
    private String dataSource = "Локальная витрина";


    public String useWidgetName() {
        // Retrieve the extracted value from the shared class
        String value = getWidgetName();

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


    @Step(value = "Login with  {0} {1} ")
    public Widgets addTableWidget (){
        Metrics m = new Metrics(driver);
        String metricName = m.useMetricName();

        click(newWidgetBtn );
        click(selectGraph);
        setGraphTableSelection();
        enterText(inputWidgetName,useWidgetName());
        click(addMetricBtn);
        enterText(searchForMetric, metricName);
        click(metric);
        click(addMetric);
        enterText(refreshField,"5");
        click(selectStatusBtn);
        click(statusReadyForWork);
        save();
        click(stayInConstractorBtn);

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






