package WebElementTest;

import BasePackage.BaseClass;
import org.openqa.selenium.By;

import java.util.Set;

public class Navigation_02_SwitchTab_01 extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        switchWindow();
        //browser_close(); //CLoses only current tab
        browser_quit();
    }
    public static void switchWindow(){
        String parentGUID = driverObj.getWindowHandle();
        //System.out.println(parentGUID);

        driverObj.findElement(By.linkText("Click Here")).click();
        Set<String> allGuids = driverObj.getWindowHandles();

        //Switch to child
        for(String ChildGuid:allGuids){
            if(!ChildGuid.equals(parentGUID));
            driverObj.switchTo().window(ChildGuid);
            driverObj.get("https://google.com");
        }

        //Get to parent
        for(String ChildGuid:allGuids){
            if(!ChildGuid.equals(parentGUID));
            driverObj.switchTo().window(parentGUID);
            driverObj.get("https://bbc.com");
        }
    }
}
