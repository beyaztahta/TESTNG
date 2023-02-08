package techproed.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day22_NegativLoginTest3 extends ReusableMethods {

    BlueCarRentHomePage homePageObj = new BlueCarRentHomePage();

    @Test
    public void BlueCarRentalNegativeLoginTest() {
        //Siteye gidis yapın
        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
        waitFor(3);
        selectFromDropdown(ConfigReader.getProperty("blueRental_pick_up_dropdown"), homePageObj.selectCarDropdown);
        homePageObj.pickUpTextBox.sendKeys(ConfigReader.getProperty("blueRental_pick_up"));
        homePageObj.dropOffTextBox.sendKeys(ConfigReader.getProperty("blueRental_drop_off"));
        homePageObj.pickUpDate.sendKeys(ConfigReader.getProperty("blueRental_pick_up_date"));
        homePageObj.pickUpTime.sendKeys(ConfigReader.getProperty("blueRental_pick_up_time"));
        homePageObj.dropOffUpDate.sendKeys(ConfigReader.getProperty("blueRental_drop_off_date"));
        homePageObj.dropOffUpTime.sendKeys(ConfigReader.getProperty("blueRental_drop_off_time"));
        homePageObj.submitButton.click();
        waitFor(3);
        verifyElementDisplayed(homePageObj.loginAlert);

        //Description:Geçerli giriş yapmadan rezervasyon yapamamalı


        //Acceptance Criteria:Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
        //Ve giris yapilmadiginda
        //Hata mesaji almali : Please first login
        //Giris yapildiginda hata mesaji alınmamalı
    }


}