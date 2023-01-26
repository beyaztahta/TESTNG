package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    //Bu sınıfın tek amacı configuration.properties dosyasını okumak ıcın kullaılır.
    //property file i okumak icin properti objesi kullanılır.
    private static Properties properties;
    //static block: ilk calısacak.
    static {
        //data cekmek istedigim dosyanın path i
        String path = "configuration.properties";
        try {
            // configuration.properties  dosyasını acar.
            FileInputStream fileInputStream = new FileInputStream(path);

            //properties objesini instantie ediyoruz.
            properties = new Properties();

            //configuration.properties dosyasındaki dataları yukler.
            properties.load(fileInputStream);

            //acılan dosyayı kapatır.
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Key degeri girdigimizde value return edecek.Ornegin;
    //ConfigReader.getProperty("browser");---> chrome
    //ConfigReader.getProperty("amazon_url");---> http://amazon.com
    //ConfigReader.getProperty("username");---> ali
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;
    }

}
