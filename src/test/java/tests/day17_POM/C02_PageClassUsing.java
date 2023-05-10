package tests.day17_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassUsing {
    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys("Nutella",Keys.ENTER);

        String actualSonuc = amazonPage.aramaSonucElementi.getText();
        String expectedSonuc = "Nutella";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        Driver.closeDriver();
    }
}
