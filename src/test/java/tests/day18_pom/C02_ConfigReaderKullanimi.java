package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
        FaceBookPage faceBookPage = new FaceBookPage();

        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // kullanıcı email kutusuna yanlış kullanıcı adını yazdırın
        faceBookPage.emailTextBox.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        // kullanıcı passord kutusuna yanlış şifre giriniz
        faceBookPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // Login buttonuna basın
        faceBookPage.loginButton.click();

        // giriş yapılamadığını test edin
        Assert.assertTrue(faceBookPage.girilemediYaziElementi.isDisplayed());

        // sayfayı kapatın
        Driver.closeDriver();
    }
}
