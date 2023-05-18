package tests.day21_ReuseableMethods_HtmlReports;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;

public class C02_ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException {
       // amazon sayfasının ekran görüntüsünü alın
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();


    }
}
