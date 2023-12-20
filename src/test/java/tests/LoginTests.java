package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Login tests")
@Owner("Andrei Zola")
public class LoginTests extends TestBase {

    @Test
    @Story("Login test with recognized device")
    @Description("Logging as a user with recognized device and checking current URL")
    public void loginTestWithRecognizedDevice() {
        new MainPage(context).signInRecognized().loginAsUserWithRecognizedDevice();
        assertEquals("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/App", context.driver.getCurrentUrl());
        logs.append("I logged as a user with recognized device (successfully)");
    }

    @Test
    @Story("Login test with unrecognized device")
    @Description("Logging with unrecognized device and checking current URL")
    public void loginTestWithUnrecognizedDevice() {
        new MainPage(context).signInUnrecognized().loginAsUserWithUnrecognizedDevice();
        assertEquals("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/App", context.driver.getCurrentUrl());
        logs.append("I logged as a user with unrecognized device (successfully)");
    }
}

