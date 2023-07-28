import org.example.AdFeatures;
import org.example.Premises;
import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PremisesTests {

    @Test
    public void newAd() {
        Premises ad = new Premises("Klaipėda", "Debrecenas", "Naujakiemio g.", "10", "10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG", "5",
                new String[]{AdFeatures.pamatai},
                new String[]{AdFeatures.maitinimo, AdFeatures.paslaugu});
        ad.fillAd();
        ad.submit();
    }

    @Test
    public void newNoArea() {
        Premises ad = new Premises("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG", "5",
                new String[]{AdFeatures.pamatai},
                new String[]{AdFeatures.maitinimo, AdFeatures.paslaugu});
        ad.fillAd();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[15]/span[4]"), "Įveskite bendrą plotą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[15]/span[4]")).getText(), "Įveskite bendrą plotą");
    }

    @Test
    public void newNoFloor() {
        Premises ad = new Premises("Klaipėda", "Debrecenas", "Naujakiemio g.", "100", "10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG", "",
                new String[]{AdFeatures.pamatai},
                new String[]{AdFeatures.maitinimo, AdFeatures.paslaugu});
        ad.fillAd();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/span[4]"), "Įveskite aukštą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/span[4]")).getText(), "Įveskite aukštą");
    }

    @Test
    public void newAdWithAllEquipment() {
        Premises ad = new Premises("Klaipėda", "Debrecenas", "Naujakiemio g.", "100", "10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG", "5",
                new String[]{AdFeatures.irengtas, AdFeatures.dalineApdaila, AdFeatures.neirengtas, AdFeatures.nebaigtasStatyti, AdFeatures.kita, AdFeatures.pamatai},
                new String[]{AdFeatures.maitinimo, AdFeatures.paslaugu});
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[5]/div[2]")).getText(), "Pamatai");
    }

    @Test
    public void newAdWithNoEquipment() {
        Premises ad = new Premises("Klaipėda", "Debrecenas", "Naujakiemio g.", "100", "10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG", "5",
                new String[]{},
                new String[]{AdFeatures.maitinimo, AdFeatures.paslaugu});
        ad.fillAd();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/span"), "Pasirinkite įrengimą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/span")).getText(), "Pasirinkite įrengimą");
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

    public void submit() {
        Utils.driver.findElement(By.id("submitFormButton")).click();
    }
}
