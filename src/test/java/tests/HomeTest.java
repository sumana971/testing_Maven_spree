package tests;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Suite.SuiteManager;
import Util.ConfigFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends SuiteManager {
    ConfigFileReader config = new ConfigFileReader();
    public BasePage basePage;
    public LoginPage loginpage;
    public HomePage homepage;
    public ProductPage productpage;
    @Test
    public void getTitle()
    {
        basePage=new BasePage();
        loginpage=new LoginPage();
        loginpage=basePage.clickLoginButton();
        String title=loginpage.getLoginPageTitle();
        System.out.println(title);
        // Assert.assertEquals(title,"homespree");
        homepage=new HomePage();
        homepage=loginpage.doLogin(config.getProperty("username"),config.getProperty("password"));

    }

    @Test(priority = 1)
    public void getLoginDetails() {
        String text = homepage.verifyMsgIsDisplayed();
        Assert.assertEquals(text, "Logged in successfully", "SuccessfulLogin");

    }


    @Test(priority=3)
    public void clickSelectedItems()
    {
       // String finder=config.getProperty("searchprod");
        productpage=new ProductPage();
        homepage.getProperties(config.getProperty("searchprod"));
        //productpage=homepage.doverifyListOfBags();
        productpage=homepage.doClick();
    }


}
