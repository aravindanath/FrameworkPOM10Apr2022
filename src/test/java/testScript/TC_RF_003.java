package testScript;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;

public class TC_RF_003 extends BaseTest{



    @Test
    public void TC_RF_001(){

        String fn = BasePage.getFirstName(), ln = BasePage.getLastName(),
                email = BasePage.getEmail(),mobile = BasePage.getMobileNumber(),password = BasePage.getFirstName();

        RegistrationPage rp = new RegistrationPage(driver);
        ExtentTest  test = report.createTest("TC_RF_002");
        test.info(driver.getCurrentUrl());
        test.info(driver.getTitle());
        rp.navigateToRegisterPage();
        rp.enterMandatoryFields(fn,ln,mobile,email,fn,fn);
        test.info(driver.getTitle());
        rp.clickAgreeCheckBox();
        rp.clickOnContinueButton();
        rp.verifySucessTitle();
    }

}
