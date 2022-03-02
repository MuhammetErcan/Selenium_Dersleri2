package gun2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.List;

public class _AddToCart {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
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
/*


        List<WebElement> urunIsimListesi=driver.findElements(By.className("inventory_item_name"));

        for (WebElement elements:urunIsimListesi) {
            System.out.println(elements.getText());
        }

 */

        List<WebElement> addToCarts=driver.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));

        for (WebElement elementCarts: addToCarts) {
            elementCarts.click();
        }
        
        Thread.sleep(3000);

        List<WebElement> addToCartsRemove=driver.findElements(By.cssSelector("button[class='btn btn_secondary btn_small btn_inventory']"));

        for (WebElement remove:addToCartsRemove) {
            remove.click();

        }

        String url = driver.getCurrentUrl();    // url kontrol ediyoruz. yanlış adres girince assert hata yazdırıuyor.
        Assert.assertEquals("yanlış adrestesiniz","https://www.saucedemo.com/inventory.html",url);

        // assert doğruysa TESTİNİZ BAŞARIYLA TAMAMLANDI yazdır


        System.out.println("TESTİNİZ BAŞARIYLA TAMAMLANDI");






    }
}
