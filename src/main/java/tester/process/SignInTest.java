package tester.Process;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import tester.Generics.Chrome;


import tester.Generics.PropertyManager;

import java.util.concurrent.TimeUnit;

public class SignInTest {

    WebDriver driver;
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

    public SignInTest(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Test
    public void ThrowAnErrorIfSignInDetailsAreMissing() throws Exception {

        //passing url to driver by property file
        String baseurl = PropertyManager.readproperty("url");
        driver.get(baseurl);
        Trips.click();

        Sign.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Switching to Frame
        driver.switchTo().frame(popupframe);
        SigninButton.click();

        String errors1 = error.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        System.out.println(errors1);

    }



}
