package tester.Generics;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyManager {

    @SuppressWarnings("Duplicates")
    public static String readproperty(String keys) {
        String value = null;
        try (FileReader reader = new FileReader("C:\\test\\src\\configuration.properties")) {

            Properties properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            value = properties.getProperty(keys);
            reader.close();

            Enumeration<Object> enuKeys = properties.keys();

            String key = (String) enuKeys.nextElement();
            String values = properties.getProperty(keys);
           // System.out.println(key + ": " + values);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }



}
