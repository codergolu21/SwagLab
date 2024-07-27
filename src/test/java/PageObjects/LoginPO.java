package PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPO extends BaseTest {

    public WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory
    @FindBy(id = "user-name")
    WebElement text_userEmail;

    @FindBy(id = "password")
    WebElement text_password;

    @FindBy(id = "login-button")
    WebElement button_submit;

    @FindBy(xpath = "//span[@class='title']")
    WebElement span_title;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;


    public void doLogin(String username, String password) {
        text_userEmail.sendKeys(username);
        text_password.sendKeys(password);
        button_submit.click();
    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();

    }

    public String getHeaderTitleText(){
        return span_title.getText();
    }
}

