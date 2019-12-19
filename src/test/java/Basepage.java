import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Basepage {
    public String username="sumu971@gmail.com";
    String passd="Orange@971";



    // Methods to obtain back the values set
    // by setter methods

    // Method to validate a user



    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver 3");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();


        WebElement a = driver.findElement(By.name("spree_user[email]"));
        a.sendKeys("Sumu971@gmail.com");
        WebElement pwd = driver.findElement(By.id("spree_user_password"));
        pwd.sendKeys("Orange@971");
        driver.findElement(By.xpath("//input[@class='btn btn-lg btn-success btn-block']")).click();
        WebElement msgactual = driver.findElement(By.xpath("//div[.='Logged in successfully']"));
        String text = msgactual.getText();
        Assert.assertEquals(text,"Logged in successfully","user is logged in");
        String title=driver.getTitle();
        Assert.assertEquals(title,"Spree Demo Site");
        System.out.println(title);



        //First Test case to verify whether the user is logged in
        if (text.equals("Logged in successfully")) {
            System.out.println("User is successfully logged in");
        } else {
            System.out.println("User is not logged in");
        }

        //Second test case to validate the page title

        if(title.equals("Spree Demo Site"))
        {
            System.out.println("The title is correct");
        }
        else
        {
            System.out.println("The title is incorrect");
        }



    }
}
