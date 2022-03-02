package gun9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_ActionDragAndDrop_2 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo= driver.findElement(By.id("box1"));
        WebElement norvec= driver.findElement(By.id("box101"));

        System.out.println("talınmadan önce oslo = " + oslo.getCssValue("background-color"));

        Actions builder = new Actions(driver);
        Action action=builder.dragAndDrop(oslo,norvec).build();

        action.perform();

        System.out.println("taşındıktan sonra oslo = " + oslo.getCssValue("background-color"));
        String expecteed="rgba(0, 255, 0, 1)";

        Assert.assertEquals(expecteed,oslo.getCssValue("background-color"));

        WebElement madrid= driver.findElement(By.id("box7"));
        WebElement ispanya= driver.findElement(By.id("box107"));

        action=builder.dragAndDrop(madrid,ispanya).build();
        action.perform();

        Assert.assertEquals(expecteed,madrid.getCssValue("background-color"));





    }
}
