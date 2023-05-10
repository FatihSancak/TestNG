package tests.day16_Notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertinos extends TestBase {


    @Test
    public void test01() {
        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- title'in Amazon icerdigini test edin
        String expectedTitle = "amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 3- arama kutusunun erişilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        // 4- arama kutusuna nutella yazip oratin
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        // 6- arama sonucunun Nutella icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("Nutella"));
    }
}