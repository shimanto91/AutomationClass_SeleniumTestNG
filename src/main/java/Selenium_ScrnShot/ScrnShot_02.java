package Selenium_ScrnShot;

import BasePackage.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ScrnShot_02 extends BaseClass {
    public static void main(String args) throws IOException {
        chrome_launch();
        open_website("https://google.com");
        scrn02_elmnt();
        browser_close();
    }
    public static void scrn02_elmnt() throws IOException {
        WebElement searchBox = driverObj.findElement(By.name("q"));
        File srcFile = ((TakesScreenshot)searchBox).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./Screenshot/GoogleSearch.png"),true);
    }
}

