package WebElementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetURL_01 {
    public static WebDriver driverObj;

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com");
        login_TC05();
        Thread.sleep(3000);
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

    public static void login_TC05() throws InterruptedException {
        WebElement myAccount = driverObj.findElement(By.linkText("My Account"));
        myAccount.click();
        Thread.sleep(2000);
        WebElement login = driverObj.findElement(By.linkText("Login"));
        login.click();

        WebElement email = driverObj.findElement(By.id("input-email"));
        WebElement password = driverObj.findElement(By.id("input-password"));
        WebElement loginBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("testa@test.com");
        password.sendKeys("1234567");
        Thread.sleep(2000);
        loginBtn.click();

        String url = driverObj.getCurrentUrl();

        String  expectedURL= "https://demo.opencart.com/index.php?route=account/account";

        if(expectedURL.equalsIgnoreCase(url)){
            System.out.println("Test Passed");
        }else{
            System.out.println("BUG!");
        }
    }

    public static void browser_close() {
        driverObj.close();
    }
}
