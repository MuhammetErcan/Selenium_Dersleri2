package gun9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_ActionDragAndDropBy extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement left=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all'][1]"));
        WebElement right=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all'][2]"));

        Actions builder=new Actions(driver);

        Action leftGeri=builder.dragAndDropBy(left,-10,0).build();
        // islem yapacagim elementi seciyorum, x ekseninde hangi yöne hareket edeceksem onu yaziyorum.
        // y ekseninde hareket olmayacagi icin sifir kaldi
        leftGeri.perform();



        Thread.sleep(2000);

       Action rightIleri=builder.dragAndDropBy(right,50,0).build();
       rightIleri.perform();




    }
}
