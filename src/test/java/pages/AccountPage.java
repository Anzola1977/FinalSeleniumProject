package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class AccountPage extends BasePage {

    AccountPageTransferMoneyComponent accountPageTransferComponent;
    AccountPageSecurityCenterComponent accountPageSecurityCenterComponent;
    AccountPageSpecialOffersComponent accountPageSpecialOffersComponent;
    AccountPageMobileBankingComponent accountPageMobileBankingComponent;

    public AccountPage(TestContext context) {
        super(context);
        accountPageTransferComponent = new AccountPageTransferMoneyComponent(context);
        accountPageSecurityCenterComponent = new AccountPageSecurityCenterComponent(context);
        accountPageSpecialOffersComponent = new AccountPageSpecialOffersComponent(context);
        accountPageMobileBankingComponent = new AccountPageMobileBankingComponent(context);
    }

    @FindBy(xpath = "//div[@class='pt-0 d-flex m-0 card-title']")
    public List<WebElement> listOfCardsAndSavings;

    @FindBy(xpath = "//*[@class='sim-ov']")
    public WebElement returnButton;

    @FindBy(xpath = "//*[@class='d-inline-block']//*[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[@class='close-btn1 close-btn2']")
    public WebElement updateContactInformation;

    @FindBy(xpath = "//*[@class='succes-text m-top-7 mb-3']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@class='col-sm-9 pb-0 m-0 card-text']//*[text()='Bank of America Advantage Savings']")
    public WebElement accountLink;

    @FindBy(xpath = "//*[@class='toggleButton']")
    public List<WebElement> listOfToggleButtons;

    @FindBy(xpath = "//*[@class='btn'][text()='Edit Description']")
    public List<WebElement> listOfDescriptionButtons;

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

    public void goToMobileBanking() {
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        context.wait.until(ExpectedConditions.visibilityOf(accountPageMobileBankingComponent.mobileBankingSimulatorButton));
        accountPageMobileBankingComponent.mobileBankingSimulatorButton.click();
        context.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : context.driver.getWindowHandles()) {
            if (!Objects.equals(windowHandle, accountPageMobileBankingComponent.defaultWindow)) {
                context.driver.switchTo().window(windowHandle);
            }
        }
        context.driver.switchTo().frame(accountPageMobileBankingComponent.frameElement);
        accountPageMobileBankingComponent.userIDField.click();
        accountPageMobileBankingComponent.userIDField.sendKeys("123456");
        accountPageMobileBankingComponent.passwordField.click();
        accountPageMobileBankingComponent.passwordField.sendKeys("Andrew");
        accountPageMobileBankingComponent.logInButton.click();
    }

    public String checkTransferAccounts() {
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        Actions actions = new Actions(context.driver);
        actions.moveToElement(accountPageTransferComponent.transferNavigation).perform();
        context.wait.until(ExpectedConditions.elementToBeClickable(accountPageTransferComponent.transferBetweenAccounts));
        accountPageTransferComponent.transferBetweenAccounts.click();
        accountPageTransferComponent.payFromChoice.click();
        accountPageTransferComponent.accountFrom.click();
        accountPageTransferComponent.payToChoice.click();
        accountPageTransferComponent.accountTo.click();
        accountPageTransferComponent.amount.sendKeys("1000");
        accountPageTransferComponent.frequency.click();
        accountPageTransferComponent.frequencyOfTransfer.click();
        accountPageTransferComponent.nextButton.click();
        accountPageTransferComponent.transferButton.click();
        return successMessage.getText();
    }

    public String updatePassword(){
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        accountPageSecurityCenterComponent.securityCenterMenu.click();
        accountPageSecurityCenterComponent.updatePasswordButton.click();
        accountPageSecurityCenterComponent.currentPassword.sendKeys("123456");
        accountPageSecurityCenterComponent.newPassword.sendKeys("qwerty");
        accountPageSecurityCenterComponent.retypeNewPassword.sendKeys("qwerty");
        accountPageSecurityCenterComponent.saveButton.click();
        context.wait.until(ExpectedConditions.visibilityOf(accountPageSecurityCenterComponent.successMessage));
        return accountPageSecurityCenterComponent.successMessage.getText();
    }

    public String seeAllOffers(){
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        accountPageSpecialOffersComponent.specialOffersMenu.click();
        accountPageSpecialOffersComponent.viewAllDeals.click();
        return accountPageSpecialOffersComponent.textConfirmation.getText();
    }

    public int checkingAccountLinkFunctionality(){
        context.wait.until(ExpectedConditions.elementToBeClickable(updateContactInformation));
        updateContactInformation.click();
        accountLink.click();
        for (int i = 0; i < listOfToggleButtons.size(); i++) {
            listOfToggleButtons.get(i).click();
        }
        return listOfDescriptionButtons.size();
    }
}
