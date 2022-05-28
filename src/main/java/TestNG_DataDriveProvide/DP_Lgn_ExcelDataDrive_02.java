package TestNG_DataDriveProvide;

import TestNG_DataDriveProvide.Utils.ExcellMethods;
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

public class DP_Lgn_ExcelDataDrive_02 {
    WebDriver driverObj;

    @BeforeClass
    @Parameters("Browser")
    public void init_setup(String browser_name) {
        if (browser_name.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driverObj = new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driverObj = new ChromeDriver();
            driverObj.manage().window().maximize();
        } else if (browser_name.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driverObj = new EdgeDriver();
        } else if (browser_name.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driverObj = new OperaDriver();
        } else {
            System.out.println("Please provide defined browser name (chrome, firefox, edge, opera).");
        }
    }

    @AfterClass
    public void tearDown() {
        driverObj.quit();
    }

    @Test
    public void TC_inv_001() {

        //Excel Implementation
        ExcellMethods reader = new ExcellMethods("./src/main/java/TestNG_DataDriveProvide/Utils/DemoLgnDataSheet_01.xlsx");
        String sheetName = "Lgn_Data_01";

        int rowCount = reader.getRowCount(sheetName);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String DD_email = reader.getCellData(sheetName, "Email", rowNum);
            String DD_password = reader.getCellData(sheetName, "Password", rowNum);

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

            email.sendKeys(DD_email);
            Reporter.log("Email typing");
            password.sendKeys(DD_password);
            Reporter.log("Password Typing");
            loginBtn.click();
            Reporter.log("Login Btn clicked");
            System.out.println("Invalid TC_001 executed");


            //Output Result Status
            String exp1 = "Account Login";
            String act1 = driverObj.getTitle();

            if(exp1.equals(act1)){
                reader.setCellData(sheetName,"Actual Result", rowNum, "Didn't Login");
            }else{
                reader.setCellData(sheetName, "Actual Result", rowNum, "Logged in: Test Failed");
            }
        }
    }
}
