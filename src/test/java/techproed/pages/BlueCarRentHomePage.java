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



    @FindBy(xpath = "//*[@class='Toastify__toast-body']//div")
    public WebElement userNotFoundMessage;//false email false password

    @FindBy(xpath =" //*[@class='Toastify__toast-body']//div")
    public WebElement userNotFoundBadMessage;//true email false password

    @FindBy(xpath ="//*[@name='car']")
    public WebElement selectCarDropdown;

    @FindBy(xpath ="//*[@title='Pick Up']")
    public WebElement pickUpTextBox;

    @FindBy(xpath ="//*[@title='Drop Off']")
    public WebElement dropOffTextBox;

    @FindBy(xpath ="//*[@name='pickUpDate']")
    public WebElement pickUpDate;

    @FindBy(xpath ="//*[@name='pickUpTime']")
    public WebElement pickUpTime;

    @FindBy(xpath ="//*[@name='dropOffDate']")
    public WebElement dropOffUpDate;

    @FindBy(xpath ="//*[@name='dropOffTime']")
    public WebElement dropOffUpTime;

    @FindBy(xpath ="//*[@class='w-100 btn btn-primary btn-lg']")
    public WebElement submitButton;

    @FindBy(xpath ="//*[@class='Toastify__toast-body']")
    public WebElement loginAlert;






}
