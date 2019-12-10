package Suite;

import Util.ConfigFileReader;
import Util.DriverManager;
import org.testng.annotations.*;

public class SuiteManager {
    DriverManager drivermanager;
    private static ConfigFileReader config=new ConfigFileReader();
    @BeforeSuite
    public void startdriver()
    {
        drivermanager=new DriverManager();

    }

    @AfterSuite(alwaysRun = true)
    public void quit()
    {
        DriverManager.driver.quit();

    }


    @BeforeClass
    public void launchUrl()
    {
        DriverManager.driver.manage().window().maximize();
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
