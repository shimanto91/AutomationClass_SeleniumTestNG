package TestNG;

import org.testng.annotations.Test;

public class TestNG_Lgn_02 {
    @Test(priority = 2, description = "Email and password valid")
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
    @Test(enabled = false, priority = 1, description = "Email and password invalid")
    public void TC_invalid_04() {
        System.out.println("TC_04 executed");
    }
}

//Default enabled True
//Ordering output console using priority
//Default priority 0
//Priority can be -. -2 executes before -1, -1 before 0, 1