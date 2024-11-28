package project.ui;

//import baseSettings.WebDriverSettings;


import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.api.BearerToken;
import pages.LoginPage;
import utilites.ui.RandomValue;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class CreateProjectTest extends WebDriverSettings {
    RandomValue randomValue = new RandomValue(driver);
    String name = "Авто UI Тест проект-" + randomValue.randomInt(5);



    @Test
    public void createProjectTest() {
        LoginPage login = new LoginPage(driver);


        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        login.clickRoleMenu();
        login.loginKGIP();
        login.accessProjects();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        //Выбрать тестовый проект
        WebElement project = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(.,'СОЗДАТЬ')]")));
        project.click();

        driver.findElement(By.xpath("//select[@formcontrolname='type']")).click();
        new Select(driver.findElement(By.xpath("//select[@type='text']"))).selectByVisibleText("Проектная документация");

        //Номер проекта
        driver.findElement(By.xpath("//input[contains(@name,'pr_number')]")).sendKeys(randomValue.randomInt(5));

        //Наименование
        driver.findElement(By.xpath("//input[contains(@name,'pr_name')]")).sendKeys(name);

        //Номер договора
        driver.findElement(By.xpath("//input[contains(@name,'pr_contract')]")).sendKeys("Договор-" + randomValue.randomInt(5));

        //Источник финансирования
        driver.findElement(By.xpath("//input[contains(@name,'pr_funding_source')]")).sendKeys("Прямое финансирование");

        //Местоположение
        driver.findElement(By.xpath("//input[contains(@name,'pr_location')]")).sendKeys("Тестовск-" + randomValue.randomInt(4));

        //Вид работ
        WebElement type = driver.findElement(By.xpath("//select[contains(@formcontrolname,'type_of_work')]"));
        Assert.assertNotNull(type);

        //Использование BIM
        new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Использование BIM*'])[1]/following::select[1]")))
                .selectByVisibleText("BIM не используется");

        //Шаблон
        new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Шаблон*'])[1]/following::select[1]")))
                .selectByVisibleText("ОКС производственного и непроизводственного назначения");

        //Описание
        WebElement note = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@data-placeholder='Описание...']")));
        note.click();
//        driver.findElement(By.xpath("//app-create-project/div/form/div/div[1]/div[6]/div/textarea")).click();

        driver.findElement(By.xpath("//p[@data-placeholder='Описание...']"))
                .sendKeys("Реконструкция Каширского шоссе на участке км 0 - км 4,4 b Ленинском районе.\n" +
                        "1 Зтап. СъеЗд №4-1 Водоотbодные сооружения.\n" +
                        "Трубы. РаЗbоротная петля.\n" +
                        "1695.20-РД.1-C4-1-АД5");

        //Добавить участников
        WebElement kgip = driver.findElement(By.xpath("//div[contains(@class,'employee employee_fio')]"));
        Assert.assertNotNull(kgip);

        driver.findElement(By.xpath("//button[@type='button'][contains(.,'Назначить')]")).click();

        WebElement emp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'mtable__col col__fio')])[1]")));
        emp.click();


        //Создать проект

        WebElement create = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'СОЗДАТЬ')]")));
        create.click();

    }

        @Test(description = "детальная информация о документе ", priority = 1)
        public void getNewProject() {
            BearerToken accessToken = new BearerToken();
            String token = accessToken.getAccessToken();
            // GIVEN
            given()
                    .log().all()
                    .baseUri(urlApi)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)

                    // WHEN
                    .when()
                    .get("/projects")

                    // THEN
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("data.name", Matchers.hasItem(name));


        }
    }


