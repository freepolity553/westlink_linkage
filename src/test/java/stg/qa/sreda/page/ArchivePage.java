package stg.qa.sreda.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArchivePage {

    WebDriver driver;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Версия')]")
    WebElement newVersion;

    public ArchivePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddVersionPage addVersion (){
        newVersion.click();

        return new AddVersionPage(driver);

    }

}
