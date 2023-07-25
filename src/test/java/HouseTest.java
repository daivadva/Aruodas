import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HouseTest {

    //    @Test (priority = 1)
//    public void deleteAdTest(){
//        deleteAd();
//    }
//
//
    @Test(priority = 0)
    public void newAdd() {
        House ad = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2", new String[]{HouseFeatures.sublokuotasNamas}, new String[]{HouseFeatures.skydinis}, new String[]{HouseFeatures.dalineApdaila}, new String[]{HouseFeatures.dujinis, HouseFeatures.elektra});
        ad.fillAdd();
    }

    @Test
    public void adWithNoHouseSize() throws InterruptedException {
        House ad2 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "200000", "+37061234567", "10", "2022", "2", new String[]{HouseFeatures.sublokuotasNamas}, new String[]{HouseFeatures.skydinis}, new String[]{HouseFeatures.dalineApdaila}, new String[]{HouseFeatures.dujinis, HouseFeatures.elektra});
        ad2.fillAdd();
        //  Utils.wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3")));
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3]")).getText(), "Įveskite bendrą plotą");
    }

    @Test
    public void adWithNoPrice() throws InterruptedException {
        House ad3 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "", "+37061234567", "10", "2022", "2", new String[]{HouseFeatures.sublokuotasNamas}, new String[]{HouseFeatures.skydinis}, new String[]{HouseFeatures.dalineApdaila}, new String[]{HouseFeatures.dujinis, HouseFeatures.elektra});
        ad3.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[51]/span[3]")).getText(), "Neteisinga kaina");
    }

    @Test
    public void adWithNoPhoNo() throws InterruptedException {
        House ad4 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "", "10", "2022", "2", new String[]{HouseFeatures.sublokuotasNamas}, new String[]{HouseFeatures.skydinis}, new String[]{HouseFeatures.dalineApdaila}, new String[]{HouseFeatures.dujinis, HouseFeatures.elektra});
        ad4.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[52]/span[2]")).getText(),"Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoFloors() throws InterruptedException {
        House ad5 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "", new String[]{HouseFeatures.sublokuotasNamas}, new String[]{HouseFeatures.skydinis}, new String[]{HouseFeatures.dalineApdaila}, new String[]{HouseFeatures.dujinis, HouseFeatures.elektra});
        ad5.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/span")).getText(),"Įveskite aukštų sk.");
    }

   @Test
    public void adWithNoBuildYear() throws InterruptedException {
        House ad6 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "", "2", new String[]{HouseFeatures.sublokuotasNamas}, new String[]{HouseFeatures.skydinis}, new String[]{HouseFeatures.dalineApdaila}, new String[]{HouseFeatures.dujinis, HouseFeatures.elektra});
        ad6.fillAdd();
        Thread.sleep(2000);
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[1]/span[2]")).getText(),"Įveskite statybos metus");
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
