package techproed.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

    @Test
    public void openSourceLogin() {
//   1.Adım    sayfaya git.
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

//   2.Adım    Page objesi olustur.
        OpenSourcePage page = new OpenSourcePage();

//   3.Adım    Bu objeyi kullanarak o classtaki objelere ulas.
        page.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        page.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        page.submitButton.click();


//   4.Assertion
        OpenSourceDashboardPage openSourceDashboardPage=new OpenSourceDashboardPage();

        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

//   5.Close driver.
        Driver.closeDriver();

    }
}
