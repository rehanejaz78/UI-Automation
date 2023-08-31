package tests.homePageTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import testComponents.base.BaseTests;
import utils.*;


public class HomePageTests extends BaseTests {

    @Test(priority = 1)
    public void validateUserRole(){
        if(homePage.userRole().getText().equals(Role.Super_Admin.getText())){
            waitForWebElement(homePage.userRole(), Duration.ofSeconds(20));
            Assert.assertEquals(homePage.userRole().getText(), Role.Super_Admin.getText());
        }
        else{
            System.out.println("Undefined Role");
        }
    }

    @Test (priority = 2)
    public void validateLeftBarMenu() {
        if(homePage.userRole().getText().equals(Role.Super_Admin.getText())){
            waitForWebElement((homePage.adminTab()), Duration.ofSeconds(20));
            Assert.assertTrue(homePage.adminTab().isDisplayed());
            Assert.assertEquals(homePage.adminTab().getText(), "Admin");
            homePage.adminTab().click();
            // Admin's Menu
                waitForWebElement(homePage.cadenceTab(), Duration.ofSeconds(20));
                Assert.assertTrue(homePage.cadenceTab().isDisplayed());
                Assert.assertTrue(homePage.projectMetricsTab().isDisplayed());
                Assert.assertTrue(homePage.resourceTeamTab().isDisplayed());
                Assert.assertTrue(homePage.userTab().isDisplayed());
                Assert.assertTrue(homePage.billingTab().isDisplayed());

            Assert.assertEquals(homePage.projectManagerTab().getText(), "Project Manager");
            Assert.assertEquals(homePage.resourceManagerTab().getText(), "Resource Manager");

        }
        else{
            System.out.println("Undefined Role");
        }
    }

}
