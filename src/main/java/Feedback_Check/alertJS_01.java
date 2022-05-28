package Feedback_Check;

import BasePackage.BaseClass;
import org.openqa.selenium.By;

public class alertJS_01 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/javascript_alerts");
        alerts();
    }
    public static void alerts() throws InterruptedException {
        driverObj.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        driverObj.switchTo().alert().accept();
        Thread.sleep(2000);

        driverObj.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        driverObj.switchTo().alert().dismiss();
        Thread.sleep(2000);

        driverObj.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        driverObj.switchTo().alert().sendKeys("Welcome");
        Thread.sleep(2000);

        driverObj.switchTo().alert().accept();
    }
}
