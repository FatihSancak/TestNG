package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='nav-link'])[7]")
    public WebElement loginButton;

    @FindBy(id = "UserName")
    public WebElement usernameTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;
    @FindBy(id = "btnSubmit")
    public WebElement loginButtonInput;

    @FindBy(xpath = "//li/a[text()='ListOfUsers']")
    public WebElement loginBasariliText;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement loginErrorText;


}
