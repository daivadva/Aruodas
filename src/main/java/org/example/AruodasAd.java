package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AruodasAd {
    private String city;
    private String settlement;
    private String microdistrict;
    private String street;
    private String number;
    private String regNumber;
    private String phoNo;
    private String area;
    private String price;
    private String[] purposes;
    private String description;

    public AruodasAd(String city, String settlement, String microdistrict, String street, String number, String regNumber, String phoNo, String area, String price, String[] purposes, String description) {
        this.city = city;
        this.settlement = settlement;
        this.microdistrict = microdistrict;
        this.street = street;
        this.number = number;
        this.regNumber = regNumber;
        this.phoNo = phoNo;
        this.area = area;
        this.price = price;
        this.purposes = purposes;
        this.description = description;
    }

    public void fillAdd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        selectRegion();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
        // selectSettlement();
        selectMicrodistrict();
        selectStreet();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/input")).sendKeys(this.number);
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[11]/div[1]/input")).sendKeys(this.regNumber);
        Utils.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.area);
        this.selectPurpose();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[26]/div/div[1]/textarea")).sendKeys(this.description);
        Utils.driver.findElement(By.id("priceField")).sendKeys(this.price);
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[34]/span[1]/input")).sendKeys(this.phoNo);
        submit();

    }

    public void submit() {
        Utils.driver.findElement(By.id("submitFormButton")).click();
    }

    public void selectRegion() {
        if (this.city.equals(" ")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/span")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(this.city);
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[63]"), this.city));
    }

    public void selectSettlement() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[4]/span[1]/span")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[4]/span[1]/ul[5]/li[1]/input")).sendKeys(this.settlement);
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[4]/span[1]/ul[5]/li[388]"), this.settlement));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[4]/span[1]/ul[5]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    public void selectMicrodistrict() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/input[2]")).click();
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElement(By.tagName("input")).sendKeys(this.microdistrict);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rows = Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).size() - 1;
    //   Utils.wait.until(ExpectedConditions.textToBePresentInElement(Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).get(rows), this.microdistrict));
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).get(rows).click();

    }

    public void selectStreet() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/input[2]")).click();
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(2).findElement(By.tagName("input")).sendKeys(this.street);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rows = Utils.driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li")).size() - 1;
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li")).get(rows).click();
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
