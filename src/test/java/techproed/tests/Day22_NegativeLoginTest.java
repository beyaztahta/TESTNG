package techproed.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.time.Duration;

public class Day22_NegativeLoginTest {

//    @Test
//    public void BlueCarRentalNegativeLoginTest() {
//
//        //Siteye gidis ve login butona tiklama
//        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
//        BlueCarRentHomePage homePageObject = new BlueCarRentHomePage();
//        homePageObject.loginBtnHomePage.click();
//
//        //Description:Admin bilgileriyle giriş
//        BlueCarRentLoginPage blueRentalLoginPageObject = new BlueCarRentLoginPage();
//        blueRentalLoginPageObject.username.sendKeys(ConfigReader.getProperty("blueRental_username_negative_test"));
//        blueRentalLoginPageObject.password.sendKeys(ConfigReader.getProperty("blueRental_password_negative_test"));
//        blueRentalLoginPageObject.LoginBtn.click();
//
//        //Acceptance Criteria:Admin olarak, uygulamaya giriş yapamamaliyim
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); //Uyari mesaji icin Explicit wait kullandim
//        wait.until(ExpectedConditions.visibilityOf(homePageObject.userNotFoundMessage));
//
//        System.out.println(homePageObject.userNotFoundMessage.getText());
//        Assert.assertTrue(homePageObject.userNotFoundMessage.getText().contains("not found"));
//
//        //Driver'i kapatalim
//        Driver.closeDriver();
//
//    }
}
