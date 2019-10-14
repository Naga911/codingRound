package tester.Applications;

import cucumber.api.java.gl.E;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import tester.Generics.ChromeBrowserFactory;
import tester.Generics.PropertyManager;
import tester.Process.FlightBookingTest;
import tester.Process.HotelBookingTest;
import tester.Process.SignInTest;

import java.util.concurrent.TimeUnit;

public class ProcessTest extends ChromeBrowserFactory {


    @Test(priority = 1)
    public void SignInDetailsAreMissing() throws Exception {

        SignInTest si = new SignInTest(driver);
        si.login();

    }

    @Test(priority = 2)
    public void HotelSearch() throws Exception {
        HotelBookingTest hi = new HotelBookingTest(driver);
        hi.shouldBeAbleToSearchForHotels();
    }

    @Test(priority = 3)
    public void flightBook() throws Exception {

        FlightBookingTest fi = new FlightBookingTest(driver);
        fi.testOneWayJourney();
    }

}
