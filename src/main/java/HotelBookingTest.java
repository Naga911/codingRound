package tester.Process;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import tester.Generics.PropertyManager;

import java.util.concurrent.TimeUnit;

public class HotelBookingTest {


    @FindBy(xpath = "//input[@id='Tags']")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement search;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;




    @Test
    public void shouldBeAbleToSearchForHotels() {
       WebDriver driver=null ;
        String baseurl = PropertyManager.readproperty("url");

        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement hotel = driver.findElement(By.xpath("//li[contains(@class,'hotelApp')]//a[contains(text(),'Hotels')]"));
        hotel.click();
        //hotel.click();
        WebElement landmark = driver.findElement(By.xpath("//input[@id='Tags']"));
        landmark.sendKeys("Indiranagar, Bangalore");


        //   new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        WebElement searchbutton = driver.findElement(By.xpath("//input[@id='SearchHotelsButton']"));
        searchbutton.click();


    }





}
