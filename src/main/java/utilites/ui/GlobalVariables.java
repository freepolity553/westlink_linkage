package utilites.ui;

//import baseSettings.WebDriverSettings;


import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class GlobalVariables extends WebDriverSettings {
    // Declare a static variable
    public static int globalVar = 100;

    public static void main(String[] args) {
        // Access the static variable directly using the class name
        System.out.println(GlobalVariables.globalVar);

        // Modify the static variable
        GlobalVariables.globalVar = 200;

        // Access the static variable from another method
        anotherMethod();
    }

    public static void anotherMethod() {
        // Access the static variable
        System.out.println(GlobalVariables.globalVar);
    }

    }


