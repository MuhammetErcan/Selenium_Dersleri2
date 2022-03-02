package gun3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import utils.BaseStaticDriver;

public class _02_NavigateTo extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        // _Try_Catch.login("standard_user","secret_sauce");
        // Metodun icinde driver.get () özelligi kullanildigi icin burada bue methodu kullanmadik

        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.id("login-button"));
        login.click();

        WebElement urun =driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
        urun.click();

        Thread.sleep(3000);



        driver.navigate().back();
        String expected = "https://www.saucedemo.com/.inventory.html";
        String backSite = driver.getCurrentUrl();
        try{

            Assert.assertEquals("Yanlış adrestesiniz",expected,backSite);
            //https://www.saucedemo.com/inventory.html
        }catch (AssertionError e){
            // url Assert yapilacagi zaman kendi ozel hata type yazmamiz gerekiyor  - AssertionError
            System.out.println("e.getMessage() = " + e.toString());
            System.out.println(" Assert islemi yapilamadi "  );
        }


        Thread.sleep(3000);

        driver.navigate().forward();
        String expected2="https://www.saucedemo.com/inventory-item.html?id=4";
        String forwardSite = driver.getCurrentUrl();
        Assert.assertEquals("Yanlış adrestesiniz",expected2,forwardSite);
        //https://www.saucedemo.com/inventory-item.html?id=4

        driver.quit(); // bütün açılmış sayfaları kapatır.
        //driver.close();  sadece aktif olan sayfayı kapatır
    }
}
