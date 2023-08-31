package tests.adminModuleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.BaseTests;
import utils.Role;
import utils.Utils;

import java.time.Duration;

public class UserPageTests extends BaseTests {


    @Test(priority = 1)
    public void addUserTest() {
        if (homePage.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(homePage.adminTab(), Duration.ofSeconds(20));
            homePage.adminTab().click();
            homePage.userTab().click();
            waitForWebElement(userPage.currentUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.currentUsersTab().isDisplayed());
            userPage.currentUsersTab().click();

            waitForWebElement(userPage.addNewUserBtn(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.addNewUserBtn().isDisplayed());
            Assert.assertEquals(userPage.addNewUserBtn().getText(), "Add New User");
            userPage.addNewUserBtn().click();
            waitForWebElement(userPage.addUserFormLabel(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.addUserFormLabel().isDisplayed());
            userPage.addUser(Utils.getRandomString(6), Utils.getRandomString(6), "General User", "hassanqayyum94@yopmail.com", "United States of America 1", "0123456789");
        }

    }

    @Test(priority = 2)
    public void updateUserTest() {
        if (homePage.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(homePage.adminTab(), Duration.ofSeconds(20));
            homePage.adminTab().click();
            homePage.userTab().click();
            waitForWebElement(userPage.currentUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.currentUsersTab().isDisplayed());
            userPage.currentUsersTab().click();

            //action
            userPage.actionBtn().click();
            waitForWebElement(userPage.editOption(), Duration.ofSeconds(20));
            userPage.editOption().click();
            waitForWebElement(userPage.editUserFormLabel(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.editUserFormLabel().isDisplayed());
            userPage.updateUser(Utils.getRandomString(6), Utils.getRandomString(6), "Project Manager");
            // verify update
            String updateMessage = "User updated successfully";
            waitForWebElement(userPage.updateNotification(), Duration.ofSeconds(20));
            Assert.assertEquals(userPage.updateNotification().getText(), updateMessage);


        }

    }

    @Test(priority = 3)
    public void revokeUserTest() {

        if (homePage.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(homePage.adminTab(), Duration.ofSeconds(20));
            homePage.adminTab().click();
            homePage.userTab().click();
            waitForWebElement(userPage.currentUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.currentUsersTab().isDisplayed());
            userPage.currentUsersTab().click();
            userPage.activeLabel().click();

            //action
            userPage.actionBtn().click();
            waitForWebElement(userPage.revokeOption(), Duration.ofSeconds(20));
            userPage.revokeOption().click();
            waitForWebElement(userPage.editUserFormLabel(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.editUserFormLabel().isDisplayed());
            userPage.revokeLicenceBtn().click();

            // verify Revoke user
            String revokeMessage = "User revoked successfully";
            waitForWebElement(userPage.updateNotification(), Duration.ofSeconds(20));
            Assert.assertEquals(userPage.updateNotification().getText(), revokeMessage);
        }
    }

    @Test(priority = 4)
    public void grantAccessTest() {
        if (homePage.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(homePage.adminTab(), Duration.ofSeconds(20));
            homePage.adminTab().click();
            homePage.userTab().click();
            waitForWebElement(userPage.currentUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(userPage.currentUsersTab().isDisplayed());
            userPage.currentUsersTab().click();
            userPage.revokedLabel().click();
            //action
            userPage.actionBtn().click();

            waitForWebElement(userPage.grantAccessOption(), Duration.ofSeconds(10));
            userPage.grantAccessOption().click();
            waitForWebElement(userPage.grantAccessBtn(), Duration.ofSeconds(20));
            userPage.grantAccessBtn().click();

            // verify Revoke user
            String grantMessage = "User reactivated successfully";
            waitForWebElement(userPage.updateNotification(), Duration.ofSeconds(20));
            Assert.assertEquals(userPage.updateNotification().getText(), grantMessage);
        }

    }

}
