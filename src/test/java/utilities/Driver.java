package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'da Driver için TEstBAse class'ına extends etmek yerine
    Driver class'ından static methodlar kullanarak
    driver oluşturup, ilgili ayarların yapılması
    ve en sonunda driver'in kapatilmasi tercih edilmiştir.

    POM'de driver class'ındaki getDriver method'una object
    oluşturularak kullanılmasını engellemek için Singleton Pattern
    kullanımı benisenmiştir.

    Singleton Pattern : Tekli kullanım, bir class'ın farklı class'lardan
    object oluşturularak kullanımını engellemek için kullanılır.

    Bunu sağlamak için yapmamız gereken şey oldukça basit.
    Object oluşturmak için kullanılan constructor'ı private yapıldığında
    başka class'larda Driver class'ından object oluşturulması mümkün olmaz.
     */
    private Driver(){

    }
    static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) { // driver'ı tekrar tekrar oluşturmasını engelledi.
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new SafariDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
                    
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
