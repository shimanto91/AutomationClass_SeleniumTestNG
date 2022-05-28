package WebElementTest;

import BasePackage.BaseClass;

public class Navigation_01 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://www.google.com");
        nav_to();
        Thread.sleep(2000);
        nav_back();
        Thread.sleep(2000);
        nav_forward();
        Thread.sleep(2000);
        reload();
    }
    public static void nav_to(){
        driverObj.navigate().to("https://demo.opencart.com");
    }
    public static void nav_back(){
        driverObj.navigate().back();
    }
    public static void nav_forward(){
        driverObj.navigate().forward();
    }
    public static void reload(){
        driverObj.navigate().refresh();
    }
}
