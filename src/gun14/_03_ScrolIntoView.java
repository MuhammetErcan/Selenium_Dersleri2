package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03_ScrolIntoView extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        // Site Otomatik test edildigini anladiginda kendini korumaya alabiliyor.
        // Cookiesler temizlendiginde bu sorunu asabiliyoruz
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.cssSelector("div[class='text-center font-bold text-3xl']"));

//        js.executeScript("arguments[0].scrollIntoView();",element);  // lokasyonunu verdigim elemente kadar scroll yap
        // default olarak window un ust kismina konuclaniyor
//        js.executeScript("arguments[0].scrollIntoView(true);",element);   // lokasyonunu verdigim elemente kadar scroll yap
        // window un ust kismina konuclaniyor
        js.executeScript("arguments[0].scrollIntoView(false);",element);// lokasyonunu verdigim elemente kadar scroll yap
        // window un alt kismina konuclaniyor


    }
}
