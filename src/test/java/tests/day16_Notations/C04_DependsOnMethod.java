package tests.day16_Notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.TestBase;

public class C04_DependsOnMethod{
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown(){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.quit();
    }
    @Test
    public void test01() {
        driver.get("http://www.aaaazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }

    @Test
    public void test04() {
        System.out.println("Test04 çalıştı");
    }
}
