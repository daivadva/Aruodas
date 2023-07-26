package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Land extends Advertisement{

    private String[] purposes;

    public Land(String city, String microdistrict, String street, String area, String price, String phoNo, String[] purposes){
        super(city, microdistrict, street, area, price, phoNo) ;
        this.purposes = purposes;

    }

    public void fillAdd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        this.fillGenerics();
        this.selectPurpose();
        submit();

    }

    public void selectPurpose() {
        for (int i = 0; i < purposes.length; i++) {
            switch (purposes[i]) {
                case "Namų valda":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[1]/label")).click();
                    break;
                case "Daugiabučių statyba":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[2]/label")).click();
                    break;
                case "Žemės ūkio":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[3]/label")).click();
                    break;
                case "Sklypas soduose":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[4]/label")).click();
                    break;
                case "Miškų ūkio":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[5]/label")).click();
                    break;
                case "Pramonės":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[6]/label")).click();
                    break;
                case "Sandėliavimo":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[7]/label")).click();
                    break;
                case "Komercinė":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[8]/label")).click();
                    break;
                case "Rekreacinė":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[9]/label")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[10]/label")).click();
                    break;
            }
        }
    }
}
