package tests.day21_ReuseableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestReport extends TestBaseRapor {

    BlueRentalCarsPage brc = new BlueRentalCarsPage();

    @Test
    public void positiveLoginTest() {

        extentTest = extentReports.createTest("Pozitif Login", "Geçerli user ve pass ile giriş yapabilmeli");

        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("BRC ana sayfaya gidildi");

        // login butonuna bas
        brc.ilkLogin.click();
        extentTest.info("İlk Login Butonuna Tıklandı");

        // test data useremail: test@test.com
        brc.tbUserName.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Kulllanıcı Adı Girildi");

        // test data password : 54321
        brc.tbPassword.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Geçerli Password Yazıldı");

        // Login butonuna bas
        brc.btnLogin.click();
        extentTest.info("Giriş düğmesine basıldı");

        // Değerleri girildiğinde sayfaya başarili sekilde girilebildiğini test et

        String actualUserName = brc.kullaniciProfilIsmi.getText();
        String expectedUserName = ConfigReader.getProperty("brcValidUserName");

        Assert.assertEquals(actualUserName, expectedUserName);

        extentTest.pass("Kullanıcı başarıyla giriş yaptı");
        // Sayfayı kapat
        Driver.closeDriver();
    }
}
