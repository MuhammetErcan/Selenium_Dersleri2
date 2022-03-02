package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _01_Action_TusKontrol_SendKeys extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/auto-complete");
        WebElement textBox=driver.findElement(By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']"));

        Thread.sleep(1000);
        Actions builder=new Actions(driver);
        // Kraft
        Action action=builder.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("k")
                .keyUp(Keys.SHIFT).sendKeys("raft").build();

        action.perform();



    }
}
