package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;

public class Day20_SoftAssertion {



    @Test
    public void softAssertTest() {

        //1.ADIM SOFTASSERT OBJESI OLUSTUR.

        SoftAssert softAssert=new SoftAssert();

        System.out.println("Row 19");
        softAssert.assertEquals(2,5);//FAIL

        System.out.println("Row 21");
        softAssert.assertTrue("JAVA".contains("u"));//FAIL

        System.out.println("Row 23");
        softAssert.assertTrue(true);//PASS

        System.out.println("Row 29");
        softAssert.assertAll();//PASS yada FAIL olarak assertion ları isaretler.


        //Testcase kalsa bile calısmaya devam eder.
        // assertAll() methodu kullanımak zorundadır.
        //Objeyi olustur.

    }
}
