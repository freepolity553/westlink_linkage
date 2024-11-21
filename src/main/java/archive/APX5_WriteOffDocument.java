package archive;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilites.ui.LoginPage;

import java.io.File;
import java.time.Duration;

public class APX5_WriteOffDocument  {

    private final WebDriver driver;

    public APX5_WriteOffDocument (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Списание документов")
    public void writeOffDocument() {
        LoginPage login = new LoginPage(driver);
        ArchivePage objArchivePage = new ArchivePage(driver);
        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.get(utilites.WebDriverSettings.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        objArchivePage.clickRoleMenu();
        login.loginArch();


        //Войти в Архив как Архивриус
        objArchivePage.accessArchive();

        //Выбрать тестовый проект
        WebElement projectMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='primary-outline'][contains(.,'Все проекты')]")));
        projectMenu.click();
        WebElement project = driver.findElement(By.xpath("//button[@class='dropdown-item dd-menu__item'][contains(.,'AQA123 AQA Проект')]"));
        action.moveToElement(project).click().perform();

        //Выбрать документ и нажать списать
        WebElement version = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-archive-book/div/app-archive-list-archivist/div/div[2]/div[1]/div[2]/div[1]")));
        version.click();

        //app-archive-list-archivist/div/div[2]/div[1]/div[2]
        //app-archive-book/div/app-archive-list-archivist/div/div[2]/div[1]/div[2]/div[1]
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'Списать')]")).click();

        //Выбрать сотрудника для списания
        WebElement employee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='primary-outline'][contains(.,'Выберите сотрудника')]")));
        employee.click();

        WebElement employee1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-card-select/app-card-row/div/div[2]/app-dropdown/div/div/button[1]")));
        employee1.click();

        //Добавление причины списания
        driver.findElement(By.xpath("//textarea[contains(@rows,'8')]")).clear();
        driver.findElement(By.xpath("//textarea[contains(@rows,'8')]")).sendKeys("Списать документ");

        driver.findElement(By.xpath("//button[@class='primary'][contains(.,'СПИСАТЬ')]")).click();

        // Cохраняем окно
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.xpath("(//span[contains(.,'Скачать акт списания на подпись')])[2]")).click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.switchTo().window(winHandleBefore);

        WebElement buttonWriteOff = driver.findElement (By.xpath("//div[@class='actions__status'][contains(.,'Документ ожидает списания')]"));
        String actualbuttonWriteOff = buttonWriteOff.getText();
        Assert.assertEquals(actualbuttonWriteOff,"Документ ожидает списания","Текст отсутствует");

        //Добавить файл Акта списания
        File uploadFile = new File("src/test/resources/Акт_списания.pdf");
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        WebElement writeOff = driver.findElement (By.xpath("//button[@class='primary'][contains(.,'СПИСАТЬ')]"));
        writeOff.click();
        //Подтверждение списания документа
        WebElement writeOffAct = driver.findElement (By.xpath("//h4[contains(.,'Документ списан')]"));
        String actualwriteOffAct = writeOffAct.getText();
        Assert.assertEquals(actualwriteOffAct,"Документ списан","Текст отсутствует");
    }
}

