package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _04_Alert_Iptal extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement confirmButton=driver.findElement(By.cssSelector("button[id='confirmButton']"));
        confirmButton.click();

        Thread.sleep(1000);


        driver.switchTo().alert().dismiss();
    }
}
