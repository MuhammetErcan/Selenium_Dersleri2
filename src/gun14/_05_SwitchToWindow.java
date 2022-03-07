package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _05_SwitchToWindow extends BaseStaticDriver {

    /*
    https://www.selenium.dev/  siteye gidiniz
    github link i click yapilacak
    github da Wiki click yapilacak
     */
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://www.selenium.dev/");

        String anasayfaId = driver.getWindowHandle();  // sayfada yönelme gercekleseden once anasayfanin Id sini kayit altina aldik
        System.out.println("anasayfaId = " + anasayfaId);

        WebElement gitHub = driver.findElement(By.xpath("(//a[@target='_blank'])[9]"));
        gitHub.click();

//        WebElement wiki = driver.findElement(By.cssSelector("span[data-content='Wiki']"));
//        wiki.click();    // Window gecisi yapilmadan once click yapmaya calistiginda NoSuchElementException hatasini aldik

        Set<String> listId = driver.getWindowHandles();  //  iki tane  1.Anasayfa  2. click yaptigimiz sayfa

        for (String windowId : listId) {

//            if (windowId.equals(anasayfaId)) continue;    // iki yazim seklide sonuc verir
            if (!windowId.equals(anasayfaId)) {             // iki yazim seklide sonuc verir

                driver.switchTo().window(windowId);
                System.out.println("Gecis sonrasi windowId = " + windowId);
                System.out.println("driver.getTitle() = " + driver.getTitle());
                WebElement wiki = driver.findElement(By.cssSelector("span[data-content='Wiki']"));
                wiki.click();
                Thread.sleep(1000);
                driver.close();     // bulundugun windowdan cik
            }
        }


        driver.switchTo().window(anasayfaId);       // anasayfaya gecis yaptik
        WebElement slack = driver.findElement(By.xpath("(//a[@target='_blank'])[10]"));
        slack.click();

        System.out.println("driver.getTitle() = " + driver.getTitle());



    }
}
