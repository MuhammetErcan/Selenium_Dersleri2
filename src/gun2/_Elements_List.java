package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _Elements_List {
    public static void main(String[] args) throws InterruptedException {
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



        List<WebElement> urunIsimListesi=driver.findElements(By.className("inventory_item_name"));

        for (WebElement elements:urunIsimListesi) {
            System.out.println(elements.getText());
        }







    }
}
