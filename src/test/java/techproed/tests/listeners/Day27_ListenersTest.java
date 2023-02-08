package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;


@Listeners(techproed.utilities.Listeners.class)
public class Day27_ListenersTest {

    @Test
    public void test1() {
        System.out.println("pass");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("fail");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("skip");
        throw new SkipException("Methodu skip etmeyi saglar");
    }

    @Test
    public void test4() {
        System.out.println("Execption");
        //   throw  new NoSuchElementException("No such element exeption");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));

    }


}
