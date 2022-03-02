package gun8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Locale;

public class _02_Select extends BaseStaticDriver {
    /*
         je.executeScript("scroll(0, 250);");
          je.executeScript("window.scrollBy(0,500)")
         je.executeScript("arguments[0].scrollIntoView(true);",element);
         je.executeScript("arguments[0].scrollIntoView(false);",element);
        je.executeScript("arguments[0].scrollIntoView();",element);
     */
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.ebay.com/");

        WebElement katagori = driver.findElement(By.cssSelector("select.gh-sb"));

        Thread.sleep(2000);
        Select select = new Select(katagori);
//        select.selectByValue("625");
        select.selectByIndex(10);   // option larda index sifirdan basliyor   "Collectibles" sectik

        List<WebElement> options = select.getOptions();   // option getText cekebilmek icin bu özelligi kullandik
//        options.get(10).click();
        String secim = options.get(10).getText();  // random secmemize yardimci olur

        System.out.println("secim = " + secim);

        WebElement search = driver.findElement(By.cssSelector("input[type='submit']"));
        search.click();

        WebElement urunIsmi = driver.findElement(By.xpath("(//a[@class='seo-breadcrumb-text'])[2]"));
        // isimlerin ortak lokasyonunu bu sekilde bulduk
        System.out.println("urunIsmi = " + urunIsmi.getText());
        Assert.assertTrue(secim.contains(urunIsmi.getText()));

        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
        Assert.assertTrue(url.toLowerCase().contains(secim.toLowerCase()));


    }
}
