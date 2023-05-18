package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    BlueRentalCarsPage brc;
    // yanlış şifre tesi
    @Test
    public void yanlisSifre()  {
         brc = new BlueRentalCarsPage();
        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brc.ilkLogin.click();

        // test data useremail: test@test.com ,
        brc.tbUserName.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 12345
        brc.tbPassword.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // Login butonuna bas
        brc.btnLogin.click();
        brc.toast.click();

        // Değerleri girildiğinde sayfaya başarılı girilemediğinin testi
        Assert.assertTrue(brc.btnLogin.isDisplayed());
        Driver.closeDriver();
    }

    // yanlış kullanıcı adı (e-mail) testi
    @Test
    public void yanlisEmail()  {
        brc = new BlueRentalCarsPage();
        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brc.ilkLogin.click();

        // test data useremail: test@test.com ,
        brc.tbUserName.sendKeys(ConfigReader.getProperty("brcWrongUserName"));

        // test data password : 12345
        brc.tbPassword.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // Login butonuna bas
        brc.btnLogin.click();

        // Değerleri girildiğinde sayfaya başarılı girilemediğinin testi
        Assert.assertTrue(brc.btnLogin.isDisplayed());
        Driver.closeDriver();
    }

    // yanlış kullanıcı adı ve şifre testi.
    @Test
    public void yanlisKullanici(){
        brc = new BlueRentalCarsPage();
        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brc.ilkLogin.click();

        // test data useremail: test@test.com ,
        brc.tbUserName.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        // test data password : 12345
        brc.tbPassword.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // Login butonuna bas
        brc.btnLogin.click();

        // Değerleri girildiğinde sayfaya başarılı girilemediğinin testi
        Assert.assertTrue(brc.btnLogin.isDisplayed());
        Driver.closeDriver();
    }
}

