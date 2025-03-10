package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import page.BasePage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    private By refreshRateTable = By.xpath("//div[8]/div[2]/div/div/div/input");
    private By refreshRateDiagramme = By.xpath("//div[9]/div[2]/div/div/div/input");

    private By stayInConstructorBtn =By.xpath("//button[@class='Button-module_main__lxsaF btnOutlinePrimary ConfirmationModal_btn__uOPAs']");

    private By statusSavedWidget  =By.xpath("//p[@class='WidgetTopBar_attention__nameDone__m1cSM']");

    private By metricSettingsBtn = By.xpath("//button[contains(text(),'Настройки показателей')]");

    private By transferWidget  =By.xpath("//div[17]/div[2]/div[2]/div/label");
    private By searchForWidget =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv SelectInfiniteCore_inputClass__GpexQ pr-6' and @placeholder='Выберите виджет']");

    private By selectTransferWidget = By.xpath("//div[2]/div[2]/div/p");


    public String useWidgetTableName() {
        String value = getWidgetTableName();

        return value;
    }

    public String useWidgetDiagrammeName() {
        String value = getWidgetDiagrammeName();
        return value;
    }
    public String useWidgetCitiesName() {

        String value = getWidgetCitiesName();
        return value;
    }
    public String useWidgetPointsName() {
        String value = getWidgetPointsName();

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


    @Step( "add Table Widget ")
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
        enterText(refreshRateTable,"5");
        threadSleep(2000);
        click(draftBtn);
        threadSleep(2000);
        click(statusReadyForWork);
        threadSleep(2000);
        save();
        threadSleep(15000);
        click(stayInConstructorBtn);
        back();

        return this;
    }

    @Step("add Diagramme Widget ")
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
        enterText(refreshRateDiagramme ,"5");
        click(metricSettingsBtn);
        click(transferWidget);
        enterText(searchForWidget, useWidgetTableName());
        threadSleep(2000);
        click(selectTransferWidget);
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        save();
        threadSleep(15000);
        click(stayInConstructorBtn);
        back();

        return this;
    }

    @Step("add Cities Widget ")
    public Widgets addCitiesWidget () throws IOException {
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
        enterText(refreshRateTable,"5");
        threadSleep(2000);
        getCityName();
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        save();
        threadSleep(10000);
        click(stayInConstructorBtn);
        back();

        return this;
    }
    public String getCityName() {

        WebElement cityName = driver.findElement(By.xpath("//div[2]/div[2]/div/div/p"));
        String value = cityName.getText();
        System.out.println("City in widget-"+value);

        return value;
    }

    @Step("add Points Widget ")
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
        enterText(refreshRateTable,"5");
        threadSleep(2000);
        click(draftBtn);
        click(statusReadyForWork);
        threadSleep(2000);
        save();
        threadSleep(10000);
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
    @Step( "read Excell")
    public  String readExcell() throws IOException {
        String projectPath = System.getProperty("user.dir");
        File dir = new File(projectPath + "\\src\\test\\resources\\widgetXlsx");
        File[] files = dir.listFiles((dir1, name) -> name.startsWith("metric_data_") && name.endsWith(".xlsx"));
        while (files == null || files.length == 0) {
            files = dir.listFiles((dir1, name) -> name.startsWith("metric_data_") && name.endsWith(".xlsx"));
        }
        File downloadedFile = files[0];

            //Path of the excel file
            FileInputStream fs = new FileInputStream(downloadedFile);
            //Creating a workbook
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(1);
            String city = cell.getStringCellValue();
            System.out.println("City in excell-"+city);
//            System.out.println(sheet.getRow(1).getCell(0));

        return city            ;

        }
    public Widgets get() {

//        WebElement cityName = driver.findElement(By.xpath("/html/body/div[1]/div/div[7]/div[2]/div/div[2]/div[2]"));
//        String value = string;
//        System.out.println(value);

        return this;
    }

}






