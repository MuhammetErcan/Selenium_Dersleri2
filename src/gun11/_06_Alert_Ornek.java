package gun11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _06_Alert_Ornek extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.demo.guru99.com/test/delete_customer.php");

        Thread.sleep(1000);
        /*
        driver.switchTo().frame("gdpr-consent-notice");                   // Lokasyon farkindan dolayi olmayabilir

        Thread.sleep(1000);
        WebElement akzeptieren = driver.findElement(By.xpath("//span[text()='Alle akzeptieren']"));
        akzeptieren.click();

        Thread.sleep(1000);

         */

        WebElement textBox = driver.findElement(By.cssSelector("input[name='cusid']"));
        textBox.sendKeys("12345");
        WebElement submit = driver.findElement(By.cssSelector("input[name='submit']"));
        submit.click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss(); // ilk cikan Alert mesajini iptal ettik
        Thread.sleep(1000);

        submit.click();  // tekrar submit yaptik

        driver.switchTo().alert().accept();   // Alert ti onayladik
        Thread.sleep(1000);

        String alertMesaj_2 = driver.switchTo().alert().getText();      // Alert mesajinin getText ini aldik
        String expected = "Customer Successfully Delete!";
        System.out.println("alertMesaj_2 = " + alertMesaj_2);
        Assert.assertEquals(expected, alertMesaj_2);

        driver.switchTo().alert().accept();  // 2.Alert mesajini onayladik

        Thread.sleep(1000);
        driver.quit();


    }
}
