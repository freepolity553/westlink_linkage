package test;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import page.linkageAdministration.Groups;
import page.linkageAdministration.Users;
import page.linkageVisual.Metrics;
import page.login.Login;
import page.mainPanel.Dashboard;
import utilites.RandomValue;


public class TestBase {
//    public static final String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";

    public WebDriver driver;
    public Login login;
    public Dashboard dashboard;
    public Metrics metrics;
    public Users users;
    public Groups groups;
    public RandomValue randomValue;

    public WebDriverWait wait;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

       ChromeOptions options = new ChromeOptions();
       //FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");

        //options.addArguments("--headless=new");


        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Duration duration = Duration.of(2, ChronoUnit.SECONDS);
        //options.setImplicitWaitTimeout(duration);
        driver = new ChromeDriver(options);
//        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


//        driver.execute_script('window.localStorage.clear();');
//        driver.localStorage.clear();


        login = PageFactory.initElements(driver,Login.class);
        dashboard = PageFactory.initElements(driver, Dashboard.class);
        metrics =  PageFactory.initElements(driver, Metrics.class);
        users =  PageFactory.initElements(driver, Users.class);
        groups =  PageFactory.initElements(driver, Groups.class);
        randomValue = PageFactory.initElements(driver, RandomValue.class);



    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
