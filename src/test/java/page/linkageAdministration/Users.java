package page.linkageAdministration;

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

public class Users extends BasePage {
    public Users(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    private By usersWidget =By.xpath("(//div[contains(.,'Пользователи')])[10]");



    @Step(value = "Enter Users ")
    public page.linkageAdministration.Users enterUsersPage (){
        click(usersWidget);
        return this;
    }

//    @Step(value = "Login with  {0} {1} ")
//    public page.linkageVisual.Metrics addMetric (String name){
//        enterText(metricName,name);
//        click(addTableBtn);
//        click(selectTable);
//        setAddBtn();
//        return this;
//    }
//    @Step(value = "Check elements of Metrics page")
//    public page.linkageVisual.Metrics checkAllElementsOnPagePresent() {
//
//        //Вкладки страницы Конструктор показателей
//        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Конструктор запроса')]"));
//        isElementDisplayed(By.xpath("(//button[@type='button'][contains(.,'SQL-запрос')])[1]"));
//        isElementDisplayed(By.xpath("//button[@type='button'][contains(.,'Формула')]"));
//
//
//        return this;
//    }
}



