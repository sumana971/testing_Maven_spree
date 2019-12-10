package tests;

import Suite.SuiteManager;
import Util.ConfigFileReader;
import Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.lognCredentials;

import java.util.concurrent.TimeUnit;

public class Test1 extends SuiteManager {

    String LoginBtn="//a[contains(text(),'Login')]";
    String username="spree_user[email]";
    String pwds="spree_user[password]";
    String LoginBtn1="//input[@class='btn btn-lg btn-success btn-block']";
    String actmsg="//div[.='Logged in successfully']";
    //SuiteManager sm=new SuiteManager();

    ConfigFileReader config=new ConfigFileReader();




    @Test(dataProvider="lognCredentials", dataProviderClass = lognCredentials.class)
    public void login(String loginId, String password) throws InterruptedException {

        Thread.sleep(5000);
        DriverManager.driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
      // sm.getLoginDetails();
        WebElement a = DriverManager.driver.findElement(By.name(username));
        a.sendKeys(loginId);
        WebElement pwd = DriverManager.driver.findElement(By.id("spree_user_password"));
        pwd.sendKeys(password);
        DriverManager.driver.findElement(By.xpath(LoginBtn1)).click();
        WebElement msgactual = DriverManager.driver.findElement(By.xpath(actmsg));
        String text = msgactual.getText();
        System.out.println(text);
        Assert.assertEquals(text,"Logged in successfully");
    }





}

