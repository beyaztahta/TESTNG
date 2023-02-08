package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueCarRentHomePage;
import techproed.pages.BlueCarRentLoginPage;
import techproed.pages.BlueCarRentalDashboard;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    @Test
    public void customerLoginTest() {

        BlueCarRentLoginPage loginPageObj = new BlueCarRentLoginPage();
        BlueCarRentHomePage homeObj = new BlueCarRentHomePage();
        BlueCarRentalDashboard dashboardObj = new BlueCarRentalDashboard();

        Driver.getDriver().get(ConfigReader.getProperty("blueRental_url"));
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");
        List<Map<String, String>> dataList = excelUtils.getDataList();

        for (int i = 0; i < dataList.size(); i++) {
            homeObj.homePageLoginButton.click();
            loginPageObj.username.sendKeys(dataList.get(i).get("username"));
            loginPageObj.password.sendKeys(dataList.get(i).get("password"));
            loginPageObj.loginBtn.click();
            ReusableMethods.verifyElementDisplayed(dashboardObj.userNameText);
            ReusableMethods.getScreenshot("login-smoke-test");
            dashboardObj.userNameText.click();
            dashboardObj.logOutBtn.click();
            ReusableMethods.waitFor(1);
            dashboardObj.logoutAcceptBtn.click();
        }

        Driver.closeDriver();

    }

/*
sam.walker@bluerentalcars.com   c!fas_art
kate.brown@bluerentalcars.com   tad1$Fas
raj.khan@bluerentalcars.com v7Hg_va^
pam.raymond@bluerentalcars.com  Nga^g6!
------ILK GIRIS---------
HOME PAGE DEYIZ
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
------2. GIRIS-----
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
------3. GIRIS---------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
---------4. GIRIS------------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
 */

}
