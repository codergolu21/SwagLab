package TestComponents;


import PageObjects.LoginPO;
import PageObjects.ProductsPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.*;

public class ProductsPage extends BaseTest {

    public WebDriver driver;
    public LoginPO lp;
    public ProductsPO productPage;
    List<String> productNameList;
    List<Float> productPriceList;

    @BeforeClass(alwaysRun = true)
    public void prerequisite() throws IOException {
        driver = intializeDriver();
        driver.get("https://www.saucedemo.com/");
        lp = new LoginPO(driver);
        productPage = new ProductsPO(driver);
        lp.doLogin("standard_user", "secret_sauce");
        productNameList = productPage.getProductNameTextList();
        productPriceList = productPage.getProductPriceList();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void a_to_z() {
        productPage.selectByDropDown("az");
        List<String> orderedProductList = productPage.getProductNameTextList();
        Collections.sort(productNameList);
        Assert.assertEquals(orderedProductList, productNameList);

    }

    @Test
    public void z_to_a() {
        productPage.selectByDropDown("za");
        List<String> orderedProductList = productPage.getProductNameTextList();
        Collections.sort(productNameList, Collections.reverseOrder());
        Assert.assertEquals(orderedProductList, productNameList);
    }

    @Test
    public void lo_to_hi() {
        productPage.selectByDropDown("lohi");
        List<Float> orderedProductList = productPage.getProductPriceList();
        Collections.sort(productPriceList);
        Assert.assertEquals(orderedProductList, productPriceList);

    }

    @Test
    public void hi_to_lo() {
        productPage.selectByDropDown("hilo");
        List<Float> orderedProductList = productPage.getProductPriceList();
        Collections.sort(productPriceList, Collections.reverseOrder());
        Assert.assertEquals(orderedProductList, productPriceList);

    }
}
