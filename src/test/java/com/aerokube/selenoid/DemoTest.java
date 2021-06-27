package com.aerokube.selenoid;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class DemoTest {

    static void takeScreenshot(RemoteWebDriver driver) throws Exception {
        byte[] screen = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.BYTES);
        FileUtils.writeByteArrayToFile(new File(driver.getSessionId() + ".png"), screen);
    }

}
