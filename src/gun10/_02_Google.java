package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_Google extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement google=driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        google.click();
        google.sendKeys("Selenium");

        Thread.sleep(3000);
        Actions builder=new Actions(driver);
        Action action=builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build();
        action.perform();


        Thread.sleep(3000);
        action=builder.sendKeys(Keys.ENTER).build();
        action.perform();




    }
}
