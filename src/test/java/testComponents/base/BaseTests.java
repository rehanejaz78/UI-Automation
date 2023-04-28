package testComponents.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Utils;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTests {

    public WebDriver driver;
    public LoginPage loginPage;

    public WebDriver setUp() {
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : Utils.getElementFromPropertiesFile("browser", "global");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080"); // so that it may not enter into mobile size window.
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("firefox");
            // Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge
            System.out.println("edge safari");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;

    }
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        return source;
    }
    @BeforeSuite(alwaysRun = true)
    public LoginPage launchApplication() {
        driver = setUp();
        loginPage = new LoginPage(driver);
        return loginPage;

    }

    public String userRole(){
        String userRole =  Utils.getElementFromPropertiesFile("userRole", "global");
        return userRole;
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }




}
