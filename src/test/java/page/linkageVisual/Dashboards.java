package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import page.BasePage;

import java.util.List;

import static page.SharedData.getDashboardName;

public class Dashboards extends BasePage {
    public Dashboards(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}



    public By constructorDashboards =By.xpath("//div[contains(text(),'Конструктор дашбордов')]");
    private By newDashboardtBtn =By.xpath("//button[contains(text(),'Создать дашборд')]");

    //Конструктор дашбордов

    private By inputDashboardName =By.xpath("//input[@placeholder='Введите название']");
    private By addWidgetBtn =By.xpath("//div[@class='TopBar_icon__cgG0k'][contains(text(),'Добавить')]");
    //private By inputWidgetName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv'and @placeholder='Введите заголовок виджета']");

    private By searchForWidget =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder='Введите название']");






    private By checkboxWidget = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск по названию'])[1]/following::*[name()='svg'][2]");

    private By addWidgetModalBtn = By.xpath("//button[contains(text(),'Добавить на холст')]");

    private By addFilteringBtn = By.xpath("//div[@class='FiltersData_filterData__qnQxY']");

    private By dataFilter = By.xpath("//span[@class='ButtonFilter_label__t8Ut2']");

    private By selectOperation = By.xpath("//div[@class='slct__value-container slct__value-container--has-value css-1hwfws3']");

    private By enterDate =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pr-6']");

    private By datePicker = By.xpath("//div[@class='InputText-module_icon__8XMHv InputText-module_icon_inner__dPCVH InputText-module_icon_inner_right__cJwjN']");


    private By oper = By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary mr-2']");


    private String dataSource = "Локальная витрина";


    public String useDashboardName() {
        // Retrieve the extracted value from the shared class
        String value = getDashboardName();

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


    @Step(value = "Login with  {0} {1} ")
    public Dashboards addDashboard(){
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
        click(statusReadyForWork);
        save();

        return this;
    }
    @Step(value = "Login with  {0} {1} ")
    public Dashboards addFiltering(){
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

    @Step(value = "Check elements of Dashboard page")
    public Dashboards checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));
        
        return this;
    }
}






