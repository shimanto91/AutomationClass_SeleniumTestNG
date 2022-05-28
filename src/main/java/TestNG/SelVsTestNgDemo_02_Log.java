package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelVsTestNgDemo_02_Log {
    public static WebDriver driverObj;

    @BeforeMethod
    public void browser_config(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        System.out.println("Browser_Launched");
    }

    @Test(priority = 2, description = "Email and password valid")
    public void TC_valid_01(){
        driverObj.get("https://demo.opencart.com/index.php?route=account/login");
        WebElement email = driverObj.findElement(By.id("input-email"));
        WebElement password = driverObj.findElement(By.id("input-password"));
        WebElement loginBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("testassign@test.com");
        password.sendKeys("1234567");
        loginBtn.click();
        System.out.println("TC_01 executed");
    }

    @Test(priority = 1, description = "Email and password invalid")
    public void TC_invalid_01() {
            driverObj.get("https://demo.opencart.com/");
            Reporter.log("Site opened");
            WebElement myAC = driverObj.findElement(By.linkText("My Account"));
            myAC.click();
            Reporter.log("My Account clicked");
            WebElement lgn = driverObj.findElement(By.linkText("Login"));
            lgn.click();
            Reporter.log("Login page btn clicked");
            WebElement email = driverObj.findElement(By.id("input-email"));
            WebElement password = driverObj.findElement(By.id("input-password"));
            WebElement loginBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

            email.sendKeys("testngmail1@test.com");
            Reporter.log("Email typing");
            password.sendKeys("1234567");
            Reporter.log("Password Typing");
            loginBtn.click();
            Reporter.log("Login Btn clicked");
            System.out.println("Invalid TC_001 executed");
    }

    @AfterMethod
    public void browser_close(){
        driverObj.close();
        System.out.println("Browser Closed");
    }
}
