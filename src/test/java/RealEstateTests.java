import org.example.AdFeatures;
import org.example.RealEstate;
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

public class RealEstateTests {
    @Test (groups = {"positive"})
    public void newAd() {
        RealEstate ad = new RealEstate("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG",
                AdFeatures.butaiNuomotis);
        ad.fillAd();
        ad.agreeTermsRealEstate();
        ad.submit();

    }

    @Test (groups = {"negative.phoNo"})
    public void adWithNoPhono() {
        RealEstate ad2 = new RealEstate("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "10000", "", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG",
                AdFeatures.butaiNuomotis);
        ad2.fillAd();
        ad2.agreeTermsRealEstate();
        ad2.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/span[2]"), "Neteisingas telefono numeris"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/span[2]")).getText(), "Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoPrice() {
        RealEstate ad3 = new RealEstate("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG",
                AdFeatures.butaiNuomotis);
        ad3.fillAd();
        ad3.agreeTermsRealEstate();
        ad3.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/span[3]"), "Neteisinga kaina"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/span[3]")).getText(), "Neteisinga kaina");
    }

    @Test
    public void adWithNoObjectType() {
        RealEstate ad4 = new RealEstate("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "20000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG",
                "");
        ad4.fillAd();
        ad4.agreeTermsRealEstate();
        ad4.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[2]"), "Pasirinkite veiksmą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[2]")).getText(), "Pasirinkite veiksmą");
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
