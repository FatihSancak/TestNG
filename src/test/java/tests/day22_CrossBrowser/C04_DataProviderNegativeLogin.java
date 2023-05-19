package tests.day22_CrossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderNegativeLogin {
    BlueRentalCarsPage brc;

    @DataProvider
    public static Object[][] KullaniciSaglayici() {
        Object[][] kullaniciBilgileri = {{"firuze@naber.com","54678"},{"murat@bilmemki.com","bilmiyor"},{"sanalKullanici@sicakmail.com","11111"} };
        return kullaniciBilgileri;
    }

    @Test(dataProvider =  "KullaniciSaglayici")
    public void yanlisEmail(String userEmail, String passWord)  {
        brc = new BlueRentalCarsPage();
        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brc.ilkLogin.click();

        // test data useremail: DataProvider'dan alınacak ,
        brc.tbUserName.sendKeys(userEmail);

        // test data password :  DataProvider'dan alınacak
        brc.tbPassword.sendKeys(passWord);

        // Login butonuna bas
        brc.btnLogin.click();

        // Değerleri girildiğinde sayfaya başarılı girilemediğinin testi
        Assert.assertTrue(brc.btnLogin.isDisplayed());
        Driver.closeDriver();
    }
}
