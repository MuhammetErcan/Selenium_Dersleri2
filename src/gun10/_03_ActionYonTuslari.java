package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_ActionYonTuslari extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/auto-complete");

        WebElement textBox=driver.findElement(By.id("autoCompleteMultipleContainer"));

        Actions builder = new Actions(driver);

        Action action=builder.moveToElement(textBox).click().sendKeys("a").build();
        action.perform();

        Thread.sleep(1000);

        action=builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
        action.perform();
    }
}
