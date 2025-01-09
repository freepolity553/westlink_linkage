package samples;

//import baseSettings.WebDriverSettings;


import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.File;
import java.time.Duration;

public class APX1 {

    private final WebDriver driver;
    public void uploadFile () {
        File uploadFile = new File("src/test/resources/Акт_списания.pdf");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
    }
    public APX1(WebDriver driver) {
        this.driver = driver;
    }


    public void addPMC() {



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement projectMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='m_label'][contains(.,'Проект')]")));
        projectMenu.click();
        WebElement project = driver.findElement(By.xpath("//button[@class='dropdown-item dd-menu__item'][contains(.,'AQA123 AQA Проект')]"));

        WebElement checkBox = driver.findElement(By.xpath("//app-samples-list-chief/div/div[2]/div[1]/div[1]/app-samples-list-checkbox/app-checkbox/app-icon-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

        //Создание РВИ
        driver.findElement(By.xpath("//button[@class='primary-outline'][contains(.,'РВИ 1')]")).click();




    }
        @Step("Добавление согласующих по РВИ")
        public void addEmployees() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


            WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Изменения внес'])[1]/following::*[name()='svg'][1]")));
            elem.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement elem1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
            elem1.click();


            //Составил
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Составил'])[1]/following::*[name()='svg'][1]")));
            element.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отдел'])[1]/following::div[4]")));
            element1.click();



            WebElement num = driver.findElement(By.xpath("//div[1]/app-card-input/app-card-row/div/div[2]/div/input"));
            String numPMC = num.getAttribute("value");
            System.out.println("Номер РВИ " + numPMC);


            //Добавить файл
            uploadFile();
            WebElement file = driver.findElement(By.xpath("//span[contains(@class,'filename')]"));
            Assert.assertNotNull(file);

        }
       @Step("Отправка РВИ на подписание")
            public void sendPMCtoSign() {
           //Отправить на подписание
           driver.findElement(By.xpath("//button[@class='primary'][contains(.,'ОТПРАВИТЬ НА ПОДПИСАНИЕ')]")).click();

           WebElement alert = driver.findElement(By.xpath("//span[contains(.,'Разрешение на внесение изменений отправлено на подпись')]"));
           String actualAlert = alert.getText();
           Assert.assertEquals(actualAlert, "Разрешение на внесение изменений отправлено на подпись", "Неверное подтверждение");
           driver.navigate().refresh();
            }
        //Проверка создания  в БД
//        try {
//            String testData = QueryDBui.data();
//            System.out.println(testData);
//            Assert.assertEquals(testData, numPMC, "Отличия по РВИ");
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
    }



