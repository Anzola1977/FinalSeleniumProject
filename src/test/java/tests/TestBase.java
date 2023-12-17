package tests;

import context.TestContext;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class TestBase {
    TestContext context;
    StringBuilder logs;

    @BeforeEach
    public void beforeMethod() {
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js = (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("base_url"));
        logs = new StringBuilder();
    }

    @AfterEach
    public void afterMethod() {
        Allure.addAttachment("Console log: ", String.valueOf(logs));
        TakesScreenshot takesScreenshot = (TakesScreenshot) context.driver;
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Скриншот в момент окончания тестов", new ByteArrayInputStream(screenshot));
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}
