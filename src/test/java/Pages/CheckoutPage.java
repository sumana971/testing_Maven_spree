package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends SuiteManager {

    public CheckoutPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }



}
