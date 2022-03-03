package gun13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _01_Wait_Clickable extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement product_S6 = driver.findElement(By.linkText("Samsung galaxy s6"));
        product_S6.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // element clickable oluncaya kadar bekledi
        WebElement addToCart =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[onclick='addToCart(1)']")));
        System.out.println("addToCart = " + addToCart.isEnabled());
        addToCart.click();


        // alert mesaj cikana kadar bekle
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


        driver.quit();
    }
}