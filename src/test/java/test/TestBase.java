package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import page.archive.ArchiveAddVersion;
import page.archive.ArchiveMain;
import page.Login;
import page.MainDashboard;
import page.projects.ProjectsMain;

public class TestBase {
    public static final String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    //String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    public WebDriver driver;
    public MainDashboard main;
    public Login login;
    public ArchiveMain archiveMain;
    public ArchiveAddVersion archiveAddVersion;
    public ProjectsMain projectsMain;
    public WebDriverWait wait;


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

        //options.addArguments("--headless=new");


        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Duration duration = Duration.of(2, ChronoUnit.SECONDS);
        //options.setImplicitWaitTimeout(duration);
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        main = PageFactory.initElements(driver, MainDashboard.class);
        login = PageFactory.initElements(driver,Login.class);
        archiveMain = PageFactory.initElements(driver, ArchiveMain.class);
        archiveAddVersion =  PageFactory.initElements(driver, ArchiveAddVersion.class);
        projectsMain = PageFactory.initElements(driver, ProjectsMain.class);


    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
