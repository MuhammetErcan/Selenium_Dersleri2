package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.Set;

public class _07_SwitchToWindowOdev extends BaseStaticDriver {

     /*
    https://techno.study/  sitesine gidiniz
    Get free consultation  butonuna click yapiniz
    acilan windowdaki email textbox  yazi gonderiniz
     */


    public static void main(String[] args) throws InterruptedException {

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://techno.study/");

        String anasayfaId=driver.getWindowHandle();

        WebElement get = driver.findElement(By.linkText("Get free consultation"));
        get.click();

        Set<String> listId = driver.getWindowHandles();

        for (String windowId:listId) {

            if (windowId.equals(anasayfaId))continue;

            driver.switchTo().window(windowId);

            WebElement element = driver.findElement(By.xpath("(//input[@placeholder='Your Email'] )[2]"));
            element.sendKeys("aaaaa");


        }



    }
}
