package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    //Page objectlerini bu sınıfta buluruz.

    //1.ADIM CONSTRUCTOR OLUSTUR.HER PAGE BIR CONSTRUCTOR ILE BASLAMAK ZORUNDAve HER CLASSTA BUNU YAPMAMIZ GEREKIYOR.

    public OpenSourcePage() {
        // PageFactory seleniımdan gelen ve bu sayfa elementlerini instantie(baslangic degeri vermek) etmek icin kullanilir.
        //Sayfa objeleri cagrıldıgında NullPointerException alinmaz.
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Page objelerini olustur.
    //    GELENEKSEL  : public WebElement username = Driver.getDriver().findElement(By.name("username"));

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


}
