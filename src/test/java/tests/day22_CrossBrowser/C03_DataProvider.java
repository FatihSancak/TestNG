package tests.day22_CrossBrowser;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void testDataProvider() {
        AmazonPage amazonPage = new AmazonPage();
        // amazon ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // nutella araması yap
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // nutella sonuçlarının içeriğini test et
        String exptectedKelime = "Nutella";
        String actualKelime = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualKelime.contains(exptectedKelime));
        Driver.closeDriver();
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArray = {{"Nutella"}, {"Java"}, {"Çiğdem"},{"Netherlands"}};
        return arananKelimeArray;
    }
    @Test(dataProvider = "AranacakKelimeler")
    // aranacak kelimeleri bir liste gibi tutup
    // teste yollayacak bir veri sağlayıcısı oluşturulur

    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();
        // amazon.com sayfasına git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, çiğdem ve Netherlands için arama yapalım
        amazonPage.aramaKutusu.sendKeys(arananKelime, Keys.ENTER);

        // sonuçları aradığımız kelimeleri içerdiğini test edelim
        String exptectedKelime = arananKelime;
        String actualKelime = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualKelime.contains(exptectedKelime));

        // sayfayı kapatalım
        Driver.closeDriver();

        // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    }
}
