package WebElementTest;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown_01 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/dropdown");
        dropSel();
        Thread.sleep(2000);
        browser_close();
    }
    public static void dropSel() throws InterruptedException {
        WebElement dropdown = driverObj.findElement(By.id("dropdown"));
        Select slt = new Select(dropdown);
        slt.selectByIndex(1);
        Thread.sleep(2000);
        slt.selectByValue("2");
        Thread.sleep(2000);
        slt.selectByVisibleText("Option 1");
    }
}
