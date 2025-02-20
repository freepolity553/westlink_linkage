package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;
import page.SharedData;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Organization extends BasePage {
    public Organization(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")

    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    public By organizationTab =By.xpath("//button[@type='button']//span[contains(text(),'Организации')]");
    public By createOrgBtn =By.xpath("//button[contains(text(),'Создать организацию')]");
    public By createOrgBtnModal =By.xpath("//div[@class='OrganisationBar_organisationBar__btns__wJN+C']");
    public By inputOrgName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv' and @placeholder='Введите название организации']");
    public By login =By.xpath("//input[@name='Логин']");
    private By addBtn =By.xpath("//button[contains(text(),'Добавить')]");
    public By addOrgUser =By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить руководителя'])[1]/following::span[1]");
    public By addOrgDirector =By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить cотрудников'])[1]/preceding::span[1]");
    public By search =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder='Введите название']");
    public By radioBtn =By.xpath("//label[contains(@class, 'Radio-module_figure__mwmU8')]");
    private By checkboxAddEmployee =By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Активен'])[1]/preceding::*[name()='svg'][1]");



    public String useOrgName() {
        // Retrieve the extracted value from the shared class
        String value = SharedData.getOrgName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }

    @Step(value = "")
    public Organization addOrg (){

        String orgName = useOrgName();
        System.out.println(orgName);
        By newOrgName = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+orgName+"'])[1]/preceding::div[2]");

        click(organizationTab);
        click(createOrgBtn);
        click(createOrgBtnModal);
        WebElement clickable = driver.findElement(inputOrgName);
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(2))
                .pause(Duration.ofSeconds(3))
                .perform();

        slowSendKeys(clickable, orgName, 100); // 100ms delay between characters


        Users user = new Users(driver);
        String lastName = user.useLastName();
        System.out.println("Using Last Name : " + user.useLastName());
        waitVisibility(addOrgDirector);
        click(addOrgDirector);
        WebElement clickable2 = driver.findElement(search);
        new Actions(driver)
                .moveToElement(clickable2)
                .pause(Duration.ofSeconds(2))
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(lastName)
                .pause(Duration.ofSeconds(2))
                .perform();
        click(radioBtn);
        click(addBtn);

//        waitVisibility(addOrgUser);
//        click(addOrgUser);
//        WebElement clickable1 = driver.findElement(search);
//        new Actions(driver)
//                .moveToElement(clickable1)
//                .pause(Duration.ofSeconds(2))
//                .click()
//                .pause(Duration.ofSeconds(2))
//                .sendKeys(lastName)
//                .pause(Duration.ofSeconds(2))
//                .perform();
//        click(checkboxAddEmployee);
//        click(addBtn);
        threadSleep(3000);
        save();
        threadSleep(5000);
        back();
        threadSleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(newOrgName));
//        WebElement elm = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-colindex='1' and @aria-selected='false' and @aria-readonly='true' and contains(@class, 'rdg-cell') and contains(text(), '"+orgName+"')]"));
//        String newOrg  = elm.getText();
//        System.out.println("Org name: " + newOrg);
//        assertEquals( orgName,newOrg);

        return this;
    }
    @Step(value = "")
    public Organization addOrgUsers (){

        Users user = new Users(driver);
        String lastName = user.useLastName();
        System.out.println("Using Last Name : " + user.useLastName());
        waitVisibility(addOrgDirector);
        click(addOrgDirector);
        WebElement clickable = driver.findElement(search);
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(2))
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(lastName)
                .pause(Duration.ofSeconds(2))
                .perform();
        click(radioBtn);
        click(addBtn);

        waitVisibility(addOrgUser);
        click(addOrgUser);
        WebElement clickable1 = driver.findElement(search);
        new Actions(driver)
                .moveToElement(clickable1)
                .pause(Duration.ofSeconds(2))
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(lastName)
                .pause(Duration.ofSeconds(2))
                .perform();
        click(checkboxAddEmployee);
        click(addBtn);


        //assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Группы пользователя'])[1]/following::p[1]")).getText(), groupName);
        return this;
    }
}



