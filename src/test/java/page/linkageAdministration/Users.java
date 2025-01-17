package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import page.BasePage;
import page.login.Login;
import page.mainPanel.Dashboard;
import settings.Constants;

import java.io.File;

public class Users extends BasePage {
    public Users(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    private By usersWidget =By.xpath("(//div[contains(.,'Пользователи')])[10]");

    public By usernameSearch =By.xpath("//input[contains(@placeholder,'Введите название')]");

    public By editUser =By.xpath("//*[@id=\"root\"]/div/div[5]/div[2]/div[1]/div[2]/div[10]/div/a");
    public By picture =By.xpath("//div[@class='AddPicture_addPicture_view__CwcBp']");
    public By phone =By.xpath("//input[@name='Номер телефона']");




    @Step(value = "Enter Users page ")
    public page.linkageAdministration.Users enterUsersPage (){
        click(usersWidget);
        return this;
    }

    public void pictureUpload() {
        File uploadFile = new File("src/test/resources/600_600.jpg");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        //driver.findElement(By.id("file-submit")).click();
        //WebElement fileName = driver.findElement(By.xpath("//span[contains(.,'file.txt')]"));
//        Assertions.assertEquals("600_600.jpg", picture.getText());
    }

//    @Step(value = "Login with  {0} {1} ")
//    public page.linkageVisual.Metrics addMetric (String name){
//        enterText(metricName,name);
//        click(addTableBtn);
//        click(selectTable);
//        addRecord();
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



