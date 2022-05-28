package BrowserConfig;

/* •WebDriver - Webdriver is the interface which is inherited from SearchContext
   • new - new is the keyword in java which creates an object (address space) in the heap area of CPU
   • FirefoxDriver() - FirefoxDriver() is a constructor of FirefoxDriver class which implements all the
                       methods present in the webdriver interface and this opens the firefox Browser.
   • driver - driver is a reference variable, which refers to the address space created on the heap.
   • ; - line ending statement
 */

//Following process is called run-time polymorphism and upcasting in java

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_02 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://firefox.com");
        //driver.manage().window().maximize();
        //Dimension size = driver.manage().window().getSize();
        //System.out.println("The size of the window: " + size);
        driver.manage().window().setSize(new Dimension(200, 200));
    }
}


//Set IE, Opera, Microsoft Edge, HTML Unit Driver in BrowserConfig
//get(""): A non-static method present in browser class, accepts arguments as string and string should be web address.
//get() method does not give control to the next line till the page loads completely.
//Whenever web address is passed to the get method, it first checks for the protocol in the address
/*Protocol: Mentions what kind of site is that.
   Examples: http ;    https ;    ftp ;    file ; */
//maximize() method present in the window class maximizes browser window
//getSize() method present in the Dimension class returns the dimension class type value.
//setSize() method sets the size of the window.
//driver.getTitle() : Gets page title
//driver.getCurrentUrl() : Returns URL as a String
//driver.getPageSource() : Returns page source of the  as a  string
//