package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class _01_WaitGiris extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html\n");

        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // driver ilk açılırken yüklenmesini bekletiyoruz
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  //pageLoadTimeOut güncel kullanım
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); // ihtiyaç halinde her element için bekleme süresi
                                                                            // Element bulunduğu anda beklemeyi bırakır

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   // ImplecitWait güncel kullanım



        // Thread.sleep(1000);
        // javaya ait bir bekletme kodu
        // Elementi bulsada verilen süreyi bekler

        WebElement button=driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        WebElement webDriver=driver.findElement(By.xpath("//p[text()='WebDriver']"));
        //implicitWait aktif olmadığı zaman driverda bu lokasyonun gelmesini beklemediği için hata verdi
        System.out.println("webDriver = " + webDriver.getText());



    }
}
