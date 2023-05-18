package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCarsPage {

    public BlueRentalCarsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement ilkLogin;

    @FindBy(xpath="//input[@name='email']")
    public WebElement tbUserName;

    @FindBy(xpath="//input[@name='password']")
    public WebElement tbPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement kullaniciProfilIsmi;
    @FindBy(xpath = "//button[@aria-label='close']")
    public WebElement toast;
}
