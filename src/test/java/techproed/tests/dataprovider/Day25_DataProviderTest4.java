package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day25_DataProviderTest4 {
// bu ornekde Dp classi util class da olacak
    //  ozellikle pom de test siniflarinda sadece test caselerinin olmasi gerekir.


    @Test(dataProvider = "musteriVerileri", dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username, String password) {
        System.out.println(username + "---->" + password);


    }


    @Test(dataProvider = "musteriHizmetleriVerileri", dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileriTest(String username, String password) {
        System.out.println(username + "---->" + password);


    }
    @Test(dataProvider = "personelVerileri", dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTest(String username, String password) {
        System.out.println(username + "---->" + password);

    }


    @Test(dataProvider = "customerData", dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String username, String password) {
        System.out.println(username + "---->" + password);

    }

}
