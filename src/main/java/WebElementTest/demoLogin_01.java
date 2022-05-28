package WebElementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class demoLogin_01 {
    public static WebDriver driverObj;

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com/index.php?route=account/login");
        login_TC01();
        sleep(2000);
        browser_close();
    }

    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        driverObj.manage().window().maximize(); //browser window maximize
    }

    public static void open_website(String URL){
        driverObj.get(URL);
    }

    public static void login_TC01() throws InterruptedException {
        WebElement email = driverObj.findElement(By.id("input-email"));
        WebElement password = driverObj.findElement(By.id("input-password"));
        WebElement loginBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("testassign@test.com");
        password.sendKeys("1234567");
        Thread.sleep(2000);
        loginBtn.click();
    }
    public static void browser_close(){
        driverObj.close();
    }
}


/*There are some browser tools that can be used in order to identify web elements in the DOM easier.
  1. Firebug for Firefox ;  2. Google Developer Tools for Chrome ;  3. Web Inspector for Safari ;*/
//Locators in Selenium: 1. Id; 2. Name; 3. ClassName; 4. TagName; 5. LinkText; 6. Partial Link Text; 7. CSS; 8. Xpath;
//Order should be followed in automation: 1. Id; 2. Name; 3. ClassName; 4. CSS; 5. Xpath;
