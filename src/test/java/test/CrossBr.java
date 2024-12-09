package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import page.ArchiveMain;
import page.Login;
import page.Main;

import java.util.Set;


public class CrossBr {
    public static final String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    //String SITE_URL = "https://dev-stroytransgaz.april-inn.ru";
    public WebDriver driver;
    public Main main;
    public Login login;
    public ArchiveMain archiveMain;
    Set<Cookie> cookies;

    @BeforeClass
    @Parameters("browser")
    public void initialization(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-search-engine-choice-screen");
            options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");
            options.setAcceptInsecureCerts(true);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-search-engine-choice-screen");
            options.addArguments("--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints");
            options.setAcceptInsecureCerts(true);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver = new ChromeDriver(options);
        }

        //driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        main = PageFactory.initElements(driver, Main.class);
        login = PageFactory.initElements(driver, Login.class);
        archiveMain = PageFactory.initElements(driver, ArchiveMain.class);

    }
}
