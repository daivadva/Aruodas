import org.example.AdFeatures;
import org.example.ShortTerm;
import org.example.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShortTermTests {

    @Test
    public void newAd(){
        ShortTerm ad = new ShortTerm("Klaipėda", "Debrecenas", "Naujakiemio g.", "150","25000","+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG",
                new String[]{AdFeatures.sodybos});
        ad.fillAd();
        ad.submit();
    }

    @Test
    public void adWithNoPrice(){
        ShortTerm ad = new ShortTerm("Klaipėda", "Debrecenas", "Naujakiemio g.", "150","","+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG",
        new String[]{AdFeatures.sodybos});
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
