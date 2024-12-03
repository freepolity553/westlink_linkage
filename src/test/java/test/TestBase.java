package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import page.Archive;
import page.Login;
import page.Main;

public class TestBase {
    public static final String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    //String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    public WebDriver driver;
    public Main main;
    public Login login;
    public Archive archive;


    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        main = PageFactory.initElements(driver,Main.class);
        login = PageFactory.initElements(driver,Login.class);
        archive = PageFactory.initElements(driver,Archive.class);

    }

//    @AfterEach
//    public void finish() {
//        driver.quit();
//    }
}
