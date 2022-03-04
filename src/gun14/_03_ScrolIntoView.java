package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03_ScrolIntoView extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies(); // site otomatik test edildiğini anladığında kendini korumaya alabiliyor.
        //Cookies ler temizlendiğinde
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);
        JavascriptExecutor js=(JavascriptExecutor) driver;

        WebElement element=driver.findElement(By.cssSelector("div[class='text-center font-bold text-3xl']"));
        js.executeScript("arguments[0].scrollIntoView();",element);

        //js.executeScript("arguments[0].scrollIntoView(true);",element);
        //js.executeScript("arguments[0].scrollIntoView(false);",element);



    }
}
