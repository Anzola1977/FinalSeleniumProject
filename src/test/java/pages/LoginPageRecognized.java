package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigurationReader;

public class LoginPageRecognized extends BasePage {
    @FindBy(xpath = "//button[@id='landing_sign']")
    public WebElement signInOptionsButton;

    @FindBy(xpath = "//*[@class='go-btn'][@aria-labelledby='signInOpt3']")
    public WebElement buttonGoToRecognizedDevice;

    @FindBy(className = "select-id")
    public WebElement usernameInput;

    @FindBy(id = "passcode")
    public WebElement passcodeInput;

    @FindBy(xpath = "//*[@class='link button']")
    public WebElement signInButton;

    public LoginPageRecognized(TestContext context) {
        super(context);
    }

    private void login(String username, String password) {
        usernameInput.sendKeys(username);
        passcodeInput.sendKeys(password);
        signInButton.click();
    }

    public MainPage loginAsUserWithRecognizedDevice() {
        signInOptionsButton.click();
        buttonGoToRecognizedDevice.click();
        return loginAs(ConfigurationReader.get("username"), ConfigurationReader.get("passcode"));
    }

    public MainPage loginAs(String username, String password) {
        login(username, password);
        return new MainPage(context);
    }
}
