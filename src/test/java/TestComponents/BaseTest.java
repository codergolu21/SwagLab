package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {
      public static WebDriver driver;
    public WebDriver intializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/src/Resources/GlobalData.properties"));
        prop.load(fs);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }


    public String getScreenshot(String testCaseName , WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File snap = ts.getScreenshotAs(OutputType.FILE);
        String filepath = System.getProperty("user.dir")+"/test-output/" + testCaseName + ".png";
        File file = new File(filepath);
        FileUtils.copyFile(snap,file);
        return filepath;
    }
}


