package techproed.tests.smoketest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.pages.BlueCarRentalDashboard;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;



public class Day22_PositiveLoginTest {
    @Test
    public void test01() {

        Reporter.log("Sayfaya git ");
        //1. url'ye git
        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));

        //2. Login butonuna bas
        BlueCarRentHomePage objeHomePage = new BlueCarRentHomePage();
        BlueCarRentLoginPage objeLoginPage = new BlueCarRentLoginPage();
        BlueCarRentalDashboard dashboardObje = new BlueCarRentalDashboard();

        Reporter.log("Login butonuna tıkla.");
        objeHomePage.homePageLoginButton.click();

        //3. username ve sifre alanlarini gecerli verilerle doldur
        Reporter.log("Giris bilgilerini gir.");
        objeLoginPage.username.sendKeys(ConfigReader.getProperty("blueRental_username"));
        objeLoginPage.password.sendKeys(ConfigReader.getProperty("blueRental_password"));

        //4. login butonuna bas
        objeLoginPage.loginBtn.click();

        //5. basarili bir sekilde giris yapildigini dogrula
        Reporter.log("Giris yapıldıgını verify et.");
        Assert.assertEquals("Jack Nicholson", dashboardObje.userNameText.getText());
        Reporter.log("Driver ı kapat.");
        Driver.closeDriver();
    }
}


