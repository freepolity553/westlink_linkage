package stg.qa.sreda.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    protected WebDriver driver;

    @FindBy(xpath="//span[@class='hidden'][contains(.,'Архив')]")
    WebElement menuArchive;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ArchivePage enterArchive (){
        menuArchive.click();

        return new ArchivePage(driver);

    }
//    public void checkThatArchiveIsOpened (){
//    Assert.assertEquals(actualbuttonWriteOff,"Документ ожидает списания","Текст отсутствует");
//    }
}
