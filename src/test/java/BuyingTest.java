import jdk.jshell.execution.Util;
import org.example.AdFeatures;
import org.example.Buying;
import org.example.Land;
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

public class BuyingTest {
    @Test
    public void newAd() {
        Buying ad = new Buying("Klaipėda", "Debrecenas", "Naujakiemio g.", "","10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/input[2]")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[4]")).click();
        submit();

    }

    @Test
    public void adWithNoPhono() {
        Buying ad = new Buying("Klaipėda", "Debrecenas", "Naujakiemio g.", "","10000", "", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/input[2]")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[4]")).click();
        submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/span[2]"),"Neteisingas telefono numeris"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/span[2]")).getText(), "Neteisingas telefono numeris");
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
