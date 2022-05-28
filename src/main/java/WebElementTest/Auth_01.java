package WebElementTest;

//the-internet.herokuapp.com
//Check basic Auth
//Username&Password required before the site is loaded
//

import BasePackage.BaseClass;

public class Auth_01 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        driverObj.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        browser_close();
        chrome_launch();
        driverObj.get("https://admin2:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        browser_close();
    }
}
