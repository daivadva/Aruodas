package org.example;

import org.openqa.selenium.By;

public class RealEstate extends Advertisement{
    private String[] objectType;

    public RealEstate(String city, String microdistrict, String street, String houseSize, String price, String phoNo, String photo, String[] objectType){
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
        for (int i = 0; i < objectType.length; i++) {
            switch (objectType[i]) {
                case "Butai pirkti":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[1]")).click();
                    break;
                case "Namai pirkti":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[2]")).click();
                    break;
                case "Patalpos pirkti":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[3]")).click();
                    break;
                case "Butai nuomotis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[4]")).click();
                    break;
                case "Namai nuomotis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[5]")).click();
                    break;
                case "Patalpos nuomotis":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[6]")).click();
                    break;
                case "Sklypai mieste":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[7]")).click();
                    break;
                case "Skypai kaime":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[8]")).click();
                    break;
                case "Sodybos, sodai":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[9]")).click();
                    break;
                case "Garažai/vietos":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/ul/li[10]")).click();
                    break;
            }
        }
    }




}
