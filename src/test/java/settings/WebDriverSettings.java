package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;


public class WebDriverSettings {


    public WebDriver driver;


    //public String url = "https://dev-stroytransgaz.april-inn.ru";
    public String url = "https://next-stroytransgaz.april-inn.ru/";

    //public String urlDraft = "https://dev-stroytransgaz.april-inn.ru/new-archive/projects/1";
    //public String urlApi = "https://dev-stroytransgaz.april-inn.ru/api/v1";
    public String urlApi = "https://next-stroytransgaz.april-inn.ru/api/v1";
    public String cardTitle = "";

    public String cardTitle2 = "";

    public int c = 0;

    public String cardPrice = "";

    public String cardPrice2 = "";
    public  int rand ;

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
        Duration duration = Duration.of(2, ChronoUnit.SECONDS);
        options.setImplicitWaitTimeout(duration);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }

    /**
     * Метод генерирует  случайное число в диапазоне от 1 до полученного количества товаров и переходит на страницу товара
     */
    public void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void clickButton(WebElement element){
        element.click();
    }
    public void clearText (WebElement element){
        element.clear();
    }


    @FindBy(xpath = "//button[@class='primary'][contains(.,'ЗАГРУЗИТЬ ФАЙЛ')]")
    WebElement upload_file;



    @FindBy (xpath = "//input[@class='input-control']")
    WebElement textField;
    public void selectRandomNumber() {
        List<WebElement> xpath = driver.findElements(By.xpath("//div[@class='tiles']/div[@class='tile m-default m-border']/a[@class='inner-link']"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(xpath.size());
        xpath.get(randomProduct).click();
    }

    /**
     * Метод для получения названия первого товара
     */
    public void getICardTitle() {
        WebElement itemTitle = driver.findElement(By.xpath("//h1"));
        cardTitle = itemTitle.getText();
    }

    /**
     * Метод для получения названия второгоо товара
     */
    public void uploadFile() {
        //WebElement button = upload_file;
        upload_file.click();
    }

    /**
     * Метод для получения цены первого товара
     */

    public void getCardPrice() {
        WebElement itemTitle = driver.findElement(By.xpath("//span[starts-with(@class, 'b3411b')]"));
        cardPrice = itemTitle.getText();
    }

    /**
     * Метод для получения цены второго товара
     */

    public void getCardPrice2() {
        WebElement itemTitle = driver.findElement(By.xpath("//span[starts-with(@class, 'b3411b')]"));
        cardPrice2 = itemTitle.getText();
    }

    /**
     * Метод для сравнения первого полученного названия товара из корзины, с названием товара полученным в функции getICardTitle()
     */

    public void comparisonTitle() {
        WebElement cart = driver.findElement(By.xpath("//a[@class='title']/span"));
        String currentCart = cart.getText();
        Assert.assertTrue(currentCart.equals(cardTitle));
    }

    /**
     * Метод для сравнения второго полученного названия товара из корзины, с названием товара полученным в функции getICardTitle2()
     */

    public void comparisonTitle2() {
        WebElement cart = driver.findElement(By.xpath("//a[@class='title']/span"));
        String currentCart = cart.getText();
        Assert.assertTrue(currentCart.equals(cardTitle2));
    }

    /**
     * Метод для добавления товара в корзину
     */

    public void addCart() {
        if (driver.findElement(By.xpath("//button[contains(text(),'Добавить в корзину')]")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@class='_652bc6']")).click();
            c++;
        } else {
            driver.navigate().back();
            selectRandomNumber();
        }
    }

    /**
     * Метод проверяет совпадает ли количество товаров в корзине с ожидаемым значением
     */

    public void comparisonCart() {
        WebElement itemTitle = driver.findElement(By.xpath("//a[@class='_651b68 _2a1234']/span[@class='f-caption--bold ef9580']"));
        String b = itemTitle.getText();
        Assert.assertTrue(c == Integer.parseInt(b));

    }

    /**
     * Метод проверяет совпадает ли итоговая сумма за товары в корзине с ожидаемым значением
     * В методе присутсвует удаление символов и пустых строк с помощью регулярных выражений,
     * перевод полученных строковых значений в числовые,для удобства сравнения
     */

    public void comparisionPrice() {
        String result = cardPrice.replaceAll("₽", "");
        String result2 = cardPrice2.replaceAll("₽", "");
        String joo = result.replaceAll("\\s+", "");
        String joo2 = result2.replaceAll("\\s+", "");
        int foo = Integer.parseInt(joo);
        int fool = Integer.parseInt(joo2);
        int sum = foo + fool;
        WebElement priceItem = driver.findElement(By.xpath("//span[@class='total-middle-footer-text']"));
        String cardPriceResult = priceItem.getText();
        String cardPriceResult1 = cardPriceResult.replaceAll("₽", "");
        String joel = cardPriceResult1.replaceAll("\\s+", "");
        Assert.assertTrue(sum == Integer.parseInt(joel));
    }

    /**
     * Метод удаляет товары из корзины
     */

    public void deleteItems() {
        WebElement deleteButton = driver.findElement(By.xpath("//span[@class='dc5e23 a443c8']"));
        deleteButton.click();
        WebElement deleteButtonAjax = driver.findElement(By.xpath("//button[@class='button button blue']"));
        deleteButtonAjax.click();
    }

    /**
     * Метод проверяет очистилась ли корзина
     */

    public void emptyCart() {
        WebElement itemTitle = driver.findElement(By.xpath("//h1"));
        String n = itemTitle.getText();
        Assert.assertTrue(n.equals("Корзина пуста"));
    }



}