package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // object repo

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountMenu;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerButton;

    @FindBy(id = "input-firstname")
    WebElement firsnameTextField;

    @FindBy(id = "input-lastname")
    WebElement lastNameTextField;

    @FindBy(id = "input-email")
    WebElement emailTextField;

    @FindBy(id = "input-telephone")
    WebElement telephoneTextField;

    @FindBy(id = "input-password")
    WebElement passwordTextField;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordTextField;

    @FindBy(name = "agree")
    WebElement agreeCheckbox;

    @FindBy(css = ".btn.btn-primary")
    WebElement continueButton;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement yourAccountSuccessMessage;

    // business logic


    public void navigateToRegisterPage(){
        myAccountMenu.click();
        registerButton.click();
    }

    /**
     *
     * @param fn
     * @param ln
     * @param telNo
     * @param email
     * @param pssword
     * @param confirmPassword
     */
    public void enterMandatoryFields(String fn, String ln, String telNo, String email, String pssword,
                                     String confirmPassword){
        firsnameTextField.sendKeys(fn);
        lastNameTextField.sendKeys(ln);
        emailTextField.sendKeys(email);
        telephoneTextField.sendKeys(telNo);
        passwordTextField.sendKeys(pssword);
        confirmPasswordTextField.sendKeys(confirmPassword);
    }

    public void clickAgreeCheckBox(){
        agreeCheckbox.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void verifySucessTitle(){
        BasePage.assertTitle(yourAccountSuccessMessage,"Your Account Has Been Created!");
    }
}
