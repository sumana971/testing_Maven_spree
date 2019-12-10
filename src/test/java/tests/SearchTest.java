package tests;

import Suite.SuiteManager;
import Util.ConfigFileReader;
import Util.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest  extends SuiteManager {

ConfigFileReader config=new ConfigFileReader();
    String searchb="//input[@value='bag']";
    String searchbtn="//input[@class='btn btn-success']";

        @Test(priority=1)
        public void getSearchProdDetails()
        {
            String prd=config.getProperty("searchprod");
            DriverManager.driver.findElement(By.xpath("//input[@id='keywords']")).sendKeys(prd);
            DriverManager.driver.findElement(By.xpath(searchbtn)).click();


        }

    }



