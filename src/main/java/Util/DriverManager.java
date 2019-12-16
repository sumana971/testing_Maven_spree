package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

public class DriverManager {

    public static WebDriver driver;

    //public static final String USERNAME = "sumanaramesh1";
    //public static final String AUTOMATE_KEY = "jqPB2v7mT58piqQrKpur";
   // public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public DriverManager() throws MalformedURLException {
        String chromedriverpath= System.getProperty("user.dir")+"/"+"src/main/resources/driver/chromedriver 3";
        System.setProperty("webdriver.chrome.driver", chromedriverpath);
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("browser", "Chrome");
        //caps.setCapability("browser_version", "70.0");
        //caps.setCapability("os", "Windows");
        //caps.setCapability("os_version", "10");
       // caps.setCapability("resolution", "1024x768");
        //caps.setCapability("name", "Bstack-[Java] Sample Test");
        //driver = new RemoteWebDriver(new URL(URL), caps);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://www.google.com/ncr");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }

}
