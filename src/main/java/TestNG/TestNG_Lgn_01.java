package TestNG;

import org.testng.annotations.Test;

public class TestNG_Lgn_01 {
    @Test(description = "Email and password valid")
    public void TC_Valid_01() {
        System.out.println("TC_001 executed");
    }
    @Test(description = "Email valid and password invalid")
    public void TC_invalid_02() {
        System.out.println("TC_002 executed");
    }
    @Test(description = "Email invalid and password invalid")
    public void TC_Invalid_03() {
        System.out.println("TC_003 executed");
    }
    @Test(description = "Email invalid and password invalid")
    public void TC_invalid_04() {
        System.out.println("TC_004 executed");
    }
}

//Output: uppercase letter & alphabetical order based priority