package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_Alert extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement alert1=driver.findElement(By.cssSelector("button[id='alertButton']"));
        alert1.click();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        WebElement alert2=driver.findElement(By.cssSelector("button[id='timerAlertButton']"));
        alert2.click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
    }
}
