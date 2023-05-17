package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties ;

    static{
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            // fis dosya yolunu tanımladığımız configuration.properties dosyasını okudu
            properties = new Properties();
            properties.load(fis);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String  getProperty(String key){
        /*
        test method'undan gönderilen String key değerini alıp
        Properties class'ından getProperty methodunu kullanarak
        bu key'e ait value'yi döndürdü.
         */
       return properties.getProperty(key);
    }
}
