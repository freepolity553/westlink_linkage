package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Archive extends BasePage{
    public Archive(WebDriver driver) {
        super(driver);
    }

    public void checkPageIsCorrect(){
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Документ')]"));
    }
}
