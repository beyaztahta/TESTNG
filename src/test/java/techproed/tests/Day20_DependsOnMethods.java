package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMethods {

    //Bir methodu diger methoda baglamak icin kullanılır. Aynı class icindeki methodlarda gecerlidir.


    @Test
    public void homeTest() {
        System.out.println("Home test ");
        // Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "homeTest")
    public void searchTest() {
        System.out.println("Search test");

    }//searchTest methodunu homePageTest e bagladık.Sadece search methodunucalıstırdıgımızda once home sonra search calıstı
    // sebebi bagımlı olması.
    //Sadece search methodunu calıstırdıgımızda simdi false ekledigimiz icin fail oldu ve search test calısmadı.


    @Test(dependsOnMethods = "homeTest")
    public void paymentTest() {
        System.out.println("Payment test");
    }

    /* testcaseleri bagımlım hale getirmek:

    TestNG de tum test methodları birbirlerinden bagımsız olarak calısırlar.
    Eger methodları bagımlı hale getirmek istersek dependsOnMethods parametresi kullanılır. @Test(dependsOnMethods = "homeTest")
    Yukarıdaki ornekte searchtest methodunu homeTest methoduna bagımlı hale getirdim .searchTest den once homeTest calısır.Eger homeTest basarılı ise
    searchTest valısır.Eger homeTest basarısız ise searchTest IGNORE edilir.
     */

}
