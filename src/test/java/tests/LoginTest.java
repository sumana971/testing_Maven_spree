/** Login Test used to execute
 * Login Test cases where Username and Password are fetched from Configfile.properties
 *
 */

package tests;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Suite.SuiteManager;
import Util.ConfigFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.lognCredentials;

public class LoginTest extends SuiteManager {
    ConfigFileReader config = new ConfigFileReader();
    public BasePage basePage;
    public LoginPage loginpage;
    public HomePage homepage;

    @Test
    public void getTitle() {
        basePage = new BasePage();
        loginpage = new LoginPage();
        loginpage = basePage.clickLoginButton();
        String title = loginpage.getLoginPageTitle();
        //System.out.println(title);
        Assert.assertEquals(title,"Login - Spree Demo Site");

    }


    @Test(priority = 1)
    public void getLoginDetails() {
        homepage = loginpage.doLogin(config.getProperty("username"), config.getProperty("password"));

    }

    @Test()
    public void verify_Loggedinmsg() {
        Assert.assertEquals(loginpage.getLoginPageMsg(), "Login as Existing Customer");
        System.out.println("The displayed message is "  +loginpage.getLoginPageMsg());


    }


}