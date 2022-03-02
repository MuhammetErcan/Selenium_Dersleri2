package gun11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _07_Odev extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.birtwhistle.com/workers-compensation-insurance/\n");

        driver.manage().window().maximize();


        Thread.sleep(3000);

        List<WebElement> list =driver.findElements(By.cssSelector("ul[id='menu-1-c1867d7'] li a.elementor-item"));

        Actions builder=new Actions(driver);

        for (WebElement e:list ) {
            builder.moveToElement(e).build().perform();
        }


    }
}
