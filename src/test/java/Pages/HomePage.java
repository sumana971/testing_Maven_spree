package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends SuiteManager {

    @FindBy(xpath = "//a[.='Bags']")
    WebElement bags;

    @FindBy(xpath = "//a[.='Mugs']")
    WebElement Mugs;

    @FindBy(xpath = "//a[@class='cart-info nav-link full']")
    WebElement cartbtn;

    @FindBy(xpath = "//a[.='Clothing']")
    WebElement clothing;
    @FindBy(xpath = "//div[.='Logged in successfully']")
    WebElement msg;

    @FindBy(xpath = "//a[@class='d-block text-center']")
    List<WebElement> list;

    @FindBy(css="div[id^='product_']")
    List<WebElement>bgs;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchbox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchbutton;

    //To verify Shopping cart



    //List<WebElement> list=DriverManager.driver.findElements(By.xpath())


    public HomePage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    public String verifyMsgIsDisplayed() {
        return msg.getText();
        //System.out.println(message);

    }
//Verify the bags List
    public void doverifyListOfBags() {
        for (WebElement bags : bgs) {
            String bg_text = bags.getText();
            if (bg_text.contains("Bag")) {
                System.out.println("The items which contain bag are" + bg_text);
            }
        }
    }
    //Reading the bag keyword from config file
    public void getProperties (String configname)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchbox));
        searchbox.sendKeys(configname);
        searchbutton.click();
        doverifyListOfBags();

    }

// Click the selected item and add to cart and proceed with the checkout
    public ProductPage doClick ()
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(bags));
            bags.click();
            for (WebElement bags : list) {
                String bg_text = bags.getText();
                if (bg_text.equals("Spree Bag")) {
                    bags.click();
                }
            }


            //wait.until(ExpectedConditions.elementToBeClickable(Mugs));
           // Mugs.click();
           // wait.until(ExpectedConditions.elementToBeClickable(clothing));
            //clothing.click();
            return new ProductPage();
        }


//SHopping cart details
        public ShoppingCart getcartdetails()
        {
            cartbtn.click();
            return new ShoppingCart();
        }
    }




