package tester.Generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends AbstractFactory {
    WebDriver driver = null;

    @Override
    public WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver",
                        "C:\\test\\src\\Chrome.exe");
                driver = new ChromeDriver();

            }

        }
        return driver;
    }


}





