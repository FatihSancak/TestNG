package tests.day16_Notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    @Test(groups = "grup2")
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- title'in Amazon icerdigini test edin
        String expectedTitle = "amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Sayfa Başlığı Amazon içermiyor");

        // 3- arama kutusunun erişilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"Arama Kutusuna Erişilemiyor");

        // 4- arama kutusuna nutella yazip oratin
        aramaKutusu.sendKeys("kutella", Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(),"Arama Yapılamadı");

        // 6- arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"), "Sonuç yazısı nutella içermiyor");

        softAssert.assertAll();
        System.out.println("Assortion'lardan fail olan varsa bu kod çalışmayacaktır.");

    }
}
