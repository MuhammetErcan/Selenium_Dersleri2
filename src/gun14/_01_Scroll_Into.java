package gun14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _01_Scroll_Into extends BaseStaticDriver {

    /*
    js.executeScript("scroll(0, 250);");
    js.executeScript("window.scrollBy(0,500)")
    js.executeScript("arguments[0].scrollIntoView(true);",element);
    js.executeScript("arguments[0].scrollIntoView(false);",element);
    js.executeScript("arguments[0].scrollIntoView();",element);
    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");


     */
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies(); // site otomatik test edildiğini anladığında kendini korumaya alabiliyor.
        //Cookies ler temizlendiğinde
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-2000)");
        Thread.sleep(1000);

        js.executeScript("scroll(0, 3000);");




    }
}
