package TestNG_Report;

import TestNG_DataDriveProvide.Utils.ExcellMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Report_02_Design {
    WebDriver driverObj;

    ExtentHtmlReporter htmlReporter;
    ExtentReports reports;
    ExtentTest logger;

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

        //Implement Report

          htmlReporter = new ExtentHtmlReporter("./Reports/Report_02_Design.html");
          reports = new ExtentReports();
          reports.attachReporter(htmlReporter);

          //Info. added to report

          reports.setSystemInfo("Environment","Test");
          reports.setSystemInfo("Test by","Kumar Shimanto");
          reports.setSystemInfo("OS","Windows 10");
          reports.setSystemInfo("Browser","Opera");

          logger = reports.createTest("loginTestReportDesign");

        //Excel Implementation
        ExcellMethods reader = new ExcellMethods("./src/main/java/TestNG_DataDriveProvide/Utils/DemoLgnDataSheet_01.xlsx");
        String sheetName = "Lgn_Data_01";

        int rowCount = reader.getRowCount(sheetName);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String DD_email = reader.getCellData(sheetName, "Email", rowNum);
            String DD_password = reader.getCellData(sheetName, "Password", rowNum);

            driverObj.get("https://demo.guru99.com/selenium/newtours/");
            //Reporter.log("Site opened");

            logger.log(Status.INFO, "Site opened");
            WebElement email = driverObj.findElement(By.name("userName"));
            WebElement password = driverObj.findElement(By.name("password"));
            WebElement loginBtn = driverObj.findElement(By.name("submit"));

            email.sendKeys(DD_email);
            //Reporter.log("Email typing");
            logger.log(Status.INFO, "Email typing");
            password.sendKeys(DD_password);
            //Reporter.log("Password Typing");
            logger.log(Status.INFO, "Password typing");
            loginBtn.click();
            //Reporter.log("Login Btn clicked");
            logger.log(Status.INFO, "Sign in clicked");
            System.out.println("Invalid TC_001 executed");

            logger.log(Status.PASS, "Test Passed");
        }
        reports.flush();
    }
}
