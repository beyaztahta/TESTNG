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

public class Day22_NegativLoginTest2 {

    @Test
    public void  BlueCarRentalNegativeLoginTest() {
        //Siteye gidis ve login butona tiklama
        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
        BlueCarRentHomePage blueCarRentHomePage=new BlueCarRentHomePage();
        blueCarRentHomePage.homePageLoginButton.click();

        //Description:Kullanımda olmayan kullanici adi ve sifre ile giris yapilamamalı
        BlueCarRentLoginPage blueCarRentLoginPage=new BlueCarRentLoginPage();
        blueCarRentLoginPage.username.sendKeys(ConfigReader.getProperty("blueRental_username_negative_test2"));
        blueCarRentLoginPage.password.sendKeys(ConfigReader.getProperty("blueRental_password_negative_test2"));
        blueCarRentLoginPage.loginBtn.click();

        //Acceptance Criteria:Kullanici dogru email ve yanlıs sifre ile giris yaptiginda,hata mesajı almalı.
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(blueCarRentHomePage.userNotFoundBadMessage));

        Assert.assertTrue(blueCarRentHomePage.userNotFoundBadMessage.getText().contains("Bad"));

        Driver.closeDriver();

    }
}
