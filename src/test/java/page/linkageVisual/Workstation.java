package page.linkageVisual;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import page.BasePage;
import page.linkageAdministration.Groups;
import page.linkageAdministration.Users;

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

    //Конструктор дашбордов

    private By inputWorkstationName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv' and @placeholder='Введите название для АРМ']");
    private By addWorkstationElement =By.xpath("//button[contains(text(),'Добавить элемент')]");
    //private By inputWidgetName =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv'and @placeholder='Введите заголовок виджета']");
    private By searchForDashboard =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv pl-6' and @placeholder='Введите название']");
    private By checkboxWidget = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск по названию'])[1]/following::*[name()='svg'][2]");
    private By addDashboard = By.xpath("//button[@class='Button-module_main__lxsaF btnPrimary mr-2 ModalAddDashboard_btn__s2Alp']");
    private By accessSettings = By.xpath("//button[contains(text(),'Настройки доступа')]");
    private By searchForGroup =By.xpath("//input[@class='flex-grow InputText-module_input__GBLXv SelectInfiniteCore_inputClass__GpexQ pr-6' and @placeholder='Выберите группу']");
    private By searchForEmployee =By.xpath("//div[@class='slct__value-container slct__value-container--is-multi css-1hwfws3']");


    private By dataFilter = By.xpath("//span[@class='ButtonFilter_label__t8Ut2']");

    private By selectOperation = By.xpath("//div[@class='slct__value-container slct__value-container--has-value css-1hwfws3']");





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


    @Step(value = "Login with  {0} {1} ")
    public Workstation addWorkstation(){
        Dashboards d = new Dashboards(driver);
        String dashboardName = d.useDashboardName();

        Groups g = new Groups(driver);
        String groupName = g.useGroupName();

        Users u = new Users(driver);
        String userLastName = u.useLastName();


        click(newWorkstationtBtn );
        enterText(inputWorkstationName,useWorkstationName());
        click(addWorkstationElement);
        click(By.xpath("//p[contains(text(),'Дашборды')]"));

        enterText(searchForDashboard,dashboardName);
        click(checkbox);
        click(addDashboard);
        click(accessSettings);
        enterText(searchForGroup, groupName);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите из списка'])[1]/preceding::p[1]"));
        enterText(searchForEmployee, userLastName);

//        threadSleep(2000);
//        click(checkboxWidget);
//        click(addWidgetModalBtn);
//        click(addWidgetBtn);
//
//        threadSleep(2000);
//        click(checkboxWidget);
//        click(addWidgetModalBtn);
//        threadSleep(2000);
//        click(draftBtn);
//        click(statusReadyForWork);
//        save();

        return this;
    }

}









