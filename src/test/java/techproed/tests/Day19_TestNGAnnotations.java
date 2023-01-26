package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotations {

    /*
    @Test : Test case olusturmak icin kullanilir.
    @Befor ve @After :5 before ve 5 after Anotations var.
    suite > tests > group > class > method
    @BeforeSuite :her bir test suite den once 1 sefer cagrılır.
    @AfterSuite :her bir test suite den sonra 1 sefer cagrılır.
    @BeforeTest : Her bir Test'den once(TEST CASE ILE KARISTIRILMAMALI) 1 sefer calisir.==>mesela icnde bulundugum projeye.
    @AfterTest : Her bir Test'den sonra(TEST CASE ILE KARISTIRILMAMALI) icin 1 sefer calisir==>mesela icnde bulundugum projeye.
    @BeforeClass : Her bir class'dan once 1 sefer calisir
    @AfterClass : Her bir class'dan sonra 1 sefer calisir
    @BeforeMethod : her bir @Test annotationdan once tek sefer calisir. JUnitdeki karsiligi sadece @Before
    @AfterMethod : her bir @Test annotationdan sonra tek sefer calisir. JUnitdeki karsiligi sadece @After
    -----------------------------------------------------------------------------------------------------------------
    @Ignore : @Test caseleri atlamak(skip,ignore) icin kullanilir
    @Test(enabled = false) : @Test caseleri kullanima kapatmak icin kullanilir
    ---------------------------------------------------------------------------------------------
    TestNG de test case ler isim sirasina gore calisir
    @Test(priority = 1) : Test caseler oncelemek icin kullnalir
    -----------------------------------------------------------------------------------------------------------------
    NOT: default priority nin degeri 0 (sıfıra) esittir.@Test(priority = 0)

     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }


    @Test(priority = 1)
    public void test7() {
        System.out.println("Test 1");
    }

    @Test
    @Ignore
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Test 4");

    }

    @Test(priority = 2)
    public void test5() {
        System.out.println("Test 5");

    }

    @Test(priority = -5)
    public void test6() {
        System.out.println("Test 6");

    }
}
//  test 6 >test 7> test 5 > test 4