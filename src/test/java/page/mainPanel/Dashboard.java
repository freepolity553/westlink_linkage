package page.mainPanel;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import page.BasePage;
import page.login.Login;
import settings.Constants;

public class Dashboard extends BasePage {
    public Dashboard(WebDriver driver) {
        super(driver);
    }
    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot () {return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}

    private By selectUserBtn =By.xpath("//p[@class='SelectARM_cardName__ARdPm'][contains(.,'Администратор')]");
    private By passwordInput =By.xpath("//input[contains(@type,'password')]");
    private By submitBtn =By.xpath("//button[contains(@type,'submit')]");
    public By adminDashboard =By.xpath("//a[contains(text(),'Панель административного управления')]");
    private By avatar =By.xpath("//img[contains(@alt,'Аватар пользователя')]");




    @Step(value = "Enter Dashboard ")
    public Dashboard enterDashboard (){
        waitVisibility(selectUserBtn);
        click(selectUserBtn);
        driver.get(Constants.URL_MAIN);

//        driver.switchTo().newWindow(WindowType.TAB);


        return this;
    }

    @Step(value = "Enter Profile ")
    public Dashboard enterProfile (){
        waitVisibility(avatar);
        click(avatar);
        return this;
    }
    @Step(value = "Check elements of Dashboard page")
    public Dashboard  checkAllElementsOnDashboardPresent() {
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





