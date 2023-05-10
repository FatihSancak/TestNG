package tests.day16_Notations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {
    @BeforeClass
    public void BeforeClassMethod(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void AfterClassMethod(){
        System.out.println("After Class");
    }
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test03() {
        driver.get("https://www.hepsiburada.com");
        System.out.println(driver.getCurrentUrl());
    }
}
