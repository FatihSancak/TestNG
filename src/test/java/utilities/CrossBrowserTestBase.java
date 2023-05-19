package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrossBrowserTestBase {
    protected WebDriver driver;
    @Parameters("browser")

    @BeforeMethod
    public void setUp(@Optional String browser){

        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void tearDown(){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        CrossDriver.closeDriver();

    }
    public String getTarih() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarih = date.format(dtf);
        return tarih;
    }
}
