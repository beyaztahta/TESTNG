package techproed.tests.smoketest;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.pages.BlueCarRentalDashboard;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;



public class Day22_PositiveLoginTest {
    @Test
    public void test01() {

        //1. url'ye git
        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));

        //2. Login butonuna bas
        BlueCarRentHomePage objeHomePage = new BlueCarRentHomePage();
        objeHomePage.homePageLoginButton.click();

        //3. username ve sifre alanlarini gecerli verilerle doldur
        BlueCarRentLoginPage objeLoginPage = new BlueCarRentLoginPage();
        objeLoginPage.username.sendKeys(ConfigReader.getProperty("blueRental_username"));
        objeLoginPage.password.sendKeys(ConfigReader.getProperty("blueRental_password"));

        //4. login butonuna bas
        objeLoginPage.loginBtn.click();

        //5. basarili bir sekilde giris yapildigini dogrula
        BlueCarRentalDashboard dashboardObje = new BlueCarRentalDashboard();
        Assert.assertEquals("Jack Nicholson", dashboardObje.userNameText.getText());
        Driver.closeDriver();
    }
}


