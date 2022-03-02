package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02_ExplicityWait extends BaseStaticDriver {

    /*

     Implicity : Bütün elementler icin bekleme suresi
        Explicity : Özel olarak tek bir element icin bekleme suresi

                .titleIs -> title bu olana bekle
                .titleContains -> title icinde belirttigimz kelime gecene kadar bekle
                .visibilityOfTheElement -> element gözükene kadar bekle
                .elementToBeClickable -> element tiklanabilir olana kadar bekle
                .elementToBeSelected -> element secilebilir olana kadar bekle
                .alertIsPresent() -> alert cikana kadar bekle
                .textToBe  -> element text görünür olana kadar bekle
                .InvisibilityOfTheElement  - element kaybolana kadar bekle

        Implicity wait in suresini bekliyor, hala bulamadiysa explicity wait ile belirgin elementi bekliyor.
        Her iki sure sonunda bulamazsa , hata veriyor.

     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html\n");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement button=driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //  elementi bulduğu anda süre devam etmeyip islemi yapmamızi sağlıyor

        //WebElement webDriver=driver.findElement(By.xpath("//p[text()='WebDriver']"));

       WebElement webDriver=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

        System.out.println("webDriver = " + webDriver.getText());



    }
}
