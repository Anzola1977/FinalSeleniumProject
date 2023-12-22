package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageTransferMoneyComponent extends BasePage {

    @FindBy(xpath = "//*[@class='billpay-dropdown dropdown nav-item']")
    public WebElement transferNavigation;

    @FindBy(xpath = "//*[text()='Make a transfer']")
    public WebElement transferBetweenAccounts;

    @FindBy(css = "#payFrom")
    public WebElement payFromChoice;

    @FindBy(css = "#payTo")
    public WebElement payToChoice;

    @FindBy(css = "#payAmount")
    public WebElement amount;

    @FindBy(css = "#payHowOften")
    public WebElement frequency;

    @FindBy(xpath = "//*[@class='btn blue-btn-active mb-5 mt-4']")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@class='btn blue-btn-active m-left-1 mt-3']")
    public WebElement transferButton;

    @FindBy(xpath = "//*[@class='account-title'][text()='Adv SafeBalance Banking']")
    public WebElement accountFrom;

    @FindBy(xpath = "//*[@class='account-title'][text()='Customized Cash Rewards Visa Signature']")
    public WebElement accountTo;

    @FindBy(xpath = "//*[@class='account-title'][text()='One time, immediately ']")
    public WebElement frequencyOfTransfer;

    public AccountPageTransferMoneyComponent(TestContext context) {
        super(context);
    }
}
