package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Account page tests")
@Owner("Andrei Zola")
public class AccountPageTests extends TestBase {

    @Test
    @Story("Functionality of sign out button")
    @Description("Checking sign out button functionality")
    public void checkingSignOutButton() {
        new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice().returnToHome();
        assertEquals("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/", context.driver.getCurrentUrl());
        logs.append("I checked sign out button successfully");
    }

    @Test
    @Story("Functionality of return button")
    @Description("Checking return button functionality")
    public void checkingReturnButton() {
        new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice().signOut();
        assertEquals("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/", context.driver.getCurrentUrl());
        logs.append("I checked return button successfully");
    }

    @Test
    @Story("Correct display of accounts")
    @Description("Checking amount of accounts on main page")
    public void checkingAccounts() {
        assertEquals(4,
                new MainPage(context).signInUnrecognized().loginAsUserWithUnrecognizedDevice().listOfCardsAndSavings.size());
        logs.append("I checked accounts successfully");
    }

    @Test
    @Story("Correct display of mobile banking simulator")
    @Description("Logging in mobile banking simulator")
    public void checkingMobileSimulator() {
        assertEquals("Accounts",
                new MainPage(context).signInUnrecognized().loginAsUserWithUnrecognizedDevice().goToMobileBanking());
        logs.append("I checked mobile banking simulator successfully");
    }

    @Test
    @Story("Checking transfer between accounts")
    @Description("Checking transfer between our accounts functionality")
    public void checkingTransfer() {
        assertEquals("Your transfer is confirmed.",
                new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice().checkTransferAccounts());
        logs.append("I checked transfer between accounts successfully");
    }

    @Test
    @Story("Checking security center functionality")
    @Description("Checking password updating functionality")
    public void checkingSecurityCenter() {
        assertEquals("Your passcode has been changed.",
                new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice().updatePassword());
        logs.append("I checked security center functionality (changing password) successfully");
    }

    @Test
    @Story("Checking special offers and deals functionality")
    @Description("Checking special offers and deals functionality")
    public void checkingAllOffers() {
        assertEquals("BankAmeriDeals®",
                new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice().seeAllOffers());
        logs.append("I checked special offers and deals functionality (view all your deals) successfully");
    }

    @Test
    @Story("Checking account link functionality")
    @Description("Checking account link functionality")
    public void checkingFunctionalityAccountLink() {
        assertEquals(5,
                new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice().checkingAccountLinkFunctionality());
        logs.append("I checked account link functionality (Bank of America Advantage Savings) successfully");
    }

}

