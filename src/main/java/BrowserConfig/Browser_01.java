package BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser_01 {

    public static WebDriver driverObj;  //'driverObj' is reference variable of WebDriver interface

    public static void main(String[] args) {
        chrome_launch();
        open_website("https://google.com");
        browserSize();
        //browser_close();
        //browser_quit();

        firefox_launch();
        open_website("https://google.com");
        browserSize();
        //browser_close();
        //browser_quit();

        //opera_launch();
        //open_website("https://opera.com");

        edge_launch();
        open_website("https://microsoft.com");
    }

    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driverObj=new ChromeDriver();
        //driverObj.manage().window().maximize(); //browser window maximize
    }
    public static void firefox_launch(){
        System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
        driverObj=new FirefoxDriver();
        driverObj.manage().window().maximize();
    }
    public static void opera_launch(){
        System.setProperty("webdriver.opera.driver", "./Drivers/operadriver.exe");
        driverObj=new OperaDriver();
        //driverObj.manage().window().maximize(); //browser window maximize
    }
    public static void edge_launch(){
        System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
        driverObj=new EdgeDriver();
        //driverObj.manage().window().maximize(); //browser window maximize
    }
    public static void open_website(String URL){
        driverObj.get(URL);
    }
    public static void browser_close(){ //closes only active tab
        driverObj.close();
    }
    public static void browser_quit(){  //Closes all tabs
        driverObj.quit();
    }

    public static void browserSize(){
        int maxWidth = driverObj.manage().window().getSize().getWidth();
        int maxHeight = driverObj.manage().window().getSize().getHeight();

        System.out.println("Maxwidth: " + maxWidth + " ; " + "Maxheight: " + maxHeight);
    }
}
