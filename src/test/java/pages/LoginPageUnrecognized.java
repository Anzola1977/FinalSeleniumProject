package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPageUnrecognized extends BasePage {

    @FindBy(css = "input#username")
    public WebElement usernameInput;

    @FindBy(css = "input#passcode")
    public WebElement passcodeInput;

    @FindBy(xpath = "//*[@class='link button']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@class='link blue-button']")
    public WebElement sendCodeButton;

    @FindBy(xpath = "//*[@name='radio1']")
    public WebElement rememberRadioButton;

    @FindBy(xpath = "//*[@class='link blue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@class='blue-button ml-0']")
    public WebElement continueButton2;

    @FindBy(className = "form-check-input")
    public List<WebElement> consentCheckboxes;

    public LoginPageUnrecognized(TestContext context) {
        super(context);
    }

    public NewAccountPage loginAsUserWithUnrecognizedDevice() {
        context.wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.click();
        passcodeInput.click();
        signInButton.click();
        sendCodeButton.click();
        rememberRadioButton.click();
        continueButton.click();
        for (int i = 0; i < consentCheckboxes.size(); i++) {
            consentCheckboxes.get(i).click();
        }
        continueButton2.click();
        return new NewAccountPage(context);
    }
}
