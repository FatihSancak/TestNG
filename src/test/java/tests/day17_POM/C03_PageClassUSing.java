package tests.day17_POM;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C03_PageClassUSing {
    @Test
    public void test01() {
        FaceBookPage fbpage = new FaceBookPage();

        // facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");

        // kullanıcı email kutusuna rastegele bir isim yazdırın
        Faker faker = new Faker();
        fbpage.emailTextBox.sendKeys(faker.internet().emailAddress());

        // kullanıcı passord kutusuna rastegele bir isim yazdırın
        fbpage.passwordTextBox.sendKeys(faker.internet().password());

        // Login buttonuna basın
        fbpage.loginButton.click();

        // giriş yapılamadığını test edin
        Assert.assertTrue(fbpage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
