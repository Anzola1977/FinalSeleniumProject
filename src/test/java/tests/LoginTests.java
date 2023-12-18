package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.LoginPageRecognized;
import pages.LoginPageUnrecognized;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Login tests")
@Owner("Andrei Zola")
public class LoginTests extends TestBase {

    @Test
    @Story("Login test with recognized device")
    @Description("Logging as a user with recognized device and checking current URL")
    public void successLoginTestRecognizedDevice() {
        new LoginPageRecognized(context).loginAsUserWithRecognizedDevice();
        assertEquals("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/App", context.driver.getCurrentUrl());
        logs.append("I logged as a user with recognized device (successfully)");
    }

    @Test
    @Story("Login test with unrecognized device")
    @Description("Logging with unrecognized device and checking current URL")
    public void successLoginTestUnrecognizedDevice() {
        new LoginPageUnrecognized(context).loginAsUserWithUnrecognizedDevice();
        assertEquals("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/App", context.driver.getCurrentUrl());
        logs.append("I logged as a user with unrecognized device (successfully)");
    }
}

