package WebElementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeToRegister {
    public static WebDriver driverObj;

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com");
        Thread.sleep(3000);
        Register_TC02();
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

    public static void Register_TC02() throws InterruptedException {
        WebElement myAccount = driverObj.findElement(By.linkText("My Account"));
        myAccount.click();
        Thread.sleep(3000);
        WebElement register = driverObj.findElement(By.linkText("Register"));
        register.click();


        WebElement firstname = driverObj.findElement(By.name("firstname"));
        WebElement lastname = driverObj.findElement(By.name("lastname"));
        WebElement email = driverObj.findElement(By.name("email"));
        WebElement telephone = driverObj.findElement(By.name("telephone"));
        WebElement password = driverObj.findElement(By.name("password"));
        WebElement confirm = driverObj.findElement(By.name("confirm"));
        WebElement newsletter = driverObj.findElement(By.name("newsletter"));
        WebElement agree = driverObj.findElement(By.name("agree"));
        WebElement submitbtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        firstname.sendKeys("abcd");
        lastname.sendKeys("vwxyz");
        email.sendKeys("testassign@test.com");
        telephone.sendKeys("0123456789");
        password.sendKeys("1234567");
        confirm.sendKeys("1234567");
        newsletter.click();
        agree.click();

        Thread.sleep(3000); //Pauses 3 mlsec before next execution
        //Have to add exception or gives error

        submitbtn.click();
    }
    public static void browser_close() {
        driverObj.close();
    }
}




