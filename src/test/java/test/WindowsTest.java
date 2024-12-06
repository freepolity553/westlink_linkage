package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class WindowsTest extends TestBaseExample {



    @Test()
    public void  checkDropdownTitle() {
        driver.get("https://the-internet.herokuapp.com/windows");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        WebElement text = select.getFirstSelectedOption();
        assertEquals("Please select an option",text);

    }


    @Test()
    public void  checkSelectByValue() {
        driver.get("https://the-internet.herokuapp.com/windows");
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
