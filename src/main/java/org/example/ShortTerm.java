package org.example;

import org.openqa.selenium.By;

public class ShortTerm extends Advertisement{
    private String[] type;

    public ShortTerm (String city, String microdistrict, String street, String area, String price, String phoNo, String photo, String[] type) {
        super(city, microdistrict, street, area, price, phoNo, photo);
        this.type=type;
    }

    public void fillAd(){
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=12");
        fillGenerics();
    }

    public void fillType() {
        for (int i = 0; i < type.length; i++) {
            switch (type[i]) {
                case "Butai":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[12]/div/div[1]/div[2]")).click();
                    break;
                case "Kambariai":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[12]/div/div[2]/div[2]")).click();
                    break;
                case "Sodybos":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[12]/div/div[3]/div[2]")).click();
                    break;
                case "Pokylių salės":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[12]/div/div[4]/div[2]")).click();
                    break;
                case "Konferencijų salė":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[12]/div/div[5]/div[2]")).click();
                    break;
            }
        }

    }
}
