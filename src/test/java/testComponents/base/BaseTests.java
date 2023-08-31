package testComponents.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.Admin.CadencePage;
import pages.Auth.LoginPage;
import pages.HomePage.HomePage;
import pages.Admin.UserPage;
import utils.*;


import java.io.IOException;
import java.time.Duration;

public class BaseTests {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public UserPage userPage;
    public CadencePage cadencePage;

    private By Notification = By.xpath("//div[contains(@class,'ant-notification-notice-message')]");



    public WebDriver setUp() {
        String browserName = System.getProperty("browser", Utils.getElementFromPropertiesFile("browser", "global"));

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080", "--remote-allow-origins=*");
//            options.addArguments("--remote-allow-origins=*");
//            WebDriverManager.chromedriver().setup();

            System.setProperty("webdriver.chrome.driver", "/Users/rehanejaz/Downloads/chromedriver/chromedriver");

            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("firefox");
            // Handle Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("edge safari");
            // Handle Edge
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        return source;
    }


    @BeforeClass(alwaysRun = true)
    public void launchApplication(){
        driver = setUp();
        driver.get(Utils.getElementFromPropertiesFile("url", "global"));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        userPage = new UserPage(driver);
        cadencePage = new CadencePage(driver);
        loginPage.loginUser("email", "password");
    }

    public void waitForElement(By findBy, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElement(WebElement findBy, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public WebElement notification()
    {
        return driver.findElement(Notification);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
