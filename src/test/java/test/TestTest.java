package test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasePage;
import page.linkageVisual.Workstation;
import settings.Constants;

import java.time.Duration;


public class TestTest extends TestBase {
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

    private By secondDropdownList = By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[2]/div/div[2]");



    @Test(description = "", priority = 1)
    public void TestTest() {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
        dashboards.click(dashboards.constructorDashboards);
        dashboards.threadSleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[1]/div/div")).click();
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
        dashboards.threadSleep(3000);

        driver.findElement(By.xpath("//div[@id='root']/div/div[3]/div[4]/div/div/div/div/div/div/div/div")).click();
        driver.findElement(By.xpath("//div/div/div/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div/div/div/div/div/div/input")).sendKeys("Москва");
        driver.findElement(By.xpath("//div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[4]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div")).click();
        dashboards.threadSleep(3000);

        dashboards.isTextDisplayed(secondDropdownList,"Москва");
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
