package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RealEstate extends Advertisement{
    private String objectType;

    public RealEstate(String city, String microdistrict, String street, String houseSize, String price, String phoNo, String photo, String objectType){
        super(city, microdistrict, street, houseSize, price,phoNo,photo);
        this.objectType = objectType;
    }

    public void fillAd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
        this.fillGenerics();
        fillObjectType();

    }

    public void fillObjectType(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/input[2]")).click();
        List<WebElement> liArr = Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul")).findElements(By.tagName("li"));
        for(WebElement li:liArr){
            if(li.getText().equals(this.objectType)){
                li.click();
                break;
            }
        }
    }



}
