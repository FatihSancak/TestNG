package tests.day17_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_PageClassUsingHotel {
    @Test
    public void test01() {
        HotelMyCampPage hotel = new HotelMyCampPage();
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna bas
        hotel.loginButton.click();

        // test data username: manager ,
        hotel.usernameTextBox.sendKeys("manager");

        // test data password : Manager1!
        hotel.passwordTextBox.sendKeys("Manager1!");
        hotel.loginButtonInput.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(hotel.loginBasariliText.isEnabled());
        Driver.closeDriver();
    }
}
