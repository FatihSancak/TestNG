package tests.day17_POM;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_NewDriverFirstClass {
    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();
    }
}
