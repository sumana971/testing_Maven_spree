package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends SuiteManager {

    @FindBy(xpath = "//h1[.='Spree Bag']")
    WebElement spreebagheading;

    @FindBy(xpath = "//span[@class='lead price selling']")
    WebElement price;

    By id= By.id("quantity");
    WebElement quantity;

    @FindBy(xpath = "//button[@id='add-to-cart-button']")
    WebElement addtocart;

    public ProductPage()
    {
        PageFactory.initElements(DriverManager.driver, this);
    }

    public String getPrice()
    {
        return price.getText();
    }

    public String getProductHeading()
    {
        return spreebagheading.getText();
    }


    public ShoppingCart addToCart(String qty)
    {
        quantity.clear();
        quantity.sendKeys(qty);
        WebDriverWait wait=new WebDriverWait(DriverManager.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(addtocart));
        addtocart.click();
        return new ShoppingCart();

    }
}
