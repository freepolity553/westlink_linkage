package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Archive extends BasePage{
    public Archive(WebDriver driver) {
        super(driver);
    }

    public Archive checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Документ')]"));
        isElementDisplayed(By.xpath("//button[contains(.,'Принять')]"));
        isElementDisplayed(By.xpath("//span[@class='m_text'][contains(.,'Все проекты')]"));
        isElementDisplayed(By.xpath("//div[@class='mtable__header__col col__number'][contains(.,'Инв. номер')]"));

        return this;
    }
}
