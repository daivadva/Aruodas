import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HouseTests {

    @Test(priority = 1)
    public void deleteAdTest() {
        deleteAd();
    }


    @Test(priority = 0, groups = {"positive"} )
    public void newAd() {
        House ad = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad.fillAd();
        ad.submit();
    }

    @Test
    public void adWithNoHouseSize() {
        House ad2 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "", "200000", "+37061234567", "10", "2022", "2", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad2.fillAd();
        ad2.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3]"), "Įveskite bendrą plotą"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[13]/span[3]")).getText(), "Įveskite bendrą plotą");
    }

    @Test
    public void adWithNoPrice() {
        House ad3 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "", "+37061234567", "10", "2022", "2", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad3.fillAd();
        ad3.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[51]/span[3]"), "Neteisinga kaina"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[51]/span[3]")).getText(), "Neteisinga kaina");
    }

    @Test (groups = {"negative.phoNo"})
    public void adWithNoPhoNo() {
        House ad4 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "", "10", "2022", "2", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad4.fillAd();
        ad4.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[52]/span[2]"), "Neteisingas telefono numeris"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[52]/span[2]")).getText(), "Neteisingas telefono numeris");
    }

    @Test
    public void adWithNoFloors() {
        House ad5 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad5.fillAd();
        ad5.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/span"), "Įveskite aukštų sk."));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/span")).getText(), "Įveskite aukštų sk.");
    }

    @Test
    public void adWithNoBuildYear() {
        House ad6 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "", "2", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad6.fillAd();
        ad6.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[1]/span[2]"), "Įveskite statybos metus"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[1]/span[2]")).getText(), "Įveskite statybos metus");
    }

    @Test
    public void allHouseType() {
        House ad7 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2",
                new String[]{AdFeatures.gyvenamasisNamnas, AdFeatures.namoDalis, AdFeatures.sodoNamas, AdFeatures.sublokuotasNamas, AdFeatures.sodyba, AdFeatures.kitasNamas},
                new String[]{AdFeatures.skydinis},
                new String[]{AdFeatures.dalineApdaila},
                new String[]{AdFeatures.dujinis, AdFeatures.elektra},
                "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad7.fillAd();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[6]/div[2]"), "Kita (nukeliamas, projektas, kt.)"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[6]/div[2]")).getText(), "Kita (nukeliamas, projektas, kt.)");
        //lieka pazymetas paskutinis, šiuo atveju kita
    }

    @Test
    public void allBuildingType() {
        House ad8 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2",
                new String[]{AdFeatures.gyvenamasisNamnas},
                new String[]{AdFeatures.skydinis, AdFeatures.kita, AdFeatures.murinis, AdFeatures.blokinis, AdFeatures.monolitinis, AdFeatures.medinis, AdFeatures.karkasinis, AdFeatures.rastinis},
                new String[]{AdFeatures.dalineApdaila},
                new String[]{AdFeatures.dujinis, AdFeatures.elektra},
                "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad8.fillAd();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[6]/div[2]"), "Rąstinis"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[6]/div[2]")).getText(), "Rąstinis");
        //lieka pažymėtas paskutinis elementas, šiuo atveju Rąstinis
    }

    @Test
    public void allEquipment() {
        House ad9 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2",
                new String[]{AdFeatures.gyvenamasisNamnas},
                new String[]{AdFeatures.skydinis},
                new String[]{AdFeatures.dalineApdaila, AdFeatures.neirengtas, AdFeatures.nebaigtasStatyti, AdFeatures.pamatai, AdFeatures.kita, AdFeatures.irengtas},
                new String[]{AdFeatures.dujinis, AdFeatures.elektra},
                "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad9.fillAd();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[1]/div[2]"), "Įrengtas"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[1]/div[2]")).getText(), "Įrengtas");
        //lieka pažymėtas paskutinis elementas, šiuo atveju Įrengtas
    }

    @Test
    public void adWithNoCity() {
        House ad10 = new House("", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2",
                new String[]{AdFeatures.gyvenamasisNamnas},
                new String[]{AdFeatures.skydinis},
                new String[]{AdFeatures.dalineApdaila},
                new String[]{AdFeatures.dujinis, AdFeatures.elektra},
                "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad10.fillAd();
        ad10.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[2]"), "Pasirinkite savivaldybę"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[2]")).getText(), "Pasirinkite savivaldybę");
    }

    @Test
    public void adWithNoMicrodistrict() {
        House ad11 = new House("Klaipėda", "", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2",
                new String[]{AdFeatures.gyvenamasisNamnas},
                new String[]{AdFeatures.skydinis},
                new String[]{AdFeatures.dalineApdaila},
                new String[]{AdFeatures.dujinis, AdFeatures.elektra},
                "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad11.fillAd();
        ad11.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[2]"), "Pasirinkite mikrorajoną"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[2]")).getText(), "Pasirinkite mikrorajoną");
    }

    @Test
    public void adWithLetterFloor() {
        House ad12 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "a", new String[]{AdFeatures.sublokuotasNamas}, new String[]{AdFeatures.skydinis}, new String[]{AdFeatures.dalineApdaila}, new String[]{AdFeatures.dujinis, AdFeatures.elektra}, "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad12.fillAd();
        ad12.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/span"), "Įveskite aukštų sk."));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/span")).getText(), "Įveskite aukštų sk.");
    }

    @Test
    public void noHeatingSelected() {
        House ad13 = new House("Klaipėda", "Debrecenas", "Naujakiemio g.", "150", "200000", "+37061234567", "10", "2022", "2",
                new String[]{AdFeatures.gyvenamasisNamnas},
                new String[]{AdFeatures.skydinis},
                new String[]{AdFeatures.dalineApdaila},
                new String[]{},
                "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG");
        ad13.fillAd();
        ad13.submit();
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/label/span[2]"), "Privalomas"));
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/label/span[2]")).getText(), "Privalomas");
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
