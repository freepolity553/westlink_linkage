package page;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Main extends BasePage {

    public Main(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    @Step (value = "Archive menu access")
    public Main clickArchiveMenu() {
        click(By.xpath("//span[@class='hidden'][contains(.,'Архив')]"));
        return this;
    }
    @Step(value = "Project menu access")
    public Main clickProjectsMenu() {
        click(By.xpath("//span[@class='hidden'][contains(.,'Проекты')]"));
        return this;
    }


}
