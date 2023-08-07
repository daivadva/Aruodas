import org.example.AdFeatures;
import org.example.Garage;
import org.example.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        ad.submit();
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

