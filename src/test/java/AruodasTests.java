import org.example.AruodasAd;
import org.example.Purpose;
import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class AruodasTests {

    @Test (priority = 1)
    public void deleteAdTest(){
        deleteAd();
    }


    @Test (priority = 0)
    public void newAdd() {
        AruodasAd ad = new AruodasAd("Kaunas", "", "Aleksotas", "Aido g.", "10", "111122223333", "+37061234567", "10", "10000", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "Sklypas");
        ad.fillAdd();
    }

    @Test
    public void adWithNoArea() throws InterruptedException {
        AruodasAd ad2 = new AruodasAd("Klaipėda","", "Debrecenas", "Naujakiemio g.", "10", "111122223333", "+37061234567", "", "10000", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "Sklypas");
        ad2.fillAdd();
      //  Utils.wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3")));
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3]")).getText(),"Įveskite bendrą plotą");
    }

    @Test
    public void adWithNoPrice() throws InterruptedException {
        AruodasAd ad3 = new AruodasAd("Klaipėda","", "Debrecenas", "Naujakiemio g.", "10", "111122223333", "+37061234567", "10", "", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "Sklypas");
        ad3.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[33]/span[3]")).getText(), "Neteisinga kaina");
    }

    @Test
    public void adWithNoPhoNo() throws InterruptedException {
        AruodasAd ad4 = new AruodasAd("Kaunas", "", "Aleksotas", "Aido g.", "10", "111122223333", "", "10", "10000", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "Sklypas");
        ad4.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[34]/span[2]")).getText(),"Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoPurpose() throws InterruptedException {
        AruodasAd ad5 = new AruodasAd("Kaunas", "", "Aleksotas", "Aido g.", "10", "111122223333", "+37061234567", "10", "10000", new String[]{}, "Sklypas");
        ad5.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/label/span[2]")).getText(),"Pasirinkite paskirtį");
    }
   @Test
    public void adWithLetterPhoNo() throws InterruptedException {
        AruodasAd ad6 = new AruodasAd("Kaunas", "", "Aleksotas", "Aido g.", "10", "111122223333", "abcdefg", "10", "10000", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "Sklypas");
        ad6.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[34]/span[2]")).getText(),"Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoCity(){
        AruodasAd ad7 = new AruodasAd(" ","", " ", "Naujakiemio g.", "10", "111122223333", "+37061234567", "10", "10000", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "Sklypas");
        ad7.fillAdd();
    }

    @BeforeClass
    public void beforeClass() {
        Utils.driver = new ChromeDriver();
        Utils.driver.manage().window().maximize();
        Utils.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Utils.wait = new WebDriverWait(Utils.driver, Duration.ofSeconds(5));
        Utils.acceptCookies();
        Utils.logIn();
    }

    @AfterClass
    public void afterClass() {
        //    driver.quit();
    }
        public void deleteAd() {
            Utils.driver.get("https://www.aruodas.lt/mano-aruodas/");
            Utils.driver.findElement(By.id("deleteActionButton")).click();
            Utils.driver.findElement(By.xpath("/html/body/div[9]/div/div[10]/div/div/form/label[2]")).click();
            Utils.driver.findElement(By.xpath("/html/body/div[9]/div/div[10]/div/div/form/p/button")).click();
        }
}
