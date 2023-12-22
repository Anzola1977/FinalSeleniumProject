package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageSpecialOffersComponent extends BasePage{
    public AccountPageSpecialOffersComponent(TestContext context) {
        super(context);
    }

    @FindBy(css = "#dealsTab")
    public WebElement specialOffersMenu;

    @FindBy(css = "#activity_process-bill-pay_deals")
    public WebElement viewAllDeals;

    @FindBy(xpath = "//*[@class='cashback-title']//*[text()='BankAmeriDeals']")
    public WebElement textConfirmation;
}
