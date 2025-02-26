package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Constants;

import java.io.IOException;

import static groovyjarjarantlr4.v4.gui.Trees.save;


public class TestTest extends TestBase {




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
    private By oper = By.xpath("//div[3]/div[3]/button[1]");
    private By metricCheckbox2 = By.xpath("//div[3]/div[2]/div[2]/div/div[1]/div/label");
    private By filterSettingsCity = By.cssSelector("svg.FilterItem_checkBox__icon__hXCuZ");
    private By filterSettingsPoint = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Настроить созависимую фильтрацию'])[1]/following::*[name()='svg'][4]");
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
    private By connectBtn = By.xpath("//div[1]/button[2]");
    private By selectField1 = By.xpath("//div[3]/div[2]/div/div/div/div/div/div[2]");
    private By selectField2 = By.xpath("//div[3]/div[2]/div/div[3]/div[2]/div[1]/div/div[1]/div[2]/div/input");
    private By field1 = By.xpath("//div[3]/div[2]/div/div/div[2]/div/div[2]/div/div");
    private By field2 = By.xpath("//div[2]/div/div[2]/div/div[2]");
    private By back =By.cssSelector("svg.AddWidgetFilter_arrowBack__OXzcF > path");
    public By checkboxCity =By.xpath("//div[1]/div/div[1]/div/label");
    public By checkboxPoint =By.xpath("//div[2]/div/div[1]/div/label");
    private By firstDropdown = By.xpath("//div[4]/div/div[1]/div[1]/div[1]/div/div[1]/div/div");
    private By searchFirstDropdown = By.xpath("//div/div/div/div/div/div/input");
    public By secondDropdown = By.xpath("//div[4]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div");
    public By secondDropdownList = By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[2]/div/div[2]");


