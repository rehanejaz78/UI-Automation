package tests.login;

import org.openqa.selenium.By;
import testComponents.base.BaseTests;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests {

    @Test
    public void successfulLogin() {
        loginPage.setUsername("emai");
        loginPage.setPassword("password");
        loginPage.login();

    }
}
