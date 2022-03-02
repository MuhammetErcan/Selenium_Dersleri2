package gun9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _01_ActionDragAndDrop_1 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Thread.sleep(1000);

       // driver.switchTo().frame("gdpr-consent-notice");
        // ekranda devam edebilmemiz icin iframe olustu. Gecis yapabilmek icin bu kodu yazdik.
        // iframe bulabilmek icin name ve id kullanilmali



       // WebElement akzeptieren = driver.findElement(By.xpath("//span[text()='Alle akzeptieren']"));
        // akzeptieren.click();

        WebElement bank = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement hedef = driver.findElement(By.id("bank"));
        //todo  ol.field14.ui-droppable.ui-sortable li.placeholder :nth-child(1)   css ile child a ulasmis olduk

        Actions builder = new Actions(driver);

//        Action tasima = builder.clickAndHold(bank).moveToElement(hedef).release().build();
        // clickAndHold  tasinacak element tiklayip tutuyor. moveToElement hedefe hareket et. release hedef birakmasini sagliyor.

        Action tasima = builder.dragAndDrop(bank,hedef).build();
        // ilk once tasinacak element sonra hedef yazilir
        tasima.perform();







    }
}
