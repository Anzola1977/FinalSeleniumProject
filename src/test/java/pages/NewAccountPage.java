package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class NewAccountPage extends BasePage {

    String defaultWindow = context.driver.getWindowHandle();

    @FindBy(css = "#username_field")
    public WebElement userIDField;

    @FindBy(css = "#passcode_field")
    public WebElement passwordField;

    @FindBy(css = "#sign_in_button")
    public WebElement logInButton;

    @FindBy(xpath = "//*[@class='left_control current_page accounts_btn_on_accts_page']")
    public WebElement accounts;

    @FindBy(xpath = "//div[@class='pt-0 d-flex m-0 card-title']")
    public List<WebElement> listOfCardsAndSavings;

    @FindBy(xpath = "//*[@class='sim-ov']")
    public WebElement returnButton;

    @FindBy(xpath = "//*[@class='d-inline-block']//*[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[@class='text-header col']/button")
    public WebElement mobileBankingSimulatorButton;

    @FindBy(xpath = "//*[@class='close-btn1 close-btn2']")
    public WebElement updateContactInformation;

    @FindBy(css = "#device_iframe")
    public WebElement frameElement;

    @FindBy(xpath = "//*[@class='succes-text m-top-7 mb-3']")
    public WebElement successMessage;

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

    public NewAccountPage(TestContext context) {
        super(context);
    }

    public MainPage returnToHome() {
        context.wait.until(ExpectedConditions.visibilityOf(updateContactInformation));
        updateContactInformation.click();
        context.wait.until(ExpectedConditions.visibilityOf(returnButton));
        returnButton.click();
        return new MainPage(context);
    }

    public MainPage signOut() {
        context.wait.until(ExpectedConditions.visibilityOf(updateContactInformation));
        updateContactInformation.click();
        signOutButton.click();
        return new MainPage(context);
    }

    public String goToMobileBanking() {
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        context.wait.until(ExpectedConditions.visibilityOf(mobileBankingSimulatorButton));
        mobileBankingSimulatorButton.click();
        context.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : context.driver.getWindowHandles()) {
            if (!Objects.equals(windowHandle, defaultWindow)) {
                context.driver.switchTo().window(windowHandle);
            }
        }
        context.driver.switchTo().frame(frameElement);
        userIDField.click();
        userIDField.sendKeys("123456");
        passwordField.click();
        passwordField.sendKeys("Andrew");
        logInButton.click();
        return accounts.getText();
    }

    public String checkTransferAccounts() {
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        Actions actions = new Actions(context.driver);
        actions.moveToElement(transferNavigation).perform();
        context.wait.until(ExpectedConditions.elementToBeClickable(transferBetweenAccounts));
        transferBetweenAccounts.click();
        payFromChoice.click();
        accountFrom.click();
        payToChoice.click();
        accountTo.click();
        amount.sendKeys("1000");
        frequency.click();
        frequencyOfTransfer.click();
        nextButton.click();
        transferButton.click();
        return successMessage.getText();
    }
}
