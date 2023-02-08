package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueCarRentalDashboard {

    public BlueCarRentalDashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement userNameText;

    @FindBy(linkText = "Logout")
    public WebElement logOutBtn;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement logoutAcceptBtn;
}
