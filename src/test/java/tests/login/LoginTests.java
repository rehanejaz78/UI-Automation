package tests.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import testComponents.base.BaseTests;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests {

    @Test
    public void successfulLogin() {
        loginPage.navigate();
        loginPage.setUsername("email");
        loginPage.setPassword("password");
        loginPage.login();

    }

    @Test
    public void validateLeftBarMenu(){
        if(userRole().equals("SuperAdmin")){
            Assert.assertTrue(loginPage.projectsMetricsTab().isDisplayed());
        }
        else{
            System.out.println("Undefined Role");
        }
    }
}
