package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart extends SuiteManager {

    @FindBy(xpath="//a[.='Spree Bag']")
    WebElement spreebag;

    @FindBy(xpath = "//a[.='Ruby on Rails Baseball Jersey']")
    WebElement Rubyonrailsjersey;


    @FindBy(xpath = "//a[.='Ruby on Rails Bag']")
    WebElement rubyonrails;

    @FindBy(xpath = "//button[@id='checkout-link']")
    WebElement checkoutbtn;

   public ShoppingCart()
   {
       PageFactory.initElements(DriverManager.driver,this);
   }

    public CheckoutPage checkout()
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn));
        checkoutbtn.click();
        return new CheckoutPage();

    }
}
