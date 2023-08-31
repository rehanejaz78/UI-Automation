package tests.adminModuleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.BaseTests;
import utils.Role;

import java.time.Duration;

public class CadencePageTest extends BaseTests {


    @Test(priority = 1)
    public void agileCadenceTest() {

        if (homePage.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(homePage.adminTab(), Duration.ofSeconds(20));
            homePage.adminTab().click();
            waitForWebElement(cadencePage.agileCadenceLabel(), Duration.ofSeconds(10));

            try {
                if (cadencePage.activateBtnAgile().isDisplayed()) {
                    cadencePage.addAgileCadence("2023-08-31", "10", "1");
                    cadencePage.activateBtnAgile().click();
                    //assertion
                    String agileMessage = "Agile details saved successfully";
                    waitForWebElement(notification(), Duration.ofSeconds(5));
                    Assert.assertEquals(notification().getText(), agileMessage);
                }

                if (cadencePage.sdlcActivateBtn().isDisplayed()) {
                    Thread.sleep(5000);
                    cadencePage.addSdlcCadence("2023-08-31", "Rehan");
                    cadencePage.sdlcActivateBtn().click();
                    //assertion
                    String sdlcMessage = "SDLC details saved successfully";
                    waitForWebElement(notification(), Duration.ofSeconds(5));
                    Assert.assertEquals(notification().getText(), sdlcMessage);
                }
            } catch (Exception exception) {
                System.out.println("Not found");
            }

        }
    }


}
