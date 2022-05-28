package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestNG_02 {
    @Test(dependsOnMethods = {"TC_002"})
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
    @Test(dependsOnMethods = {"TC_002", "TC_003"})
    public void TC_004() {
        System.out.println("TC_004 executed");
    }
    @Test
    public void TC_005() {
        System.out.println("TC_005 executed");
    }
    @Test(dependsOnMethods = {"TC_003", "TC_005"})
    public void TC_006() {
        System.out.println("TC_006 executed");
    }
}