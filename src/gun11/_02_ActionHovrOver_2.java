package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_ActionHovrOver_2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.etsy.com/\n");

        WebElement clothing=driver.findElement(By.cssSelector("span[id='catnav-primary-link-10923']"));

        WebElement kids=driver.findElement(By.xpath("//span[@id='side-nav-category-link-10941']"));

        Actions builder =new Actions(driver);
        Action action= builder.moveToElement(clothing).build();
        action.perform();

        Thread.sleep(2000);

         action= builder.moveToElement(kids).build();
        action.perform();






    }
}
