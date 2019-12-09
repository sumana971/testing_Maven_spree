import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpreePage {

    public static void main(String[] args) {
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
        String msg = "Logged in successfully";


        WebElement bags = driver.findElement(By.xpath("//div[@class='list-group']/a[.='Bags']"));
        bags.click();
        // List<WebElement> list=driver.findElements(By.xpath("//a[@class='d-block text-center']"));
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='card-body text-center product-body']"));

        for (int i = 0; i < list1.size(); i++) {
            String Products = list1.get(i).getText();
            System.out.println("The products are " + Products);

        }
             WebElement ele1 = driver.findElement(By.xpath("//span[.='Ruby on Rails Tote']"));
                ele1.click();
                WebElement qty = driver.findElement(By.xpath("//input[@type='number']"));
                qty.sendKeys("2");
                WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
                addtocart.click();


        }







        }












