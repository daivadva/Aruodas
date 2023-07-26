import org.example.AdFeatures;
import org.example.Land;
import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandTest {

    @Test (priority = 1)
    public void deleteAdTest(){
        deleteAd();
    }


    @Test (priority = 0)
    public void newAdd() {
        Land ad = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "10","10000", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad.fillAdd();
    }

    @Test
    public void adWithNoArea() throws InterruptedException {
        Land ad2 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "10000", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad2.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3]")).getText(),"Įveskite bendrą plotą");
    }

    @Test
    public void adWithNoPrice() throws InterruptedException {
        Land ad3 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "10", "", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad3.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[33]/span[3]")).getText(), "Neteisinga kaina");
    }

    @Test
    public void adWithNoPhoNo() throws InterruptedException {
        Land ad4 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "10", "10000", "", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad4.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[34]/span[2]")).getText(),"Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoPurpose() throws InterruptedException {
        Land ad5 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "10", "10000", "+37061234567", new String[]{});
        ad5.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/label/span[2]")).getText(),"Pasirinkite paskirtį");
    }

   @Test
    public void adWithLetterPhoNo() throws InterruptedException {
        Land ad6 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "10", "10000", "abcdef", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad6.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[34]/span[2]")).getText(),"Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoCity() throws InterruptedException {
        Land ad7 = new Land("", "Debrecenas", "Naujakiemio g.", "", "10000", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad7.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[2]")).getText(), "Pasirinkite savivaldybę");
    }

    @Test
    public void adLettersInArea() throws InterruptedException {
        Land ad8 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "abc", "10000", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad8.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3]")).getText(),"Įveskite bendrą plotą");
    }

    @Test
    public void adNegativePrice() throws InterruptedException {
        Land ad9 = new Land("Klaipėda", "Debrecenas", "Naujakiemio g.", "10", "abcd", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
        ad9.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[33]/span[3]")).getText(), "Neteisinga kaina");
    }

//    @Test
//    public void adWithNoMicrodistrict() throws InterruptedException {
//        Land ad8 = new Land("Klaipėda", "", "Naujakiemio g.", "", "10000", "+37061234567", new String[]{AdFeatures.miskuUkio, AdFeatures.namuValda});
//        ad8.fillAdd();
//  //      Thread.sleep(2000);
//   //     Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[2]")).getText(), "Pasirinkite savivaldybę");
//    }
    //pasirinkus city, mikrorajonas nėra privalomas Land dalyje

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
