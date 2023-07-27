package org.example;

import org.openqa.selenium.By;

public class Premises extends Advertisement{
    private String floor;
    private String[] buildingType;
    private String[] purposes;


    public Premises(String city, String microdistrict, String street, String area, String price, String phoNo, String photo, String floor, String[] buildingType, String[] purposes){
        super(city, microdistrict, street, area, price,phoNo,photo);
        this.floor = floor;
        this.buildingType = buildingType;
        this.purposes = purposes;
    }

    public void fillAd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=3");
        this.fillGenerics();
        fillFloor();
        fillEquipment();
        fillPurposes();
    }

    public void fillFloor(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/span[2]/input")).sendKeys(this.floor);
    }

    public void fillEquipment(){
        for (int i = 0; i < buildingType.length; i++) {
            switch (buildingType[i]) {
                case "Įrengtas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[1]/div[2]")).click();
                    break;
                case "Dalinė apdaila":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[2]/div[2]")).click();
                    break;
                case "Neįrengtas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[3]/div[2]")).click();
                    break;
                case "Nebaigtas statyti":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[4]/div[2]")).click();
                    break;
                case "Pamatai":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[5]/div[2]")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[6]/div[2]")).click();
                    break;
            }
        }
    }

    public void fillPurposes(){
        for (int i = 0; i < purposes.length; i++) {
            switch (purposes[i]) {
                case "Administracinė":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[1]/label")).click();
                    break;
                case "Prekybos":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[2]/label")).click();
                    break;
                case "Viešbučių":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[3]/label")).click();
                    break;
                case "Paslaugų":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[4]/label")).click();
                    break;
                case "Sandėliavimo":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[5]/label")).click();
                    break;
                case "Gamybos ir pramonės":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[6]/label")).click();
                    break;
                case "Maitinimo":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[7]/label")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[20]/div/div[8]/label")).click();
                    break;
            }
        }
    }
}
