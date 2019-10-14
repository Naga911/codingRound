package tester.Process;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SignInTest {


    WebDriver driver;

    public SignInTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "Your trips")
    private WebElement Trips;

    @FindBy(id = "SignIn")
    private WebElement Sign;

    @FindBy(xpath = "//iframe[@id='modal_window']")
    private WebElement popupframe;

    @FindBy(xpath = "//button[@id='signInButton']")
    private WebElement SigninButton;

    @FindBy(id = "errors1")
    private WebElement error;

    @FindBy(xpath = "//a[@id='close']")
    private WebElement close;


    public void login() {

        Trips.click();
        Sign.click();

        //Switching to Frame
        driver.switchTo().frame(popupframe);
        SigninButton.click();

        String errors1 = error.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        System.out.println(errors1);

        driver.switchTo().defaultContent();

        close.click();
    }


}
