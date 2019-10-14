package tester.Process;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import tester.Generics.ChromeBrowserFactory;
import tester.Generics.PropertyManager;

import java.util.concurrent.TimeUnit;

public class HotelBookingTest {


    @FindBy(xpath = "//input[@id='Tags']")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement search;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @FindBy(linkText = "Indiranagar, Bangalore, Karnataka, India")
    private WebElement SelectLocation;

    @FindBy(xpath = "//li[contains(@class,'hotelApp')]//a[contains(text(),'Hotels')]")
    private WebElement Hotel;

    @FindBy(xpath = "//input[@id='Tags']")
    private WebElement landmark;

    WebDriver driver;

    public HotelBookingTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void shouldBeAbleToSearchForHotels() {


        Hotel.click();
        landmark.sendKeys("Indiranagar, Bangalore");
        System.out.println("hotel");

        SelectLocation.click();

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        WebElement searchbutton = driver.findElement(By.xpath("//input[@id='SearchHotelsButton']"));
        searchbutton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Cleartrip | Bangalore";
        Assert.assertEquals(expectedTitle,actualTitle);


    }


}
