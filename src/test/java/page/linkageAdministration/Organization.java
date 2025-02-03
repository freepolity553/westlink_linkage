package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;
import page.SharedData;

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
    public By createOrgBtn1 =By.xpath("//div[@class='OrganisationBar_organisationBar__btns__wJN+C']");
    public By inputOrgName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv' and @placeholder='Введите название организации']");
    public By login =By.xpath("//input[@name='Логин']");







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
        By newOrgName = By.xpath("//div[@role='gridcell' and @aria-colindex='1' and @aria-selected='false' and @aria-readonly='true' and contains(@class, 'rdg-cell') and contains(text(), '"+orgName+"')]");

        click(organizationTab);
        click(createOrgBtn);
        click(createOrgBtn1);
        WebElement clickable = driver.findElement(inputOrgName);
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(4))
                .click()
                .sendKeys(orgName)
                .pause(Duration.ofSeconds(1))
                .perform();

        save();
        back();

        wait.until(ExpectedConditions.presenceOfElementLocated(newOrgName));
        WebElement elm1 = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-colindex='1' and @aria-selected='false' and @aria-readonly='true' and contains(@class, 'rdg-cell') and contains(text(), '"+orgName+"')]"));
        String newOrg  = elm1.getText();
        System.out.println("Org name: " + newOrg);
        assertEquals( orgName,newOrg);

        return this;
    }
}



