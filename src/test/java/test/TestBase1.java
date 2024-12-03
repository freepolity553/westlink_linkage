package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import page.Archive;
import page.Login;
import page.Main;

public class TestBase1 {
    public static final String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    //String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    public WebDriver driver;
    public Main main;
    public Login login;
    public Archive archive;




    public String url = "https://dev-stroytransgaz.april-inn.ru";
    //public String url = "https://next-stroytransgaz.april-inn.ru/";

    //public String urlDraft = "https://dev-stroytransgaz.april-inn.ru/new-archive/projects/1";
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

        //options.addArguments("--headless=new");


        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Duration duration = Duration.of(2, ChronoUnit.SECONDS);
        //options.setImplicitWaitTimeout(duration);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        main = PageFactory.initElements(driver,Main.class);
        login = PageFactory.initElements(driver,Login.class);
        archive = PageFactory.initElements(driver,Archive.class);


    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
