package pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.id("login-form_email");
    private By passwordField = By.id("login-form_password");
    private By signInButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }




    public void loginUser(String email, String password){
        String emailKey = Utils.getElementFromPropertiesFile(email, "global");
        driver.findElement(emailField).sendKeys(emailKey);
        String passwordKey = Utils.getElementFromPropertiesFile(password, "global");
        driver.findElement(passwordField).sendKeys(passwordKey);
        driver.findElement(signInButton).click();

    }

}
