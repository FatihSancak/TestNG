package tests.day21_ReuseableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class C01_WindowHandleReusableMethods  {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/windows sitesine git
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH =Driver.getDriver().getWindowHandle();

        // click hre buttonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti = Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each: windowHandleSeti
             ) {
            if(!each.equals(ilkSayfaWH)){
                ikinciSayfaWH = each;
            }

            Driver.getDriver().switchTo().window(ikinciSayfaWH);
        }

        System.out.println(Driver.getDriver().getTitle());


        // Açılan yeni tab'ın title'nin "New Window" olduğunu test edin

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


        Driver.closeDriver();


    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/windows sitesine git
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        // click hre buttonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        // Açılan yeni tab'ın title'nin "New Window" olduğunu test edin
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();



        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();


    }

}