    @Test(description = "", priority = 1)
    public void TestTest() throws IOException {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
//        metrics.threadSleep(3000);
//        driver.navigate().to("http://89.169.150.123/metric/95");
//        metrics.threadSleep(3000);
//        metrics.click(requestValidationBtn);
//        metrics.threadSleep(3000);
//        metrics.getCityName();
//        metrics.threadSleep(2000);
//        metrics.save();
        metrics.threadSleep(2000);
        metrics.click(mainPanel.adminDashboard);
        dashboards.click(dashboards.constructorDashboards);
        dashboards.threadSleep(3000);
        driver.findElement(By.xpath("//div[2]/div[6]/div/a[1]")).click();
        dashboards.threadSleep(4000);
        driver.findElement(By.xpath("//div[3]/div[5]/div/div/div[1]/div/div/div[1]/div[2]")).click();
        widgets.threadSleep(5000);
        widgets.readExcell();
        Assert.assertEquals(widgets.getCityName(),widgets.readExcell());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/button")).click();
        dashboards.click(addFilteringBtn);


        dashboards.click(checkboxCity);
        dashboards.click(filterSettingsCity);
        dashboards.threadSleep(1000);
        dashboards.click(filterMetricBtn);
        dashboards.click(addMetricBtn);
        dashboards.threadSleep(1000);
        dashboards.click(inputMetric);
        dashboards.threadSleep(2000);
        dashboards.setMetricCities();
        dashboards.threadSleep(1000);
        dashboards.click(addMetric);
        dashboards.threadSleep(1000);
        dashboards.click(addKey);
        dashboards.threadSleep(2000);
        dashboards.enterText(addKey,"id");
        dashboards.threadSleep(2000);
        dashboards.pressEnter(selectKey);
        dashboards.threadSleep(2000);
        dashboards.click(addName);
        dashboards.threadSleep(2000);
        dashboards.enterText(addName,"city_name");
        dashboards.threadSleep(2000);
        dashboards.pressEnter(selectName);
        dashboards.threadSleep(2000);
        dashboards.click(save);

        //Add Points filter
        dashboards.click(metricCheckbox2);
        dashboards.click(filterSettingsPoint);
        dashboards.threadSleep(1000);
        dashboards.click(filterMetricBtn);
        dashboards.click(addMetricBtn);
        dashboards.click(inputMetric);
        dashboards.setMetricPoints();
        dashboards.click(addMetric);
        dashboards.threadSleep(3000);
        dashboards.click(addKey);
        dashboards.threadSleep(3000);
        dashboards.enterText(addKey,"id");
        dashboards.threadSleep(3000);
        dashboards.pressEnter(selectKey);
        dashboards.threadSleep(2000);
        dashboards.click(addName);
        dashboards.threadSleep(3000);
        dashboards.enterText(addName,"point_name");
        dashboards.pressEnter(selectName);
        dashboards.threadSleep(2000);
        dashboards.click(save);
        dashboards.threadSleep(1000);
        dashboards.click(save);
        dashboards.threadSleep(3000);

        //setCodependentFiltering
        dashboards.click(selectFilters);
        dashboards.threadSleep(3000);
        dashboards.click(setCodependentFilteringBtn);
        dashboards.threadSleep(2000);
        dashboards.click(createConnectionBtn);
        dashboards.threadSleep(2000);
        dashboards.click(inputFilter1);
        dashboards.threadSleep(2000);
        dashboards.click(selectCity);
        dashboards.click(inputFilter2);
        dashboards.threadSleep(1000);
        dashboards.click(inputFilter2);
        dashboards.click(selectPoint);
        dashboards.threadSleep(1000);
        dashboards.click(connectBtn);
        dashboards.threadSleep(2000);
        dashboards.click(selectField1);
        dashboards.threadSleep(3000);
        dashboards.click(field1);
        dashboards.threadSleep(1000);
        dashboards.click(selectField2);
        dashboards.click(selectField2);
        dashboards.click(field2);
        dashboards.click(save);
        dashboards.click(save);
        dashboards.click(back);
        dashboards.click(save);
        dashboards.save();
        dashboards.threadSleep(3000);
        dashboards.click(firstDropdown);
        dashboards.enterText(searchFirstDropdown,"Москва");
        dashboards.pressEnter(searchFirstDropdown);
        dashboards.threadSleep(5000);
        dashboards.click(secondDropdown);
        dashboards.threadSleep(2000);




//        dashboards.click(selectFilters);
//        dashboards.click(setCodependentFilteringBtn);
//        dashboards.click(createConnectionBtn);
//        dashboards.click(inputFilter1);
//        dashboards.click(selectCity);
//        dashboards.click(inputFilter2);
//        dashboards.threadSleep(2000);
//        dashboards.click(inputFilter2);
//        dashboards.click(selectPoint);
//        dashboards.threadSleep(1000);
//        dashboards.click(connectBtn);
//        dashboards.threadSleep(2000);
//        dashboards.click(selectField1);
//        dashboards.threadSleep(3000);
//        dashboards.click(field1);
//        dashboards.threadSleep(1000);
//        dashboards.click(selectField2);
//        dashboards.click(selectField2);
//        dashboards.click(field2);
//        dashboards.threadSleep(1000);
//        dashboards.click(save);
//        dashboards.threadSleep(1000);
//        dashboards.click(save);
//        dashboards.threadSleep(1000);
//        driver.findElement(By.cssSelector("svg.AddWidgetFilter_arrowBack__OXzcF > path")).click();
//        dashboards.threadSleep(2000);
//        dashboards.click(save);
//
//        dashboards.save();
//        dashboards.threadSleep(5000);

//        driver.findElement(By.xpath("//button[1]//div[1]")).click();
//        dashboards.threadSleep(2000);
//        driver.findElement(By.xpath("//div[@id='root']/div/div[3]/div[5]/div/div/div[2]/div/div/div[2]/div/div[2]/div/canvas")).click();
//        driver.findElement(By.xpath("//div/div/div/div/div/div/input")).clear();
//        driver.findElement(By.xpath("//div/div/div/div/div/div/input")).sendKeys("Москва");
//        driver.findElement(By.xpath("//div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
//
//        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div")).click();
//        dashboards.threadSleep(3000);
//
//        dashboards.isTextDisplayed(secondDropdownList,"Москва");
//        WebElement elm = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[2]/div/div[2]"));
//        String city = elm.getText();
//        System.out.println(city);
//        Assert.assertEquals(city,"Москва");


//        WebElement city = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[1]/label"));
//
//
//        city.click(); //City
//        dashboards.threadSleep(3000);
//        city.sendKeys("Москва");
//        city.sendKeys(Keys.ENTER);
//
//        dashboards.threadSleep(3000);
//
//        WebElement point =driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/input")); //Точка






}
}
