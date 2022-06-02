package BrowserConfig;

import BasePackage.BaseClass;
import org.openqa.selenium.By;

import java.util.Set;

public class Browser_04_getGUI_ID02 extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        wndw_ID();
        browser_quit();
    }
    public static void wndw_ID(){
        String parentGUID = driverObj.getWindowHandle();
        System.out.println(parentGUID);

        driverObj.findElement(By.linkText("Click Here")).click();
        Set<String> allGUIDs = driverObj.getWindowHandles();
        System.out.println(allGUIDs);
    }
}