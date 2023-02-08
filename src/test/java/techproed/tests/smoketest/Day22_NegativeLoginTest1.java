package techproed.tests.smoketest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.time.Duration;

public class Day22_NegativeLoginTest1 {

    @Test
    public void BlueCarRentalNegativeLoginTest() {

         //Siteye gidis ve login butona tiklama
        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
        BlueCarRentHomePage homePageObject = new BlueCarRentHomePage();
        homePageObject.homePageLoginButton.click();

        //Description:Admin bilgileriyle giris
        BlueCarRentLoginPage loginPageObject = new BlueCarRentLoginPage();
        loginPageObject.username.sendKeys(ConfigReader.getProperty("blueRental_username_negative1"));
        loginPageObject.password.sendKeys(ConfigReader.getProperty("blueRental_password_negative1"));
        loginPageObject.loginBtn.click();

        //Acceptance Criteria:Admin olarak, uygulamaya giriş yapılmamalı
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(homePageObject.userNotFoundMessage));

        Assert.assertTrue(homePageObject.userNotFoundMessage.getText().contains("not found"));
        Driver.closeDriver();

        //email ve sifre yanlıs

    }
}
