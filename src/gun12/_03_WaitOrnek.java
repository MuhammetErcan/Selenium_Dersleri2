package gun12;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03_WaitOrnek extends BaseStaticDriver {

    /**
     * https://www.demoblaze.com/index.html  siteye gidiniz
     *     Samsung galaxy s6  ürününü aciniz
     *     AddToCart butonuna basiniz
     *     alert kutusu cikana kadar bekleyiniz
     *     Alert kabul edin.
     */

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html\n");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement product_s6=driver.findElement(By.linkText("Samsung galaxy s6"));
        product_s6.click();

        WebElement addToCart=driver.findElement(By.cssSelector("a[onclick='addToCart(1)']"));
        addToCart.click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()); // alert görünür oluncaya kadar bekle

        String alertMessage=driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);
        Assert.assertEquals("Product added",alertMessage);

        driver.switchTo().alert().accept();


    }
}
