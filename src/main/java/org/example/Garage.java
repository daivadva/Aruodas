package org.example;

import org.openqa.selenium.By;

public class Garage extends Advertisement {

    private String[] purpose;
    private String number;
    private String rcNumber;
    private String []garageType;
    private String accomodates;

    public Garage(String city, String microdistrict, String street, String area, String price, String phoNo, String photo, String[] purpose, String []garageType, String number, String rcNumber,String accomodates) {
        super(city, microdistrict, street, area, price, phoNo, photo);
        this.purpose = purpose;
        this.number = number;
        this.rcNumber = rcNumber;
        this.garageType = garageType;
        this.accomodates = accomodates;
    }

    public void fillAd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=13&offer_type=1");
        this.fillGenerics();
        fillPurpose();
        fillNumber();
        fillRCNumber();
        fillGarageType();
        fillAccomodates();
    }

    public void fillPurpose() {
        for (int i = 0; i < purpose.length; i++) {
            switch (purpose[i]) {
                case "Garažas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/div[1]/div/label")).click();
                    break;
                case "Vieta automobiliui":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/div[2]/div/label")).click();
                    break;
            }
        }
    }

    public void fillNumber(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[8]/span[1]/input")).sendKeys(this.number);
    }

    public void fillRCNumber(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[12]/div[1]/input")).sendKeys(this.rcNumber);
    }

    public void fillGarageType(){
        for (int i = 0; i < garageType.length; i++) {
            switch (garageType[i]){
                case "Mūrinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[1]/div[2]")).click();
                    break;
                case "Geležinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[2]/div[2]")).click();
                    break;
                case "Požeminis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[3]/div[2]")).click();
                    break;
                case "Daugiaaukštis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[4]/div[2]")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[5]/div[2]")).click();
                    break;
            }

        }
    }

    public void fillAccomodates (){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/span/input")).sendKeys(this.accomodates);
    }
}