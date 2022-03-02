package gun11;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseStaticDriver;

import java.awt.*;

public class _01_ActionHoverOver extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Thread.sleep(1000);
        //driver.switchTo().frame("gdpr-consent-notice");

        Thread.sleep(1000);
       // WebElement akzeptieren = driver.findElement(By.xpath("//span[text()='Alle akzeptieren']"));
        //akzeptieren.click();

        Thread.sleep(1000);

        WebElement loan = driver.findElement(By.xpath("//a[text()=' LOAN ']"));
        System.out.println("action öncesi color = " + loan.getCssValue("color"));  // default olarak rgba formatinda donusum aliyoruz

        Actions builder = new Actions(driver);

        Action action = builder.moveToElement(loan).build();
        action.perform();

        System.out.println("action sonrasi color = " + Color.fromString(loan.getCssValue("color")).asRgb());  //rgb donusumu
        System.out.println("action sonrasi color = " + Color.fromString(loan.getCssValue("color")).asHex());  //#ee7933  donusum

        String result = Color.fromString(loan.getCssValue("color")).asHex();
        String expected = "#ee7933";
        Assert.assertEquals(expected,result);

    }
}
