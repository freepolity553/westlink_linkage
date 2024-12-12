package page;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MainDashboard extends BasePage {

    public MainDashboard(WebDriver driver) {
        super(driver);
    }



    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}



    @Step (value = "ArchiveMain menu access")
    public MainDashboard clickArchiveMenu() {
        click(By.xpath("//span[@class='hidden'][contains(.,'Архив')]"));
        return this;
    }
    @Step(value = "Project menu access")
    public MainDashboard clickProjectsMenu() {
        click(By.xpath("//span[@class='hidden'][contains(.,'Проекты')]"));
        return this;
    }


}
