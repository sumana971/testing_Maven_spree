package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingCart extends SuiteManager {

    @FindBy(xpath = "//a[.='Spree Bag']")
    WebElement spreebag;

    @FindBy(xpath = "//td[@class='cart-item-description']")
    List<WebElement> listcart;

    @FindBy(xpath = "//a[.='Ruby on Rails Baseball Jersey']")
    WebElement Rubyonrailsjersey;


    @FindBy(xpath = "//a[.='Ruby on Rails Bag']")
    WebElement rubyonrails;

    @FindBy(xpath = "//button[@id='checkout-link']")
    WebElement checkoutbtn;

    public ShoppingCart() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    public CheckoutPage checkout() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn));
        checkoutbtn.click();
        return new CheckoutPage();

    }

    public void verifyduplicateitems() {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (WebElement cart : listcart) {
            String st = cart.getText();
            Integer count = hm.get(st);
            if (count == null) {
                hm.put(st, 1);
            } else {
                hm.put(st, ++count);
            }
        }

        Set<Map.Entry<String, Integer>> mp = hm.entrySet();
        for (Map.Entry<String, Integer> entry : mp) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate element is" + entry.getKey());
            }
        }
    }
}



