package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueCarRentHomePage {
    public BlueCarRentHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@href='/login']")
    public WebElement homePageLoginButton;




    //    @FindBy(xpath = "//*[@href='/login']")
    //    public WebElement loginBtnHomePage;
    //
    //    @FindBy(xpath = "//*[@class='Toastify__toast-body']//div")
    //    public WebElement userNotFoundMessage;




}
