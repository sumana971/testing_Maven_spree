package tests;

import Pages.*;
import Suite.SuiteManager;
import Util.ConfigFileReader;
import Util.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ShoppingCartPage extends SuiteManager  {



        ConfigFileReader config = new ConfigFileReader();
        public BasePage basePage;
        public LoginPage loginpage;
        public HomePage homepage;
        public ProductPage productpage;
        public ShoppingCart shoppingcart;
        public CheckoutPage checkpage;

        @Test
        public void doPrevalidate() {

            basePage = new BasePage();
            loginpage = new LoginPage();
            loginpage = basePage.clickLoginButton();
            //String title=loginpage.getLoginPageTitle();
            // System.out.println(title);
            // Assert.assertEquals(title,"homespree");
            homepage = new HomePage();
            homepage = loginpage.doLogin(config.getProperty("username"), config.getProperty("password"));
            productpage = new ProductPage();
            productpage = homepage.doClick();
            //checkpage=new CheckoutPage();
            shoppingcart=new ShoppingCart();
            shoppingcart = productpage.addToCart(config.getProperty("qty"));
        }
        @Test
    public void getCartItems()
        {
            shoppingcart.checkout();
        }


}
