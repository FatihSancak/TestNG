package tests.day17_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C05_PageClassUsingHotel2 {
    @Test
    public void test() {
        HotelMyCampPage hotel = new HotelMyCampPage();
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna bas
        hotel.loginButton.click();

        // test data username: manager1 ,
        hotel.usernameTextBox.sendKeys("manager1");

        // test data password : manager1!
        hotel.passwordTextBox.sendKeys("manager1!");
        hotel.loginButtonInput.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotel.loginErrorText.isEnabled());
        Driver.closeDriver();
    }
}
