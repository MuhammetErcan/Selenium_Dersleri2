package gun7;

import gun3._01_Try_Catch;
import gun6._01_XPath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

/**
 * https://www.saucedemo.com/  siteye git
 * random bir urun sec
 * urune tikla
 * bilgilerini kontrol et
 *
 */

public class _01_RandomUrunKontrol extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        _01_Try_Catch. login("standard_user", "secret_sauce");
        List<WebElement>ilkSayfaUrunListesi=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String > list1= _01_XPath.elementToString(ilkSayfaUrunListesi);

        List<WebElement>ilkSayfaPriceListesi=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String > price1=_01_XPath.elementToString(ilkSayfaPriceListesi);

        List<WebElement> addToCart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        int random = randomSayi(ilkSayfaUrunListesi.size());
        String randomUrunText=list1.get(random);
        String randomUrunPrice=price1.get(random);

        addToCart.get(random).click();
        ilkSayfaUrunListesi.get(random).click();

        String sepetUrunName=driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        String sepetUrunPrice=driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();

        Assert.assertEquals(randomUrunText,sepetUrunName);
        Assert.assertEquals(randomUrunPrice,sepetUrunPrice);

        System.out.println("sepetUrunPrice = " + sepetUrunPrice);
        System.out.println("**********");
        System.out.println("sepetUrunName = " + sepetUrunName);

        Thread.sleep(2000);

        driver.quit();

    }

    public static int randomSayi(int size){
        return (int) (Math.random()*size);
    }
}
