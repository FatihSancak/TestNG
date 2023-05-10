package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPage {
    public FaceBookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy (id="pass")
    public WebElement passwordTextBox;

    @FindBy (name="login")
    public WebElement loginButton ;


    @FindBy (className="_9ay7")
    public WebElement girilemediYaziElementi;
}
