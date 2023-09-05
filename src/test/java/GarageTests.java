import org.example.AdFeatures;
import org.example.Garage;
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

public class GarageTests {

    @Test
    public void newAd(){
        Garage ad = new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","20000", "+37061234567",
                new String[]{AdFeatures.vietaAutomobiliui},
                new String[]{AdFeatures.pozeminejeAiksteleje},
                "10","111122223333","4", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.agreeTermsGarage();
        ad.submit();
    }

    @Test
    public void newNoPrice(){
        Garage ad =new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","", "+37061234567",
                new String[]{AdFeatures.vietaAutomobiliui},
                new String[]{AdFeatures.pozeminejeAiksteleje},
                "10","111122223333","4", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.agreeTermsGarage();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[37]/span[3]"), "Neteisinga kaina"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[37]/span[3]")).getText(), "Neteisinga kaina");
    }

    @Test
    public void newNoPhoNo(){
        Garage ad =new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","20000", "",
                new String[]{AdFeatures.vietaAutomobiliui},
                new String[]{AdFeatures.pozeminejeAiksteleje},
                "10","111122223333","4", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.agreeTermsGarage();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[38]/span[2]"), "Neteisingas telefono numeris"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[38]/span[2]")).getText(), "Neteisingas telefono numeris");
    }

    @Test
    public void newNoTypeParking(){
        Garage ad =new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","20000", "+37061234567",
                new String[]{AdFeatures.vietaAutomobiliui},
                new String[]{},
                "10","111122223333","4", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.agreeTermsGarage();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/span"), "Pasirinkite parkingo tipą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/span")).getText(), "Pasirinkite parkingo tipą");
    }

    @Test
    public void newNoTypeGarage(){
        Garage ad =new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","20000", "+37061234567",
                new String[]{AdFeatures.garazas},
                new String[]{},
                "10","111122223333","4", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.agreeTermsGarage();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/span"), "Pasirinkite tipą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/span")).getText(), "Pasirinkite tipą");
    }

    @Test
    public void newNoAccomodates(){
        Garage ad =new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","20000", "+37061234567",
                new String[]{AdFeatures.garazas},
                new String[]{AdFeatures.murinis},
                "10","111122223333","", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.agreeTermsGarage();
        ad.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/span"), "Įveskite garažo talpą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/span")).getText(), "Įveskite garažo talpą");
    }

    @Test
    public void newTypes(){
        Garage ad =new Garage("Klaipėda", "Debrecenas", "Naujakiemio g.", "200","20000", "+37061234567",
                new String[]{AdFeatures.vietaAutomobiliui},
                new String[]{AdFeatures.antzeminejeAiksteleje},
                "10","111122223333","4", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[2]/div[2]"), "Antžeminėje aikštelėje"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[2]/div[2]")).getText(), "Antžeminėje aikštelėje");
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

}

