package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import UseMethods.RndStr;

public class BaseClass extends RndStr {
    public static WebDriver driverObj;

    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        driverObj.manage().window().maximize(); //browser window maximize
    }

    public static void open_website(String URL){
        driverObj.get(URL);
    }
    public static void browser_close() {
        driverObj.close();
    }
    public static void browser_quit() { driverObj.quit(); }
}

