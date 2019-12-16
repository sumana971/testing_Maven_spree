package tests;

import Suite.SuiteManager;
import Util.ConfigFileReader;
import Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

//Loginpage-> Login> returnHome page-> Do 2 actions->wait for success
// Do a search->with search string , which comes from Property File->Returns Search Result page
//Product list-> Save the product names to ArrayList
//validate the names of the product with search string

public class SearchTest  extends SuiteManager {

ConfigFileReader config=new ConfigFileReader();
    String searchb="//input[@value='bag']";
    String searchbtn="//input[@class='btn btn-success']";
    String prod_bags="//a[@class='d-block text-center']";


        @Test(priority=2)
        public void getProductList()
        {
            List<WebElement>listBags=DriverManager.driver.findElements(By.xpath(prod_bags));
            for(int i=0;i<listBags.size();i++)
            {
                String bag_prod=listBags.get(i).getText();
                System.out.println(bag_prod);
            }
        }

    }



