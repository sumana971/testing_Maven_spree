package testdata;

import org.testng.annotations.DataProvider;

public class lognCredentials {

    @DataProvider(name = "lognCredentials")
    public static Object[][] loginData() {
        return new Object[][]{

                {"sumu971@gmail.com", "Orange@971"}

        };


    }
}
