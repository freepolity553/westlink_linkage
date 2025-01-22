package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;

import java.io.File;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class Groups extends BasePage {
    public Groups(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}


    private By groupsTab =By.xpath("//span[contains(text(),'Группы')]");
    private By createGroupBtn =By.xpath("//button[contains(text(),'Создать группу')]");
    private By permissionsTab =By.xpath("//button[contains(text(),'Доступы')]");
    private By addModuleBtn =By.xpath("//button[contains(text(),'Добавить Модуль')]");
    private By chekbox =By.xpath("//label[@class='Checkbox-module_label__JBaRm']");
    private By addSelectedBtn =By.xpath("//button[contains(text(),'Добавить выбранные')]");
    private By permisionSelectionBtn =By.xpath("//input[contains(@placeholder,'Выберите права')]");
    private By permisionUser =By.xpath("//div[@class='SelectRadioInfo_inputSelectMain__menu_list__X7O8v']//div[1]//div[1]//label[1]");


    //label[@for='checkbox_201']//*[name()='svg']
    //div[@class='SelectRadioInfo_inputSelectMain__menu_list__X7O8v']//div[1]//div[1]//label[1]
//input[@id='input-192']
    //label[@for='checkbox_37']//*[name()='svg']
    //label[@for='checkbox_62']//*[name()='svg']




    @Step(value = "Enter Groups page ")
    public Groups enterGroupsPage (){
        click(groupsTab);
        return this;
    }

    @Step(value = "Permissions ")
    public Groups enterPermissions  (){
        click(permissionsTab);
        return this;
    }

    @Step(value = "Add ")
    public Groups createGroup (){
        click(createGroupBtn);

        enterText(search,"Авто Группа-" + random(5) );
        click(permissionsTab);
        click(addModuleBtn);
        WebElement clickable = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Подключения")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);

        click(addModuleBtn);

        WebElement clickable1 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable1)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Таблицы")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);
        click(addModuleBtn);

        WebElement clickable2 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable2)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Конструктор показателей")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);
        click(addModuleBtn);


        WebElement clickable3 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable3)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Конструктор виджетов")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);

        click(addModuleBtn);

        WebElement clickable4 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable4)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Конструктор дашбордов")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);

        click(addModuleBtn);

        WebElement clickable5 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable5)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Конструктор АРМ")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);

        click(addModuleBtn);

        WebElement clickable6 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable6)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Конструктор алертов")
                .perform();

        click(chekbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);

        //save();

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



