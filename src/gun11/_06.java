package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _06 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        List<WebElement> teams = driver.findElements(By.cssSelector("div[id='dhtmlgoodies_mainContainer']>div ul"));
        List<WebElement> students = driver.findElements(By.cssSelector("ul[id='allItems']>li"));
        Actions builder= new Actions(driver);

        String a= teams.get(0).getAttribute("style").replaceAll("[^0-9]","");
        int ogrSayi=0;
        for (int i = 0; i < teams.size(); i++) {
            String line= teams.get(i).getAttribute("style").replaceAll("[^0-9]","");
            int lineCount=Integer.parseInt(line);
            int tableLine = (int)(lineCount/26);
            for (int j = 0; j < tableLine; j++) {
                builder.clickAndHold(students.get(ogrSayi)).moveToElement(teams.get(i)).release(teams.get(i)).build().perform();
                ogrSayi++;
                if(j==tableLine) break;
            }
        }
    }
}
