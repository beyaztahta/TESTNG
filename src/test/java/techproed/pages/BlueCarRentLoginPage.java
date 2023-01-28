package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueCarRentLoginPage {


    public BlueCarRentLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@type='email']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginBtn;


//
//    @FindBy(xpath = "//*[@name='email']")
//    public WebElement username;
//
//    @FindBy(xpath = "//*[@name='password']")
//    public WebElement password;
//
//    @FindBy(xpath = "//*[@type='submit']")
//    public WebElement LoginBtn;

}
