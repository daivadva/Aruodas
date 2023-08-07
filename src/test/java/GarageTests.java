import org.example.Garage;
import org.testng.annotations.Test;

public class GarageTests {

    @Test
    public void newAd(){
        Garage ad = new Garage("Klaipėda", "Debrecenas", "Naujakiemio")
    }
}
