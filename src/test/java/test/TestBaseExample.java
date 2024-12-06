package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import page.Archive;
import page.Login;
import page.Main;
import settings.Constants;

public class TestBaseExample {
    public static final String SITE_URL = "https://the-internet.herokuapp.com/dropdown";

    public WebDriver driver;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        ChromeOptions options = new ChromeOptions();
//        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dropdown");



    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
