package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNG_03_Annotations {

    //@BeforeClass
    //@BeforeTest
    @BeforeMethod
    public void browser_config(){
        System.out.println("Browser Launched");
    }
    //public void open_url(){}

    @Test(priority = 1, description = "Email and password valid")
    public void TC_valid_01() {
        System.out.println("TC_01 executed");
    }
    @Test(priority = 4, description = "Email invalid, password valid")
    public void TC_invalid_02() {
        System.out.println("TC_02 executed");
    }
    @Test(priority = 3, description = "Email valid, password invalid")
    public void TC_invalid_03() {
        System.out.println("TC_03 executed");
    }
    @Test(priority = 2, description = "Email and password invalid")
    public void TC_invalid_04() {
        System.out.println("TC_04 executed");
    }

    //@AfterClass
    //@AfterTest

    @AfterMethod
    public void browser_close(){
        System.out.println("Browser Closed");
    }
}
