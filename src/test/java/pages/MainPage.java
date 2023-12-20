package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "landing_sign")
    public WebElement signInOptionsButton;

    @FindBy(xpath = "//*[@class='go-btn'][@aria-labelledby='signInOpt3']")
    public WebElement buttonGoToRecognizedDevice;

    @FindBy(xpath = "//*[@class='go-btn'][@aria-labelledby='signInOpt2']")
    public WebElement buttonGoToUnrecognizedDevice;

    public MainPage(TestContext context) {
        super(context);
    }

    public LoginPageRecognized signInRecognized() {
        signInOptionsButton.click();
        buttonGoToRecognizedDevice.click();
        return new LoginPageRecognized(context);
    }

    public LoginPageUnrecognized signInUnrecognized() {
        signInOptionsButton.click();
        buttonGoToUnrecognizedDevice.click();
        return new LoginPageUnrecognized(context);
    }
}
