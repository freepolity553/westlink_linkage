package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Random;


public class DriverSettingsAPI {


    public WebDriver driver;


    public String urlApi = "https://dev-stroytransgaz.april-inn.ru/api/v1";
    //public String urlApi = "https://next-stroytransgaz.april-inn.ru/api/v1";


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
//        driver = new FirefoxDriver();
//        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");

        options.addArguments("--headless=new");


        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Duration duration = Duration.of(2, ChronoUnit.SECONDS);
        //options.setImplicitWaitTimeout(duration);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }




}