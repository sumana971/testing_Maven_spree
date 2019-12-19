package tests;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Suite.SuiteManager;
import Util.ConfigFileReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeTest extends SuiteManager {
    ConfigFileReader config = new ConfigFileReader();
    public BasePage basePage;
    public LoginPage loginpage;
    public HomePage homepage;
    public ProductPage productpage;
    ArrayList<String> test = new ArrayList<String>();

    @Test
    public void getTitle() {
        basePage = new BasePage();
        loginpage = new LoginPage();
        loginpage = basePage.clickLoginButton();
        String title = loginpage.getLoginPageTitle();
        System.out.println(title);
        // Assert.assertEquals(title,"homespree");
        homepage = new HomePage();
        homepage = loginpage.doLogin(config.getProperty("username"), config.getProperty("password"));

    }

    @Test(priority = 1)
    public void getLoginDetails() {
        String text = homepage.verifyMsgIsDisplayed();
        System.out.println(text);
        Assert.assertEquals(text, "Logged in successfully");

    }

    @Test
    public void clickSelectedItems() {
        productpage=new ProductPage();
        homepage=new HomePage();
        homepage.getProperties(config.getProperty("searchprod"));
        List<String> list1 = homepage.doverifyListOfBags();
        for(int i=0;i<list1.size();i++)
        {
            String text=list1.get(i);
            System.out.println(text);
             Assert.assertTrue(text.contains("Bag"));

        }
        productpage=homepage.doClick();
    }



}




