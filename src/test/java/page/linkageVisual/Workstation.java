package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.linkageAdministration.Groups;
import page.linkageAdministration.Users;

import java.time.Duration;
import java.util.List;

import static page.SharedData.getDashboardName;
import static page.SharedData.getWorkstationName;

public class Workstation extends BasePage {
    public Workstation(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}



    public By constructorWorkstation =By.xpath("//div[contains(text(),'Конструктор АРМ')]");
    private By newWorkstationtBtn =By.xpath("//button[contains(text(),'Создать АРМ')]");


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






    public String useWorkstationName() {
        // Retrieve the extracted value from the shared class
        String value = getWorkstationName();

        // Perform actions with the extracted value (e.g., enter it into another field)
        return value;
    }

    public void setDiagrammeSelection() {
        WebElement ulElement = driver.findElement(By.xpath("//ul[@class='SelectWidgetType_dropDownChildWrapper__xB01v']"));
        // Find all <li> elements within the parent
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Iterate through the <li> elements and click on a specific one
        for (WebElement li : liElements) {
            if (li.getText().equals("Диаграмма области")) {
                li.click(); // Click the <li> element
                break; // Exit the loop after clicking
            }
        }
    }

    Dashboards d = new Dashboards(driver);
    String dashboardName = d.useDashboardName();

    Groups g = new Groups(driver);
    String groupName = g.useGroupName();

    Users u = new Users(driver);
    String userLastName = u.useLastName();


    @Step("add Workstation ")
    public Workstation addWorkstation(){



        click(newWorkstationtBtn );
        enterText(inputWorkstationName,useWorkstationName());
        click(addWorkstationElement);
        click(addDashboard);
        threadSleep(2000);
        enterText(searchForDashboard,dashboardName);
        threadSleep(2000);
        click(checkbox);
        click(selectDashboard);
        click(accessSettings);
        threadSleep(2000);
        enterText(searchForGroup, groupName);
        threadSleep(2000);
        click(selectGroup);
        threadSleep(2000);
        click(searchForEmployee);
        threadSleep(2000);
        click(selectEmployee);
        threadSleep(2000);


        driver.findElement(By.xpath("//button[@class='Button-module_main__lxsaF Button-module_xsmall__QS3d- Button-module_auto_width__Fgo4W btnPrimary']")).click();

        threadSleep(2000);
        click(stayInConstructorBtn);
        back();

        return this;
    }

}









