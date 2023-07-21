package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void acceptCookies(){
        Utils.driver.get("https://www.aruodas.lt");
        Utils.driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public static void logIn() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]")).click();
        Utils.driver.findElement(By.id("userName")).sendKeys("daivadan01@gmail.com");
        Utils.driver.findElement(By.id("password")).sendKeys("daiva2023");
        Utils.driver.findElement(By.id("loginAruodas")).click();
    }
}
