package TestNG_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Report_01 {
    public static WebDriver driverObj;

    @BeforeMethod
    public void browser_config(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        Reporter.log("Browser opened");   //Writing test steps, can execute without it
        System.out.println("Browser_Launched");
    }

    @Test(description = "Email and password valid")
    public void TC_valid_01(){
        driverObj.get("https://demo.opencart.com/index.php?route=account/login");
        Reporter.log("Site opened");
        WebElement email = driverObj.findElement(By.id("input-email"));
        WebElement password = driverObj.findElement(By.id("input-password"));
        WebElement loginBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        Reporter.log("Login page opened");

        email.sendKeys("testassign@test.com");
        Reporter.log("Email typing");
        password.sendKeys("1234567");
        loginBtn.click();
        Reporter.log("Login button clicked");
        System.out.println("TC_01 executed");
    }

    @AfterMethod
    public void browser_close(){
        driverObj.close();
        System.out.println("Browser Closed");
    }
}
