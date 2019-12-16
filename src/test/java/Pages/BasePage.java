package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends SuiteManager {
    @FindBy (xpath="//a[@class='nav-link text-white']")
   private WebElement loginbutton;

    public BasePage()
    {
        PageFactory.initElements(DriverManager.driver, this);
    }

    public LoginPage clickLoginButton()
    {
       //WebDriverWait wait=new WebDriverWait(DriverManager.driver,30);
       // wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
        System.out.println("Element is waiting");
        loginbutton.click();
        return new LoginPage();
    }


}
