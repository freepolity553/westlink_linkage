package archive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilites.ui.LoginPage;

import java.time.Duration;


public class APX7_DocumentExternalSupply  {


    private final WebDriver driver;

    public APX7_DocumentExternalSupply (WebDriver driver) {
        this.driver = driver;
    }


    public void documentExternalSupply()  {

        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(utilites.WebDriverSettings.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Войти в Архив как ГИП
        objArchivePage.clickRoleMenu();
        login.loginKGIP();
        objArchivePage.accessArchive();

        //Выбрать тестовый проект
        WebElement projectMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='m_label'][contains(.,'Проект')]")));
        projectMenu.click();
        WebElement project = driver.findElement(By.xpath("//button[@class='dropdown-item dd-menu__item'][contains(.,'AQA123 AQA Проект')]"));
        action.moveToElement(project).click().perform();

        //Выбрать документ для выдачи
        driver.findElement(By.xpath("(//div[contains(@class,'mtable__col col__payload')])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='mtable__col col__status'][contains(.,'Служебный')])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='primary-outline'][contains(.,'Выдать')])[2]")).click();

        //Заполнить форму выдачи
        driver.findElement(By.xpath("//input[contains(@class,'ng-untouched ng-pristine ng-valid')]")).sendKeys("ООО Тестовская");
        driver.findElement(By.xpath("//textarea[contains(@class,'ng-untouched ng-pristine ng-valid')]")).sendKeys("Выдать документ ООО Тестовская");
        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ВЫДАТЬ')]")).click();


        WebElement link = driver.findElement (By.xpath("//span[contains(.,'Скачать файл с сcылкми и QR')]"));
        String actualTitle = link.getText();
        Assert.assertEquals(true,actualTitle.contains("Скачать файл с сcылкми и QR"),"Ссылка отсутствует");

        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Скачать файл с сcылкми и QR']/parent::*")).click();



    }
}

