package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main extends BasePage {

    public Main(WebDriver driver) {
        super(driver);
    }
    public Main clickArchiveMenu() {
        click(By.xpath("//span[@class='hidden'][contains(.,'Архив')]"));
        return this;
    }

    public Main clickProjectsMenu() {
        click(By.xpath("//span[@class='hidden'][contains(.,'Проекты')]"));
        return this;
    }


}
