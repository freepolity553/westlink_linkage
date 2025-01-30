package page.linkageAdministration;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.SharedData;

import java.time.Duration;

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
    //private By checkbox =By.xpath("//label[@class='Checkbox-module_label__JBaRm']");
    private By addSelectedBtn =By.xpath("//button[contains(text(),'Добавить выбранные')]");
    private By permisionSelectionBtn =By.xpath("//input[contains(@placeholder,'Выберите права')]");
    private By permisionUser =By.xpath("//div[@class='SelectRadioInfo_inputSelectMain__menu_list__X7O8v']//div[1]//div[1]//label[1]");


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


    public String useGroupName() {
        // Retrieve the extracted value from the shared class
        String value = SharedData.getGroupName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }
    @Step(value = "Add ")
    public Groups createGroup (){



        click(createGroupBtn);
        enterText(search, useGroupName());;
        click(permissionsTab);
        click(addModuleBtn);
        WebElement clickable = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Подключения")
                .perform();

        click(checkbox);
        click(addSelectedBtn);

        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);

        click(addModuleBtn);

//        WebElement clickable1 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
//        new Actions(driver)
//                .moveToElement(clickable1)
//                .click()
//                .pause(Duration.ofSeconds(1))
//                .sendKeys("Таблицы")
//                .perform();
//
//        click(checkbox);
//        click(addSelectedBtn);
//
//        //Выбор прав Пользователь
//        click(permisionSelectionBtn);
//        click(permisionUser);
//        click(addModuleBtn);
//
//        WebElement clickable2 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
//        new Actions(driver)
//                .moveToElement(clickable2)
//                .click()
//                .pause(Duration.ofSeconds(1))
//                .sendKeys("Конструктор показателей")
//                .perform();
//
//        click(checkbox);
//        click(addSelectedBtn);
//
//        //Выбор прав Пользователь
//        click(permisionSelectionBtn);
//        click(permisionUser);
//        click(addModuleBtn);
//
//
//        WebElement clickable3 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
//        new Actions(driver)
//                .moveToElement(clickable3)
//                .click()
//                .pause(Duration.ofSeconds(1))
//                .sendKeys("Конструктор виджетов")
//                .perform();
//
//        click(checkbox);
//        click(addSelectedBtn);
//
//        //Выбор прав Пользователь
//        click(permisionSelectionBtn);
//        click(permisionUser);
//
//        click(addModuleBtn);
//
//        WebElement clickable4 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
//        new Actions(driver)
//                .moveToElement(clickable4)
//                .click()
//                .pause(Duration.ofSeconds(1))
//                .sendKeys("Конструктор дашбордов")
//                .perform();
//
//        click(checkbox);
//        click(addSelectedBtn);
//
//        //Выбор прав Пользователь
//        click(permisionSelectionBtn);
//        click(permisionUser);
//
//        click(addModuleBtn);
//
//        WebElement clickable5 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
//        new Actions(driver)
//                .moveToElement(clickable5)
//                .click()
//                .pause(Duration.ofSeconds(1))
//                .sendKeys("Конструктор АРМ")
//                .perform();
//
//        click(checkbox);
//        click(addSelectedBtn);
//
//        //Выбор прав Пользователь
//        click(permisionSelectionBtn);
//        click(permisionUser);
//
//        click(addModuleBtn);

        WebElement clickable6 = driver.findElement(By.xpath("//input[@placeholder='Введите название']"));
        new Actions(driver)
                .moveToElement(clickable6)
                .click()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Конструктор алертов")
                .perform();

        click(checkbox);
        click(addSelectedBtn);
        //Выбор прав Пользователь
        click(permisionSelectionBtn);
        click(permisionUser);
        save();

        return this;
    }
}




