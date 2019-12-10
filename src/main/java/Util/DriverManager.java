package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;

    public DriverManager()
    {
        String chromedriverpath= System.getProperty("user.dir")+"/"+"src/main/resources/driver/chromedriver 3";
        System.setProperty("webdriver.chrome.driver", chromedriverpath);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }

}
