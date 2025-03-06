package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.SharedData;
import settings.Variables;

import java.time.Duration;
import java.util.List;

public class Visualization extends BasePage {
    public Visualization(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")

    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    private By visualizationModule =By.xpath("//div[contains(text(),'Визуальное оформление')]");
    private By createThemeBtn =By.xpath("//button[contains(text(),'Добавить визуальную тему')]");
    private By inputThemeName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv' and @placeholder='Введите название']");
    private By themesDropdownList =By.xpath("//div[4]/button");

    private By inputThemeColor =By.xpath("//div[8]/div[2]/input");




    Users user = new Users(driver);


    @Step("add Visualization Theme")
    public Visualization addVisualTheme (){

        click(visualizationModule);
        click(createThemeBtn);
        enterText(inputThemeName,Variables.themeName);
        save();
        threadSleep(5000);
        user.clickAvatar();
        threadSleep(15000);
        click(themesDropdownList);
        threadSleep(2000);
        WebElement newTheme = driver.findElement(By.xpath("//span[contains(text(),'"+Variables.themeName+"')]"));
        newTheme.click();
        return this;
    }
}



