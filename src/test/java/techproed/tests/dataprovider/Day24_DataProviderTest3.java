package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.pages.BlueCarRentalDashboard;

import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day24_DataProviderTest3 {
    BlueCarRentHomePage blueRentalHomePage;
    BlueCarRentLoginPage blueRentalLoginPage;
    BlueCarRentalDashboard blueRentalDashboard;

    // excel datalari data proviter  e gelecek -- data proviter dan test methodlarina gidecek.

    @DataProvider(name = "1")
    public Object[][] customerData() {
        // excelden aldigimiz datalari data provider ile test e aktaracagiz.
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName ="customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        Object musteriBilgileri[][] = excelUtils.getDataArrayWithoutFirstRow();

        return musteriBilgileri;
    }




    @Test(dataProvider = "1")
    public void dataProviderLoginTest(String email, String sifre) throws IOException {
        //        Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));//HOME SAYFASINA
        blueRentalHomePage= new BlueCarRentHomePage();
        blueRentalLoginPage = new BlueCarRentLoginPage();
        blueRentalHomePage.homePageLoginButton.click();
        ReusableMethods.waitFor(1);// 1 saniye bekle
        blueRentalLoginPage.username.sendKeys(email);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.password.sendKeys(sifre);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.loginBtn.click();
        //            GIRIS YAPILDI
        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(blueRentalDashboard.userNameText);//ASSERTION
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("EkranGoruntusu");
        ReusableMethods.waitFor(1);
        blueRentalDashboard.userNameText.click();
        ReusableMethods.waitFor(1);
        blueRentalDashboard.logOutBtn.click();
        ReusableMethods.waitFor(1);
        blueRentalDashboard.logoutAcceptBtn.click();
    }





}
