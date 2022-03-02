package gun0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

       WebDriver driver=new ChromeDriver();
       driver.get("https://www.saucedemo.com/");
       driver.manage().window().maximize();

       driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        Thread.sleep(3000);
       driver.findElement(By.id("login-button")).click();

       Thread.sleep(3000);

       driver.close();
       /*
       element bulma
       1-id ile
       2- name
       3- className
       4- linkText
       5-partialLinkText
       6-tagName
       7- cssSelector todo=> tagAdi[@özellikAdi='deger']
       8- xPath => başına her zaman // olmalı

       driver.findElement(By.xpath("......"));
       xpath'te bu şekilde yapıyoruz todo=> //tagAdi[@özellikAdi='deger']
        */

    }
}
