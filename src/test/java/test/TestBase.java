package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page.SharedData;
import page.linkageAdministration.Groups;
import page.linkageAdministration.Organization;
import page.linkageAdministration.Users;
import page.linkageDataPlatform.Connections;
import page.linkageVisual.Dashboards;
import page.linkageVisual.Metrics;
import page.linkageVisual.Widgets;
import page.linkageVisual.Workstation;
import page.login.Login;
import page.mainPanel.MainPanel;
import settings.Variables;
import utilites.RandomValue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class TestBase {


    public WebDriver driver;
    public Login login;
    public MainPanel mainPanel;
    public Metrics metrics;
    public Widgets widgets;
    public Users users;
    public Groups groups;
    public Organization organization;
    public Dashboards dashboards;
    public RandomValue randomValue;
    public Variables variables;
    public SharedData data;
    public Workstation workstation;
    public Connections connections;
    public WebDriverWait wait;




    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        // Get the project root directory
        String projectPath = System.getProperty("user.dir");
        System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
        // Define the download directory within the project
        String downloadPath = projectPath + "\\src\\test\\resources\\widgetXlsx";

        // Create ChromeOptions and set preferences
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        // Create a map to store Chrome preferences
        Map<String, Object> prefs = new HashMap<>();

        // Set the download directory
        prefs.put("download.default_directory", downloadPath);

        // Disable the download prompt
        prefs.put("download.prompt_for_download", false);

        prefs.put("select_file_dialogs.allowed", "false");
        prefs.put("download.directory_upgrade", true);
        prefs.put("credentials_enable_service", Boolean.FALSE);
        prefs.put("profile.password_manager_enabled", Boolean.FALSE);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("safebrowsing.disable_download_protection", true);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://89.169.150.123/");
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
        mainPanel = PageFactory.initElements(driver, MainPanel.class);
        metrics =  PageFactory.initElements(driver, Metrics.class);
        users =  PageFactory.initElements(driver, Users.class);
        groups =  PageFactory.initElements(driver, Groups.class);
        randomValue = PageFactory.initElements(driver, RandomValue.class);
        organization= PageFactory.initElements(driver, Organization.class);
        variables = PageFactory.initElements(driver, Variables.class);
        data = PageFactory.initElements(driver, SharedData.class);
        widgets = PageFactory.initElements(driver, Widgets.class);
        dashboards = PageFactory.initElements(driver, Dashboards.class);
        workstation = PageFactory.initElements(driver, Workstation.class);
        connections = PageFactory.initElements(driver, Connections.class);


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
