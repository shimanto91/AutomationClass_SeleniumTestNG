package WebElementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoLogin_02 {
    public static WebDriver driverObj;

    public static void main(String[] args){
        chrome_launch();
        open_website("https://demo.guru99.com/v4/");
        login_TC01();
    }

    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        driverObj.manage().window().maximize();
    }

    public static void open_website(String URL){
        driverObj.get(URL);
    }

    public static void login_TC01(){
        WebElement email = driverObj.findElement(By.name("uid"));
        WebElement password = driverObj.findElement(By.name("password"));
        WebElement loginBtn = driverObj.findElement(By.name("btnLogin"));
        //WebElement resetBtn = driverObj.findElement(By.name("btnReset"));

        email.sendKeys("testassign@test.com");
        password.sendKeys("1234567");
        loginBtn.click();
        //resetBtn.click();
    }
}
