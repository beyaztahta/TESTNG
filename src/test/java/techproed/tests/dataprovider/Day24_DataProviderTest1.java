package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day24_DataProviderTest1 {
    /**
     * Data Provider nedir?
      - Veri deposudur.
      - Coklu verileri loop kullanmadan test caselere aktarmak icin kullanilir.
      - Data provider 2 boyutlu(2D) object return eder.
      - Data provider TestNg'den gelen bir ozelliktir.
     Data Provider ne icin kullanilir?
      - DDT(Data Driven Testgin) icin kullanilir.
      - Birden fazla datayi test caselerde kullanmak icin kullanilir.
     Data Provider'i nasil kullanirsin?
      - @DataProvider ile veri havuzu olusturulur.
      - @Test methodlarina bu data havuzu baglanir.
      - (dataProvider = "methodismi") ile baglanilir.
      - 2 tane paramete vardir
       ** name ---> farkli bir isim ile data provider'i cagirmak icin kullanilir.
       ** parallel  ---> paralel test caseler olusturmak icin kullanilir.
     */

    //     DATA PROVİDER--sadece data depolanir.
    @DataProvider(name = "smoke_test_data")
    public Object[][] urunler() {
        Object urunlistesi[][] = {
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"toyota"},
                {"volvo"}
        };
        return urunlistesi;
    }

//                TEST METHODU

    @Test(dataProvider = "smoke_test_data")  // name atamassak urunler
    public void aramaTesti(String data) {

        System.out.println( data);

    }
    @Test(dataProvider = "smoke_test_data")
    public void googleAramasi(String araclar) {
        try {
            Driver.getDriver().get("https://www.google.com");
            Driver.getDriver().findElement(By.name("q")).sendKeys(araclar+ Keys.ENTER);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
            Driver.closeDriver();
        }catch (Exception e) {
            
        }

    }
    //    TEST METOTU
    @Test(dataProvider = "urunler")
    public void aramaTesti1(String data){
        System.out.println(data);
    }

    //    GOOELE ARAMASI
    @Test(dataProvider = "urunler")
    public void googleAramasi1(String araclar){
//        google a git
        Driver.getDriver().get("https://www.google.com");

//        araclari arama kutusuna gir ve Enter a bas
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar+ Keys.ENTER);
//        sayfa title inin aradigim kelimeyi icerdigini assert et
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
//        driver i kapat
        Driver.closeDriver();
    }

}
