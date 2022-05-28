package TestNG_DataDriveProvide;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class DP_Lgn_01 {
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

    @AfterClass
    public void tearDown() {
        driverObj.quit();
    }

    @Test(dataProvider = "Login invalid data")
    public void TC_inv_001(String DP_email, String DP_pass){
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

        email.sendKeys(DP_email);
        Reporter.log("Email typing");
        password.sendKeys(DP_pass);
        Reporter.log("Password Typing");
        loginBtn.click();
        Reporter.log("Login Btn clicked");
        System.out.println("Invalid TC_001 executed");
    }

    @DataProvider(name = "Login invalid data")
    public Object [][] lgnData(){
        Object lgnData[][] = new Object[3][2];

        //Set lgn data 1
        lgnData [0][0] = "emailDP1@test.com";
        lgnData [0][1] = "1298659";

        //Set lgn data 2
        lgnData [1][0] = "emailDP2@test.com";
        lgnData [1][1] = "1298659";

        //Set lgn data 3
        lgnData [2][0] = "emailDP3@test.com";
        lgnData [2][1] = "1298659";

        return lgnData;
    }
}


