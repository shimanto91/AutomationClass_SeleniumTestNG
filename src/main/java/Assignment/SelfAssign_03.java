package Assignment;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelfAssign_03 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("http://localhost:3000/files/battlefield/react/react-hotel-reservation-system");
        dropSel();
        Thread.sleep(2000);
        browser_close();
    }
    public static void dropSel() throws InterruptedException {
        WebElement selectHotel = driverObj.findElement(By.className("select__value-container css-g1d714-ValueContainer"));
        Select slt = new Select(selectHotel);
        slt.selectByVisibleText("Dela Hotel");
    }
}