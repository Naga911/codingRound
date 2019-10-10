package tester.Generics;


import org.openqa.selenium.WebDriver;

public abstract class AbstractFactory {
    abstract WebDriver getDriver(String browserName);

}
