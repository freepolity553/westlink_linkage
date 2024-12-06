package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import settings.Constants;

import static org.testng.AssertJUnit.assertEquals;


public class SelectTest extends TestBaseExample {



    @Test()
    public void  newWindowHandaling() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        String parentTitle = driver.getTitle();
        driver.findElement(By.linkText("Click Here")).click();


    }


    @Test()
    public void  checkSelectByValue() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByValue("1");
        WebElement option = select.getFirstSelectedOption();
        assertEquals("Option 1",option.getText());

    }
    @Test()
    public void  checkSelectByVisibleText() {
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        WebElement option = select.getFirstSelectedOption();
        assertEquals("Option 1",option.getText());

    }

}
