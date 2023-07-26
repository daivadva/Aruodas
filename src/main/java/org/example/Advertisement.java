package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Advertisement {
    private String city;
    private String microdistrict;
    private String street;
    private String phoNo;
    private String area;
    private String price;
    private String photo;

    public Advertisement(String city, String microdistrict, String street, String area, String price, String phoNo, String photo){
        this.city = city;
        this.microdistrict = microdistrict;
        this.street = street;
        this.phoNo = phoNo;
        this.area = area;
        this.price = price;
        this.photo = photo;
    }

    public void fillGenerics() {
        selectRegion();
        selectMicrodistrict();
        selectStreet();
        fillArea();
        fillPrice();
        fillPhoNo();
        selectPhoto();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void selectPhoto() {
        Utils.driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(this.getPhoto());
    }

    public void selectRegion() {
        if (this.getCity().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/span")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(this.getCity());
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[63]"), this.getCity()));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    public void selectMicrodistrict() {
        if (this.getCity().equals("") || this.getMicrodistrict().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/input[2]")).click();
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElement(By.tagName("input")).sendKeys(this.getMicrodistrict());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rows = Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).size() - 1;
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).get(rows).click();
    }

    public void selectStreet() {
        if (this.getCity().equals("") || this.getMicrodistrict().equals("") || this.getStreet().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/input[2]")).click();
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(2).findElement(By.tagName("input")).sendKeys(this.getStreet());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rows = Utils.driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li")).size() - 1;
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li")).get(rows).click();
    }

    public void fillPhoNo(){
        if (this.getPhoNo().equals("")){
            return;
        }
        Utils.driver.findElement(By.name("phone")).sendKeys(this.getPhoNo());
    }

    public void fillArea(){
        if (this.getArea().equals("")){
            return;
        }
        Utils.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.getArea());
    }

    public void fillPrice(){
        if (this.getPrice().equals("")){
            return;
        }
        Utils.driver.findElement(By.id("priceField")).sendKeys(this.getPrice());
    }
    public void submit() {
        Utils.driver.findElement(By.id("submitFormButton")).click();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMicrodistrict() {
        return microdistrict;
    }

    public void setMicrodistrict(String microdistrict) {
        this.microdistrict = microdistrict;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhoNo() {
        return phoNo;
    }

    public void setPhoNo(String phoNo) {
        this.phoNo = phoNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}



