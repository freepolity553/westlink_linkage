package linkageTests;

import org.openqa.selenium.By;
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

    private By datePicker = By.xpath("//div[@class='InputText-module_icon__8XMHv InputText-module_icon_inner__dPCVH InputText-module_icon_inner_right__cJwjN']");
    private By oper = By.xpath("//div[3]/div[3]/button[1]");
    private By metricCheckbox2 = By.xpath("//div[3]/div[2]/div[2]/div/div[1]/div/label");
    private By filterSettingsCity = By.cssSelector("svg.FilterItem_checkBox__icon__hXCuZ");
    private By filterSettingsPoint = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Настроить созависимую фильтрацию'])[1]/following::*[name()='svg'][4]");
    private By filterMetricBtn = By.xpath("//div[@role='presentation']//div[3]//div[1]//label[1]");
    private By addMetricBtn = By.xpath("//button[contains(text(),'Добавить показатель')]");
    private By inputMetric = By.xpath("//div[5]/div/div[1]/div/div[1]/input");
    private By addMetric = By.xpath("//button[contains(text(),'Вставить')]");
    private By addKey = By.xpath("//div[2]/div/div/div[1]/div[2]/div/input");
    private By selectKey = By.xpath("//div[3]/div[2]/div/div/div/div/div/input");
    private By addName = By.xpath("//div[3]/div/div/div[1]/div[2]/div/input");
    private By selectName = By.xpath("//div[3]/div[3]/div/div/div/div/div/input");
    private By save = By.xpath("//div[3]/div[3]/button[1]");
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
    private By selectKeyForPoint = By.xpath("//div[contains(text(),'city_id')]");
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
//        metrics.threadSleep(2000);
//        metrics.click(mainPanel.adminDashboard);
//        dashboards.click(dashboards.constructorDashboards);
//        driver.navigate().to("http://89.169.150.123/dashboard/55");
//
//        widgets.threadSleep(5000);
//        dashboards.click(addFilteringBtn);
        visualization.addVisualTheme();










}
}
