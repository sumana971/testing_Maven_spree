package tests;

import Pages.*;
import Suite.SuiteManager;
import Util.ConfigFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductPageTest extends SuiteManager {

    ConfigFileReader config = new ConfigFileReader();
    public BasePage basePage;
    public LoginPage loginpage;
    public HomePage homepage;
    public ProductPage productpage;
    public ShoppingCart shoppingcart;

    @Test
    public void getDetails()
    {

            basePage=new BasePage();
            loginpage=new LoginPage();
            loginpage=basePage.clickLoginButton();
            String title=loginpage.getLoginPageTitle();
            System.out.println(title);
            // Assert.assertEquals(title,"homespree");
            homepage=new HomePage();
            homepage=loginpage.doLogin(config.getProperty("username"),config.getProperty("password"));
            productpage =new ProductPage();
            productpage=homepage.doClick();


        }


        @Test
    public void getShoppingCartPage() {

            shoppingcart = productpage.addToCart(config.getProperty("qty"));

        }
        @Test
    public void verifyPrice()
        {
            Assert.assertEquals(productpage.getPrice(),"$22.99");
            System.out.println("The price is " +productpage.getPrice());
        }
}
