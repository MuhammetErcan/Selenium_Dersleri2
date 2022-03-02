package gun8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_ActionClass extends BaseStaticDriver {
   /*
        sagClick
            maus sol cift Click icin .doubleClick()
            maus sag Click icin  .contextClick()
            maus sol tek Click   .click()
     */


    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/buttons");

        WebElement ciftTiklama = driver.findElement(By.id("doubleClickBtn"));
        Actions builder = new Actions(driver);  // Bu islemler tarayici uzerinden yapildigi icin driver yazdik

        Thread.sleep(2000);
        Action ciftClick = builder.moveToElement(ciftTiklama).doubleClick().build();
        // Yapilacak aksiyon tanimlandi
        ciftClick.perform();   //  asil aksiyon bu kod ile gerceklesiyor

//        builder.doubleClick(ciftTiklama).perform();

        Thread.sleep(1000);
        WebElement sagTiklama = driver.findElement(By.id("rightClickBtn"));

        Action sagClick = builder.moveToElement(sagTiklama).contextClick().build();
        sagClick.perform();

        Thread.sleep(1000);
        WebElement tekTiklama = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Action tekClick = builder.moveToElement(tekTiklama).click().build();
        tekClick.perform();

    }
}