package gun1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.id("login-button"));
        login.click();

        WebElement urun1=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        urun1.click();

        WebElement sepet=driver.findElement(By.className("shopping_cart_link"));
        sepet.click();

        WebElement eklenenUrun=driver.findElement(By.className("inventory_item_name"));
         String result=eklenenUrun.getText();
         String expected= "Sauce Labs Backpack";

        Assert.assertEquals("Test tamamlanamadı",expected,result);
        //Assert.assertTrue(expected.equals(result));

        //System.out.println("Test başarılı bir şekilde tamamlandı");

    }
}
