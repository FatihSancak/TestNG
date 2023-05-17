package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PossitiveLoginTest {
    BlueRentalCarsPage brc = new BlueRentalCarsPage();
    @Test
    public void positiveLoginTest() {

        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brc.ilkLoginButonu.click();

        // test data useremail: test@test.com
        brc.tbUserName.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 54321
        brc.tbPassword.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // Login butonuna bas
        brc.btnLogin.click();

        // Değerleri girildiğinde sayfaya başarili sekilde girilebildiğini test et

        String actualUserName = brc.kullaniciProfilIsmi.getText();
        String expectedUserName = ConfigReader.getProperty("brcValidUserName");

        Assert.assertEquals(actualUserName,expectedUserName);

        // Sayfayı kapat
        Driver.closeDriver();
    }
}
