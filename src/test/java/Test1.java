import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {

    @Test
    public void login()
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
        String title=driver.getTitle();
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
