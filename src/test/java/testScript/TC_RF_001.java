package testScript;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;

public class TC_RF_001 extends BaseTest{



    @Test
    public void TC_RF_001(){

        String fn = BasePage.getFirstName(), ln = BasePage.getLastName(),
                email = BasePage.getEmail(),mobile = BasePage.getMobileNumber(),password = BasePage.getFirstName();

        RegistrationPage rp = new RegistrationPage(driver);
        rp.navigateToRegisterPage();
        rp.enterMandatoryFields(fn,ln,mobile,email,fn,fn);
        rp.clickAgreeCheckBox();
        rp.clickOnContinueButton();
        rp.verifySucessTitle();
    }

}
