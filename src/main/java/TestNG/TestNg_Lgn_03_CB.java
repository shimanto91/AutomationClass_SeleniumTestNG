package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg_Lgn_03_CB {
    WebDriver driverObj;

    @BeforeClass
    @Parameters("Browser")
    public void init_setup(String browser_name){
        if(browser_name.equalsIgnoreCase("firefox")){
             WebDriverManager.firefoxdriver().setup();
             driverObj = new FirefoxDriver();
        }
        else if(browser_name.equalsIgnoreCase("chrome")){
             WebDriverManager.chromedriver().setup();
             driverObj = new ChromeDriver();
             driverObj.manage().window().maximize();
        }
        else if(browser_name.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driverObj = new EdgeDriver();
        }
        else if(browser_name.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driverObj = new OperaDriver();
        }
        else{
            System.out.println("Please provide defined browser name (chrome, firefox, edge, opera).");
        }
    }

    @Test(description = "Invalid email and password" )
    public void TC_inv_001(){
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
    @AfterClass
    public void tearDown(){
        driverObj.quit();
    }
}


/*
Browser is defined during run time
All browsers will be added
Which browser to be used can be defined during running
 Web driver manager: by Bonnie Garcia : Checks automatically which driver, which version
 */