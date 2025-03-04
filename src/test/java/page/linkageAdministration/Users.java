package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.SharedData;
import settings.Variables;

import java.io.File;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Users extends BasePage {
    public Users(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")

    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}



    private By usersWidget =By.xpath("(//div[contains(.,'Пользователи')])[10]");

    public By usersTab =By.xpath("//button[@type='button']//span[contains(text(),'Пользователи')]");

    public By inputOrgName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv' and @placeholder='Введите название организации']");
    public By searchModal =By.xpath("//input[contains(@placeholder,'Введите название')][@class='flex-grow InputText-module_input__GBLXv pl-6']");
    public By addUserBtn = By.xpath("//button[contains(text(),'Добавить пользователя')]");
    public By editUser =By.xpath("//*[@id=\"root\"]/div/div[5]/div[2]/div[1]/div[2]/div[10]/div/a");
    private By save =By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary mr-4']");
    public By phone =By.xpath("//input[@name='Номер телефона']");
    public By lastName =By.xpath("//input[@name='Фамилия']");
    public By firstName =By.xpath("//input[@name='Имя']");
    public By email =By.xpath("//input[@name='E-mail']");
    public By login =By.xpath("//input[@name='Логин']");
    public By password =By.xpath("//input[@name='Пароль']");
    private By addGroup = By.xpath("//span[contains(text(),'Добавить группу')]");
    private By checkboxGroup = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Название группы'])[1]/following::*[name()='svg'][1]");
//    public String mockName = "test" + randomInt(4);
    public String mockEmail = randomestring(6) + "@yandex.ru";
    public By avatar =By.xpath("//div[(@class= 'UserAvatar_avatarBlock__Gu1UX UserAvatar_avatarBlockOutline__VSs8D UserAvatar_avatarBlock__outer__gXOl2 Layout-module_layout__Bjb4T Layout-module_align_center__yw5K7 Layout-module_justify_center__06P4q')]");
    public By logOut =By.xpath("//button[contains(text(),'Выйти')]");





    @Step("click Avatar")
    public Users clickAvatar (){
        click(avatar);
        return this;
    }
    @Step("logout")
    public Users logout (){
        click(logOut);
        return this;
    }

    @Step(value = "Enter Users page ")
    public Users enterUsersPage (){
        click(usersWidget);
        return this;
    }

    public void pictureUpload() {
        File uploadFile = new File("src/test/resources/600_600.jpg");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
    }

    public String useLastName() {
        // Retrieve the extracted value from the shared class
        String value = SharedData.getLastName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    public String useMockName() {
        // Retrieve the extracted value from the shared class
        String value = SharedData.getMockName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    @Step( "create New User")
    public Users createNewUser (){

        click(addUserBtn);
        pictureUpload();
        enterText(phone, randomInt(11));
        enterText(lastName,useLastName());
        enterText(firstName, Variables.firstName);
        enterText(email, mockEmail);
        enterText(login, useMockName());
        System.out.println(useMockName());
        enterText(password, useMockName());
        threadSleep(3000);
        save();
        return this;
    }

    @Step( "add Group to User")
    public Users addGroup (){

        Groups group = new Groups(driver);
        String groupName = group.useGroupName();

        System.out.println("Using Group Name in Users: " + group.useGroupName());
        waitVisibility(addGroup);
        click(addGroup);
        threadSleep(1000);
        WebElement clickable = driver.findElement(searchModal);
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(2))
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(groupName)
                .pause(Duration.ofSeconds(2))
                .perform();
        click(checkboxGroup);
        threadSleep(2000);
        click(save);
        threadSleep(2000);
        save();
        //assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Группы пользователя'])[1]/following::p[1]")).getText(), groupName);
        return this;
    }

}



