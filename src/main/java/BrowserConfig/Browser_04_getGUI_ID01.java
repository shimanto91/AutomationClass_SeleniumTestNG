package BrowserConfig;

import BasePackage.BaseClass;

import static java.lang.Thread.*;

public class Browser_04_getGUI_ID01 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        //sleep(5000);
        wndw_ID();
        browser_close();
    }
    public static void wndw_ID(){
        String parentGUID = driverObj.getWindowHandle();
        System.out.println(parentGUID);
    }
}


