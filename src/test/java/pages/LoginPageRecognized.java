package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class LoginPageRecognized extends BasePage {

    @FindBy(className = "select-id")
    public WebElement usernameInput;

    @FindBy(id = "passcode")
    public WebElement passcodeInput;

    @FindBy(xpath = "//*[@class='link button']")
    public WebElement signInButton;

    public LoginPageRecognized(TestContext context) {
        super(context);
    }

    public NewAccountPage loginAsUserWithRecognizedDevice() {
        context.wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(ConfigurationReader.get("username"));
        passcodeInput.sendKeys(ConfigurationReader.get("passcode"));
        signInButton.click();
        return new NewAccountPage(context);
    }
}
