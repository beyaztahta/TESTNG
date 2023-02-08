package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_NegativLoginTest4 {
    @Test
    public void BlueCarRentalNegativeLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
        BlueCarRentHomePage blueCarRentHomePage = new BlueCarRentHomePage();
        blueCarRentHomePage.homePageLoginButton.click();


        //Description:
        //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı

        BlueCarRentLoginPage blueCarRentLoginPage = new BlueCarRentLoginPage();
        blueCarRentLoginPage.username.sendKeys(ConfigReader.getProperty("blueRental_username_negative_test4"));
        blueCarRentLoginPage.password.sendKeys(ConfigReader.getProperty("blueRental_password_negative_test4"));
        blueCarRentLoginPage.loginBtn.click();


        //Acceptance Criteria:
        //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
        //Error Message: email must be a valid email
        //Dogru email uzantisi girildiğinde hata mesajı alınmamalı

        Assert.assertEquals(blueCarRentLoginPage.invalidFeedback.getText(), "email must be a valid email");
        Driver.closeDriver();

    }


}
