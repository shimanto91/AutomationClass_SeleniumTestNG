package Selenium_ScrnShot;

import BasePackage.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScrnShot_01 extends BaseClass {
    public static void main(String args) throws IOException {
        chrome_launch();
        open_website("https://google.com");
        scrn01();
        browser_close();
    }
    public static void scrn01() throws IOException {
        //Capture
        File srcFile = ((TakesScreenshot)driverObj).getScreenshotAs(OutputType.FILE);
        //Save
        FileUtils.copyFile(srcFile,new File("./Screenshot/Google.png"),true);
    }
}
