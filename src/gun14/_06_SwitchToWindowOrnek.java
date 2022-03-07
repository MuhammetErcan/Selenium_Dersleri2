package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _06_SwitchToWindowOrnek extends BaseStaticDriver {

    /*
    https://www.amazon.com.tr/  siteye gidiniz
    Cerezleri kabul et                                           // input[name='accept']
    arama textbox a "Kitap" yazip ara butonuna click yapalim    // input#twotabsearchtextbox   // input[type='submit']
    Ürün listesinde 40. kitaba e kadar scrool yapalim            (//img[@class='s-image'])[40]
     sonra kitabi click yapalim
     Twitter iconun kadar scroll yapip click yapalim         //  (//a[@target='_blank'])[2]
     name kismina bir text gönderelim                        // input[type='text']
     */

    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com.tr/");

        String  anasayfaId = driver.getWindowHandle();
        System.out.println("anasayfaId = " + anasayfaId);

        WebElement accept = driver.findElement(By.cssSelector("input[name='accept']"));
        accept.click();

        WebElement textBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        textBox.sendKeys("Kitap");

        WebElement ara = driver.findElement(By.cssSelector("input[type='submit']"));
        ara.click();

        WebElement kitap = driver.findElement(By.xpath("(//img[@class='s-image'])[40]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",kitap);

        kitap.click();

        WebElement twitter = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));  // i[aria-label='Twitter']
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView(true);",twitter);
        twitter.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowId : windowHandles) {

            if (!windowId.equals(anasayfaId)){

                driver.switchTo().window(windowId);
                WebElement text = driver.findElement(By.cssSelector("input[type='text']"));
                text.sendKeys("Kraft Techno");
                Thread.sleep(1000);

                driver.close();
            }
        }

        driver.switchTo().window(anasayfaId);

        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.quit();


    }
}
