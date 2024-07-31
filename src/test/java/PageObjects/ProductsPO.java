package PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class ProductsPO extends BaseTest {

    public WebDriver driver;

    public ProductsPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory
    @FindBy(className = "inventory_item_name")
    List<WebElement> productsNameList;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productsPriceList;

    @FindBy(className = "product_sort_container")
    WebElement dropDown_orderBy;

    public List<String> getProductNameTextList(){
        List<String> arr = new ArrayList<>();
        for (int i = 0; i< productsNameList.size(); i++){
            arr.add(i,productsNameList.get(i).getText());
        }
        return arr;
    }

    public List<Float> getProductPriceList(){
        List<Float> arr = new ArrayList<>();
        for (int i = 0; i< productsPriceList.size(); i++){
            String price = productsPriceList.get(i).getText().substring(1);
            float value = Float.parseFloat(price);
            arr.add(i,value);
        }
        return arr;
    }

    public void selectByDropDown(String orderBy){
        Select s = new Select(dropDown_orderBy);
        s.selectByValue(orderBy);
    }

}
