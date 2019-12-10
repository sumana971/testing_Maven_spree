package tests;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 extends SuiteManager {

    String LoginBtn="//a[contains(text(),'Login')";
    String username="spree_user[email]";
    String pwds="spree_user[password]";
    String LoginBtn1="//input[@class='btn btn-lg btn-success btn-block']";
    String actmsg="//div[.='Logged in successfully']";



    @Test
    public void login() {
        DriverManager.driver.findElement(By.xpath(LoginBtn)).click();
        WebElement a = DriverManager.driver.findElement(By.name(username));
        a.sendKeys("Sumu971@gmail.com");
        WebElement pwd = DriverManager.driver.findElement(By.id("spree_user_password"));
        pwd.sendKeys("Orange@971");
        DriverManager.driver.findElement(By.xpath(LoginBtn1)).click();
        WebElement msgactual = DriverManager.driver.findElement(By.xpath(actmsg));
        String text = msgactual.getText();
        System.out.println(text);
        Assert.assertEquals(text,"Logged in successfully");
    }

}
