package TestComponents;

import DataReader.JsonDataReader;
import PageObjects.LoginPO;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPage extends BaseTest {
    public WebDriver driver;
    public LoginPO lp;

    @BeforeMethod(alwaysRun = true)
    public void prerequisite() throws IOException {
        driver = intializeDriver();
        driver.get("https://www.saucedemo.com/");
        lp = new LoginPO(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }



    @Test(dataProvider = "getData")
    public void loginUserTest(HashMap<String, String> input)  {

        lp.doLogin(input.get("username"),input.get("password"));
        if (input.get("message").equalsIgnoreCase("valid")) {
            Assert.assertEquals("Product", lp.getHeaderTitleText());
        } else {
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", lp.getErrorMessage());
            System.out.println(lp.getErrorMessage());
        }
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        JsonDataReader js = new JsonDataReader();
        List<Map<String, String>> input = js.jsonToMap("/src/Data/LoginUser.json");
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("email", "standard_user");
//        map.put("password", "secret_sauce");
//        map.put("message", "Valid");
//
//        HashMap<String, String> map1 = new HashMap<String, String>();
//        map1.put("email", "Standard_user");
//        map1.put("password", "Secret_sauce");
//        map1.put("message", "Invalid");
        return new Object[][] {{input.get(0)},{input.get(1)}};


    }

}
