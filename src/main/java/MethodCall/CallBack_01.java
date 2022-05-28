package MethodCall;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CallBack_01 extends BaseClass {
    //public static WebDriver driverObj;

    public static void main(String... args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com");
        Register_TC02();
        Thread.sleep(1000);
        browser_close();
    }

    public static void Register_TC02() throws InterruptedException {
        WebElement myAccount = driverObj.findElement(By.linkText("My Account"));
        myAccount.click();
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
        WebElement submitBtn = driverObj.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        firstname.sendKeys("abcd");
        lastname.sendKeys("vwxyz");
        email.sendKeys(generateRndStr() + "@gmail.com");
        Thread.sleep(2000);
        telephone.sendKeys("0123456789");
        password.sendKeys("1234567");
        confirm.sendKeys("1234567");
        newsletter.click();
        agree.click();
        submitBtn.click();

        String expectedMessage1 = "Your Account Has Been Created!";
        WebElement errorMessage1 = driverObj.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        String actualMessage1 = errorMessage1.getText();

        if(expectedMessage1.equalsIgnoreCase(actualMessage1)){
            System.out.println("Test Passed: Created");
        }else{
            System.out.println("BUG!");
        }
    }
}