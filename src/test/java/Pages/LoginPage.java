package Pages;

import Suite.SuiteManager;
import Util.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends SuiteManager {

    public LoginPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(id="spree_user_email")
    WebElement usernamefield;

    @FindBy(id="spree_user_password")
    WebElement passwordfield;

    @FindBy(xpath="//input[@class='btn btn-lg btn-success btn-block']")
    WebElement loginbtn;

    @FindBy(xpath="//h3[.='Login as Existing Customer']")
    WebElement textmsg;

    public void enterValue(WebElement field, String value)

    {
        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public HomePage login(String username, String password)
    {
        WebDriverWait wait =new WebDriverWait(DriverManager.driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(usernamefield));
        wait.until(ExpectedConditions.elementToBeClickable(passwordfield));
        enterValue(usernamefield,username);
        enterValue(passwordfield,password);
        return new HomePage();
    }

    public String getLoginPageTitle()
    {
        String title=DriverManager.driver.getTitle();
        System.out.println(title);
        return title;
    }

    public String getLoginPageMsg()
    {
        return textmsg.getText();

    }

    public HomePage doLogin(String uname, String pwd)
    {
        usernamefield.sendKeys(uname);
        passwordfield.sendKeys(pwd);
        loginbtn.click();
        return new HomePage();
    }


}
