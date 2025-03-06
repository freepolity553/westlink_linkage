package page.mainPanel;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;

public class MainPanel extends BasePage {
    public MainPanel(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

//    private By selectAPMBtn =By.xpath("//p[@class='SelectARM_cardName__ARdPm'][text()='Администратор']");
    private By selectAPMBtn =By.xpath("//div[(@class= 'SelectARM_card__Cc7wd Layout-module_layout__Bjb4T Layout-module_align_center__yw5K7 Layout-module_direction_column__t9XzY')]");

    private By passwordInput =By.xpath("//input[contains(@type,'password')]");
    private By submitBtn =By.xpath("//button[contains(@type,'submit')]");
    public By adminDashboard =By.xpath("//a[contains(text(),'Панель административного управления')]");
    private By avatar =By.xpath("//img[contains(@alt,'Аватар пользователя')]");




    @Step(value = "Enter MainPanel ")
    public MainPanel enterDashboard (){

        wait.until(ExpectedConditions.elementToBeClickable(selectAPMBtn));
        waitClickable(selectAPMBtn);
        click(selectAPMBtn);

        return this;
    }

    @Step(value = "Enter Profile ")
    public MainPanel enterProfile (){
        waitVisibility(avatar);
        click(avatar);
        return this;
    }
    @Step(value = "Check elements of MainPanel page")
    public MainPanel checkAllElementsOnDashboardPresent() {
        isElementDisplayed(By.xpath("//a[@class='BreadCrumbs_link__LlVJc'][contains(.,'АРМ Администратора')]"));
        isElementDisplayed(By.xpath("//a[@class='BreadCrumbs_link__LlVJc'][contains(.,'Панель административного управления')]"));
        isElementDisplayed(By.xpath("//a[@aria-current='page'][contains(.,'Панель администратора')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Подключения')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Настройка таблиц')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Показатели')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Виджеты')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Дашборды')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'АРМ')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Алерты')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Пользователи')]"));
        isElementDisplayed(By.xpath("//a[@href='/plugins/gamification/']"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Заработная плата')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Рабочее время')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Конструктор проектов')]"));
        isElementDisplayed(By.xpath("//a[@class='SidebarMenu_asideLink__0QbFE SidebarMenu_asideMin__4pP-U'][contains(.,'Динамическое распределение проектов')]"));
        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Visual (Визуализация)')]"));
        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор показателей')])[9]"));
        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор виджетов')])[9]"));
        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор дашбордов')])[9]"));
        isElementDisplayed(By.xpath("(//div[contains(.,'Конструктор АРМ')])[9]"));
        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Data Platform (Платформа данных)')]"));
        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Administration (Администрирование)')]"));
        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Digital Twin (Цифровой двойник)')]"));
        isElementDisplayed(By.xpath("//p[contains(.,'Linkage Configurator (Конфигуратор)')]"));

        return this;
    }
}





