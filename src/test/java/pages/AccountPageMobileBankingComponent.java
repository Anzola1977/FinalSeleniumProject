package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageMobileBankingComponent extends BasePage{
    public AccountPageMobileBankingComponent(TestContext context) {
        super(context);
    }

    String defaultWindow = context.driver.getWindowHandle();

    @FindBy(css = "#username_field")
    public WebElement userIDField;

    @FindBy(id = "passcode_field")
    public WebElement passwordField;

    @FindBy(css = "#sign_in_button")
    public WebElement logInButton;

    @FindBy(xpath = "//*[@class='left_control current_page accounts_btn_on_accts_page'][text()='Accounts']")
    public WebElement accounts;

    @FindBy(xpath = "//*[@class='text-header col']/button")
    public WebElement mobileBankingSimulatorButton;

    @FindBy(css = "#device_iframe")
    public WebElement frameElement;
}
