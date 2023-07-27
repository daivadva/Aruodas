package org.example;

import org.openqa.selenium.By;

public class Buying extends Advertisement{
    private String objectType;

    public Buying(String city, String microdistrict, String street, String houseSize, String price, String phoNo, String photo){
        super(city, microdistrict, street, houseSize, price,phoNo,photo);
        this.objectType = objectType;
    }

    public void fillAd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        this.fillGenerics();

    }

    public void fillObjectType(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/span")).click();
    }




}
