package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.pages.BlueCarRentalDashboard;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day24_ExcelLogin2 {
    BlueCarRentalDashboard blueRentalDashboard;
    BlueCarRentLoginPage blueRentalLoginPage;
    BlueCarRentHomePage blueRentalHomePage;

    //    Bu metot login sayfasina gitmek icin kullanililacak
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    @Test
    public void customerLogin() throws IOException {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        excelUtils = new ExcelUtils(path, sayfa);
        excelDatalari = excelUtils.getDataList();
//        home page logine tikla
        for (Map<String, String> data : excelDatalari) {
            //        Sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
            blueRentalDashboard= new BlueCarRentalDashboard();
            blueRentalLoginPage = new BlueCarRentLoginPage();
            blueRentalHomePage=new BlueCarRentHomePage();
            blueRentalHomePage.homePageLoginButton.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
            ReusableMethods.waitFor(1);
            blueRentalLoginPage. username.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.password.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginBtn.click();
            ReusableMethods.waitFor(1);
            blueRentalDashboard.userNameText.click();
            ReusableMethods.waitFor(1);
            blueRentalDashboard.logOutBtn.click();
            ReusableMethods.waitFor(1);
            blueRentalDashboard.logoutAcceptBtn.click();
            //-----cıkıs isleminin basarili oldugunu gostermek icin assertion yağtik
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.homePageLoginButton);
            //----her giristen sorna ekran goruntusu aldik.
            ReusableMethods.getScreenshot("EkranGoruntusu");
        }
        Driver.closeDriver();
    }
}