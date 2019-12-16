package Suite;

import Util.ConfigFileReader;
import Util.DriverManager;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SuiteManager {
    DriverManager drivermanager;
    private static ConfigFileReader config=new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startdriver() throws MalformedURLException {
        drivermanager=new DriverManager();


    }

    //@AfterSuite(alwaysRun = true)
   // public void quit()
        //DriverManager.driver.quit();




    @BeforeClass
    public void launchUrl()
    {
        String baseurl=config.getProperty("base_url");
        System.out.println(baseurl);
        DriverManager.driver.get(baseurl);

    }

    @BeforeTest
    public void getSearchProp()
    {
        String searchprod1=config.getProperty("searchprod");

    }



}
