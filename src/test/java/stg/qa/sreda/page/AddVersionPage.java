package stg.qa.sreda.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVersionPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@type='button'][contains(.,'ЗАГРУЗИТЬ ФАЙЛ')]")
    WebElement uploadFile;

    public AddVersionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddVersionPage addVersion() {
        uploadFile.click();

        return new AddVersionPage(driver);

    }
}


