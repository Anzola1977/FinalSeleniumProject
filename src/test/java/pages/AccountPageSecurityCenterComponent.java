package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageSecurityCenterComponent extends BasePage{
    public AccountPageSecurityCenterComponent(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//*[@class='security-dropdown dropdown nav-item']")
    public WebElement securityCenterMenu;

    @FindBy(xpath = "//*[@class='passcode-btn']")
    public WebElement updatePasswordButton;

    @FindBy(xpath = "//*[@name='label1']")
    public  WebElement currentPassword;

    @FindBy(xpath = "//*[@name='label2']")
    public  WebElement newPassword;

    @FindBy(xpath = "//*[@name='label3']")
    public  WebElement retypeNewPassword;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='passcode-success']")
    public WebElement successMessage;
}
