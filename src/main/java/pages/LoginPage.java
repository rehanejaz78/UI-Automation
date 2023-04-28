package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.id("login-form_email");
    private By passwordField = By.id("login-form_password");
    private By signInButton = By.cssSelector("button[type='submit']");
    private By projectsMetricsTab = By.xpath("//aside/div/div/div[1]/ul/li/ul/li[1]");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigate() {
        driver.get(Utils.getElementFromPropertiesFile("url", "global"));
    }

    public void setUsername(String email) {
        String emailKey = Utils.getElementFromPropertiesFile(email, "global");
        driver.findElement(emailField).sendKeys(emailKey);
    }
    public void setPassword(String password) {
        String passwordKey = Utils.getElementFromPropertiesFile(password, "global");
        driver.findElement(passwordField).sendKeys(passwordKey);
    }

    public void login() {
        driver.findElement(signInButton).click();
    }

    public WebElement projectsMetricsTab(){

        return driver.findElement(projectsMetricsTab);

        }
    }
