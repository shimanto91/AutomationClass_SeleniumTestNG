package WebElementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeToLogin {
    public static WebDriver driverObj;

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com");
        Thread.sleep(2000);
        login_TC02();
    }

    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        driverObj.manage().window().maximize(); //browser window maximize
    }

    public static void open_website(String URL){
        driverObj.get(URL);
    }

    public static void login_TC02() throws InterruptedException {
        WebElement myAccount = driverObj.findElement(By.linkText("My Account"));
        myAccount.click();
        Thread.sleep(2000);
        WebElement login = driverObj.findElement(By.linkText("Login"));
        login.click();

        WebElement email = driverObj.findElement(By.id("input-email"));
        WebElement password = driverObj.findElement(By.id("input-password"));
        WebElement loginBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("testassign@test.com");
        password.sendKeys("1234567");
        Thread.sleep(2000);
        loginBtn.click();
    }
}
