package gun9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _04_ActionDragAndDrop_Calisma extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        List<WebElement>listSehirler=driver.findElements(By.cssSelector("div[id='dropContent'] div[id^=box]"));
        List<WebElement>listUlkeler=driver.findElements(By.cssSelector("div[id='countries'] div[id^=box]"));

        Actions builder =new Actions(driver);

        for (int i = 0; i < listSehirler.size(); i++) {
            for (int j = 0; j < listUlkeler.size(); j++) {

                Action action=builder.dragAndDrop(listSehirler.get(i),listUlkeler.get(j)).build();
                action.perform();

                if(listSehirler.get(i).getCssValue("background-color").equals("rgba(0, 255, 0, 1)")){
                    break;
                }
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
