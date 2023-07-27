import org.example.AdFeatures;
import org.example.Premises;
import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PremisesTest {

    @Test
    public void newAdd(){
        Premises ad = new Premises("Klaipėda", "Debrecenas", "Naujakiemio g.", "10","10000", "+37061234567", "C:\\Users\\Daiva\\Desktop\\DSC_0867.JPG", "5",
                new String[]{AdFeatures.pamatai},
                new String[]{AdFeatures.maitinimo,AdFeatures.paslaugu});
        ad.fillAdd();
        submit();

    }

    public void submit() {
        Utils.driver.findElement(By.id("submitFormButton")).click();
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
