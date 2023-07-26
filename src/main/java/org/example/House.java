package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class House extends Advertisement{
    private String landArea;
    private String buildYear;
    private String floors;
    private String[] buildingType;
    private String[] houseType;
    private String[] equipment;
    private String[] heating;


    public House(String city, String microdistrict, String street, String houseSize, String price, String phoNo, String landArea, String buildYear, String floors, String[] buildingType, String[] houseType, String equipment[], String[] heating){
        super(city, microdistrict, street, houseSize, price,phoNo);
        this.landArea = landArea;
        this.buildYear = buildYear;
        this.floors = floors;
        this.buildingType = buildingType;
        this.houseType = houseType;
        this.equipment = equipment;
        this.heating = heating;
    }

    public void fillAdd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=2&offer_type=1");
        this.fillGenerics();
        fillLandArea();
        fillBuildYear();
        fillFloors();
        fillbuildingType();
        fillHouseType();
        fillEquipment();
        selectHeating();
      //  submit();
    }
    public void fillLandArea(){
        Utils.driver.findElement(By.id("fieldFAreaLot")).sendKeys(this.landArea);
    }
    public void fillBuildYear(){
        Utils.driver.findElement(By.name("FBuildYear")).sendKeys(this.buildYear);
    }

    public void fillFloors(){
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/div/span/input")).sendKeys(this.floors);
    }
    public void fillbuildingType(){
        for (int i = 0; i < buildingType.length; i++) {
            switch (buildingType[i]) {
                case "Namas (gyvenamasis)":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[1]/div[2]")).click();
                    break;
                case "Namo dalis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[2]/div[2]")).click();
                    break;
                case "Sodo namas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[3]/div[2]")).click();
                    break;
                case "Sublokuotas namas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[4]/div[2]")).click();
                    break;
                case "Sodyba":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[5]/div[2]")).click();
                    break;
                case "Kita (nukeliamas, projektas, kt.)":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div/div[6]/div[2]")).click();
                    break;
            }
        }
    }

    public void fillHouseType(){
        for (int i = 0; i < houseType.length; i++) {
            switch (houseType[i]) {
                case "Mūrinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[1]/div[2]")).click();
                    break;
                case "Blokinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[2]/div[2]")).click();
                    break;
                case "Monolitinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[3]/div[2]")).click();
                    break;
                case "Medinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[4]/div[2]")).click();
                    break;
                case "Karkasinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[5]/div[2]")).click();
                    break;
                case "Rąstinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[6]/div[2]")).click();
                    break;
                case "Skydinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[7]/div[2]")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[8]/div[2]")).click();
                    break;
            }
        }
    }

    public void fillEquipment(){
        for (int i = 0; i < equipment.length; i++) {
            switch (equipment[i]) {
                case "Įrengtas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[1]/div[2]")).click();
                    break;
                case "Dalinė apdaila":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[2]/div[2]")).click();
                    break;
                case "Neįrengtas":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[3]/div[2]")).click();
                    break;
                case "Nebaigtas statyti":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[4]/div[2]")).click();
                    break;
                case "Pamatai":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[5]/div[2]")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[6]/div[2]")).click();
                    break;
            }
        }
    }

    public void selectHeating() {
        for (int i = 0; i < heating.length; i++) {
            switch (heating[i]) {
                case "Centrinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[1]/label")).click();
                    break;
                case "Elektra":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[2]/label")).click();
                    break;
                case "Skystu kuru":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[3]/label")).click();
                    break;
                case "Centrinis kolektorinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[4]/label")).click();
                    break;
                case "Geoterminis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[5]/label")).click();
                    break;
                case "Aeroterminis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[6]/label")).click();
                    break;
                case "Dujinis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[7]/label")).click();
                    break;
                case "Kietu kuru":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[8]/label")).click();
                    break;
                case "Saulės energija":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[9]/label")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[10]/label")).click();
                    break;
            }
        }
    }



}
