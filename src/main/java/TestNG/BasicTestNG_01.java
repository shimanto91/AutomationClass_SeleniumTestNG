package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestNG_01 {
    @Test
    public void TC_001() {
        System.out.println("TC_001 executed");
    }
    @Test
    public void TC_002() {
        System.out.println("TC_002 executed");
        String exp_str01 = "Google";
        Assert.assertEquals("facebook", exp_str01);
    }
    @Test
    public void TC_003() {
        System.out.println("TC_003 executed");
    }
}
