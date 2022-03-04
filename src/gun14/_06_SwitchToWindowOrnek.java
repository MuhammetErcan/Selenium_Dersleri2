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
    Cerezleri kabul et                                      // input[name='accept']
    arama textbox a "Kitap" yazip ara butonuna click yapalim  // input#twotabsearchtextbox   // input[type='submit']
    Ürün listesinde 40. kitaba e kadar scrool yapalim       (//img[@class='s-image'])[40]
     sonra kitabi click yapalim

     Twitter iconun kadar scroll yapip click yapalim     //  (//a[@target='_blank'])[2]
     name kismina bir text gönderelim        input[type='text']


     */
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com.tr/");

        String anasayfaId=driver.getWindowHandle();

        WebElement cerez=driver.findElement(By.cssSelector("input#sp-cc-accept"));
        cerez.click();

        WebElement text=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        Actions builder=new Actions(driver);
        Action action=builder.moveToElement(text).click().sendKeys("Kitap").sendKeys(Keys.ENTER).build();
        action.perform();

        WebElement kitap=driver.findElement(By.xpath("(//img[@class='s-image'])[40]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",kitap);

        kitap.click();

        WebElement twitter= driver.findElement(By.cssSelector("i[class='a-icon a-icon-share-twitter']"));
        twitter.click();


        Set<String> listId= driver.getWindowHandles();

        for (String windowId:listId) {
            if (windowId.equals(anasayfaId))continue;

                driver.switchTo().window(windowId);
                WebElement textYaz=driver.findElement(By.cssSelector("input[name='session[username_or_email]']"));
                 action=builder.sendKeys("aaa").sendKeys(Keys.ENTER).build();
                 action.perform();
            System.out.println(driver.getTitle());

                 driver.close();



        }

        driver.switchTo().window(anasayfaId);
        System.out.println(driver.getTitle());
















    }
}
