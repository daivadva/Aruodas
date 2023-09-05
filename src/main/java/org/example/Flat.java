package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Flat extends Advertisement {
    private String roomNumber;
    private String floorMin;
    private String floorMax;

    public Flat(String city, String microdistrict, String street, String houseSize, String price, String phoNo, String photo, String roomNumber, String floorMin, String floorMax) {
        super(city, microdistrict, street, houseSize, price, phoNo, photo);
        this.roomNumber=roomNumber;
        this.floorMin=floorMin;
        this.floorMax=floorMax;
    }

    public void fillAd(){
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=1");
        this.fillGenerics();
        fillRoomNumber();
        fillFloorMin();
        fillFloorMax();
    }

    public void fillRoomNumber(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[15]/div/span/input")).sendKeys(this.roomNumber);
    }

    public void fillFloorMin(){
            Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[1]/span[2]/input")).sendKeys(this.floorMin);
    }
    public void fillFloorMax(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[2]/span[1]/input")).sendKeys(this.floorMax);
    }
}
