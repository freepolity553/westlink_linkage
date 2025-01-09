package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.login.Login;
import page.mainPanel.Dashboard;
import settings.Constants;

public class Metrics extends BasePage {
    public Metrics(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    private By newMetricBtn =By.xpath("//a[@href='/randomInt']");

    //Конструктор показателей
    private By metricName =By.xpath("//input[contains(@id,'input-4')]");
    private By addTableBtn =By.xpath("//span[@class='ml-3'][contains(.,'Добавить таблицу')]");

    private By selectTable =By.xpath("//span[contains(.,'Платежи')]");

    //Выбор показателя
    private By addMetricField =By.xpath("(//span[contains(.,'Добавить поля')])[1]");


    @Step(value = "Enter Metrics ")
    public Metrics enterMetricsConstructor (){
        click(newMetricBtn);
        return this;
    }

    @Step(value = "Login with  {0} {1} ")
    public Metrics addMetric (String name){
        enterText(metricName,name);
        click(addTableBtn);
        click(selectTable);
        setAddBtn();
        return this;
    }
    @Step(value = "Check elements of Metrics page")
    public Metrics checkAllElementsOnPagePresent() {

        //Вкладки страницы Конструктор показателей
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));

        //
//        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор дашбордов')])[9]"));
//
//        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор АРМ')])[9]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Data Platform (Платформа данных)')]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Administration (Администрирование)')]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Digital Twin (Цифровой двойник)')]"));
//
//        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Configurator (Конфигуратор)')]"));

        return this;
    }
}






