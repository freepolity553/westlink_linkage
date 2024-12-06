package page;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Archive extends BasePage{
    public Archive(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    @Step(value = "Check elements of Archive page")
    public Archive checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Документ')]"));
        isElementDisplayed(By.xpath("//button[contains(.,'Принять')]"));
        isElementDisplayed(By.xpath("//span[@class='m_text'][contains(.,'Все проекты')]"));
        isElementDisplayed(By.xpath("//div[@class='mtable__header__col col__number'][contains(.,'Инв. номер')]"));

        return this;
    }

    public Archive isLoginWrong () {
        isAlertText("Wrong");
        return this;
    }
}
