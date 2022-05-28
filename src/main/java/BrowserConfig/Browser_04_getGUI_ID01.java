package BrowserConfig;

import BasePackage.BaseClass;

public class Browser_04_getGUI_ID01 extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        //Thread.sleep(2000);
        //browser_close();
        wndw_ID();
    }
    public static void wndw_ID(){
        String parentGUID = driverObj.getWindowHandle();
        System.out.println(parentGUID);
    }
}


