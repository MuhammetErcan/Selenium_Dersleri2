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
        driver.manage().deleteAllCookies();
        // Site Otomatik test edildigini anladiginda kendini korumaya alabiliyor.
        // Cookiesler temizlendiginde bu sorunu asabiliyoruz
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");  // bulundugu konumdan verdigimiz ölcü kadar scrool yapmamizi sagliyor
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,2000)");  // en son oldugu konumun uzerine ekleyerek ileri gidiyor
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-2000)");  // verilen kadar yukari scrool yapiyor

        Thread.sleep(1000);
        js.executeScript("scroll(0,3000);");
        // tum sayfada konumlanmasini istedigimiz yerin konumuna scrool yapiyor


    }
}
