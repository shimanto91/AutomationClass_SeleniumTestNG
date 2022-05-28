package BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//To work offline

public class Browser_03 {
    public static void main(String[] args) throws Exception {
        WebDriver driverObj = new FirefoxDriver();
        driverObj.get("file:///C:/Users/path.selenium.html");
    }
}

//For saved webpages, address has to be copied in the address bar.
//
