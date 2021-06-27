package com.aerokube.selenoid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.aerokube.selenoid.DemoTest.takeScreenshot;

public class AndroidDemoTest {

    private static final By BUTTON_2 = By.id("com.android.calculator2:id/digit_2");
    private static final By BUTTON_PLUS = By.id("com.android.calculator2:id/op_add");
    private static final By BUTTON_7 = By.id("com.android.calculator2:id/digit_7");
    private static final By BUTTON_EQUALS = By.id("com.android.calculator2:id/eq");
    private static final By RESULT_FIELD = By.id("com.android.calculator2:id/formula");
    
    private RemoteWebDriver driver;

    @Before
    public void openDriver() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "android");
        capabilities.setCapability("browserVersion", "9.0");

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                capabilities
        );
    }

    @Test
    public void browserTest() throws Exception {
        try {
            driver.findElement(BUTTON_2).click();
            driver.findElement(BUTTON_PLUS).click();
            driver.findElement(BUTTON_7).click();
            driver.findElement(BUTTON_EQUALS).click();
            assert(driver.findElement(RESULT_FIELD).getText()).equals("9");
        } finally {
            takeScreenshot(driver);
        }
    }

    @After
    public void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
