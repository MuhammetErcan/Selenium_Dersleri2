package gun11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05_Alert_SendKeys extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        String text = "Kraft Techno";
        WebElement promButton = driver.findElement(By.cssSelector("button#promtButton"));
        promButton.click();
        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys(text);
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        // Alert kutucugunun icindeki mesajin getText ini aldik

        driver.switchTo().alert().accept();

        String isimOnay = driver.findElement(By.cssSelector("span#promptResult")).getText();
        // Mesaji send yaptigimiza dair onay mesajinin getText ini aldik
        System.out.println("isimOnay = " + isimOnay);
        Assert.assertTrue(isimOnay.contains(text));

        Thread.sleep(1000);
        driver.quit();

    }
}
