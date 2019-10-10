package tester.Generics;


public class driver implements Webdriver{

    @Override
    public void openBrowser()
    {
        System.out.println("Opening driver");
    }


    @Override
    public void closeBrowser()
    {
        System.out.println("Closing driver");
    }
}
