import org.example.AruodasLandAd;
import org.example.Purpose;
import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AruodasTests {

    @Test
    public void newAdd() {
        AruodasLandAd ad = new AruodasLandAd("Klaipėda", "+37061234567", "10", "10000", new String[]{Purpose.miskuUkio, Purpose.namuValda});
        ad.fillAdd();
    }

//    @Test
//    public void newAdd2(){
//        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=13&offer_type=1");
//
//    }


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
