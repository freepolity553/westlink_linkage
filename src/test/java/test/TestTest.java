package test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import page.BasePage;
import page.linkageVisual.Workstation;
import settings.Constants;

import java.time.Duration;


public class TestTest extends TestBase {

    public By constructorWorkstation =By.xpath("//div[contains(text(),'Конструктор АРМ')]");
    private By newWorkstationtBtn =By.xpath("//button[contains(text(),'Создать АРМ')]");

    //Конструктор дашбордов

    private By inputWorkstationName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv' and @placeholder='Введите название для АРМ']");
    private By addWorkstationElement =By.xpath("//button[contains(text(),'Добавить элемент')]");
    private By addDashboard = By.xpath("//p[contains(text(),'Дашборды')]");
    private By searchForDashboard =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder='Введите название']");
    private By checkboxWidget = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск по названию'])[1]/following::*[name()='svg'][2]");
    private By selectDashboard = By.xpath("//button[@class='Button-module_main__lxsaF btnPrimary mr-2 ModalAddDashboard_btn__s2Alp']");
    private By accessSettings = By.xpath("//button[contains(text(),'Настройки доступа')]");
    private By searchForGroup =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv SelectInfiniteCore_inputClass__GpexQ pr-6' and @placeholder='Выберите группу']");
    private By searchForEmployee =By.xpath("//div[@class='slct__placeholder css-1wa3eu0-placeholder']");
    private By selectEmployee = By.xpath("//div[2]/div/div[2]/span");
    private By enterEmployee =By.xpath("//div[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div/div/div/div/div/div/input");
    private By selectGroup = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите из списка'])[1]/preceding::p[1]");
    private By stayInConstructorBtn =By.xpath("//button[@class='Button-module_main__lxsaF btnOutlinePrimary ConfirmationModal_btn__uOPAs']");

    @Test(description = "Login", priority = 1)
    public void TestTest() {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
        workstation.click(workstation.constructorWorkstation);
        workstation.click(newWorkstationtBtn );
        workstation.enterText(inputWorkstationName, workstation.useWorkstationName());
        workstation.click(addWorkstationElement);
        workstation.click(addDashboard);
        workstation.enterText(searchForDashboard, "vileda_new_data");
//        enterText(searchForDashboard,"Дашборд 957");
        workstation.click(workstation.checkbox);
        workstation.click(selectDashboard);
        workstation.click(accessSettings);
        workstation.enterText(searchForGroup, "Авто Группа-8779");
        workstation.threadSleep(2000);
//        enterText(searchForGroup, "Авто Группа-5295");
        workstation.click(selectGroup);
        workstation.threadSleep(2000);
        workstation.click(searchForEmployee);
//        enterText(enterEmployee, "ТЕСТfpaG");
        workstation.threadSleep(1000);

        workstation.click(selectEmployee);
//        enterText(searchForEmployee, userLastName);
        workstation.threadSleep(2000);
//        pressEnter(enterEmployee);

//        WebElement clickable = driver.findElement(By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary']"));
//        new Actions(driver)
//                .moveToElement(clickable)
//                .pause(Duration.ofSeconds(1))
//                .click()
//                .perform();
        driver.findElement(By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary']")).click();
        workstation.click(stayInConstructorBtn);
        workstation.back();



}
}
