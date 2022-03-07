package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _04_OpenWindow extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://www.selenium.dev/");

        String anasayfaId = driver.getWindowHandle();  // sayfada yönelme gercekleseden once anasayfanin Id sini kayit altina aldik

        List<WebElement> targetLinks = driver.findElements(By.cssSelector("a[target='_blank']"));
        // farkli sayfada acilan linkleri bulmak icin _blank ifadesi yazmamiz yeterli
        // Bu liste click yapildiginda farkli sekmede acilan linklerin listesi

        for (WebElement link:targetLinks ) {  // Listedeki butun linkleri actik
            link.click();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        // farkli sayfada acilan linklerin Id lerini Set ile kayit altina aldik

        for (String id:windowHandles) {
            System.out.println("id = " + id);    // acilan linklerin Id lerini yazdirdik
        }

        /*  Bu Id ler her seferinde degisiyor.Id ile yakalayamayiz
        id = CDwindow-02A8A3680D4D503E3BA40532848CFEE8
        id = CDwindow-CD4B9960B65A2FE92A236CD7E6975EC9
        id = CDwindow-37ADDBBC72FB534AB53D03E394656EC5
        id = CDwindow-C227B7F8C834DC4F0028D22439C8C86B
        id = CDwindow-320F20B71A7E39453DEA4853E7D02AF3
        id = CDwindow-61C9B05214DECD4067B5CE77134027BC
        id = CDwindow-55E066E01A41C4F8CA943A79F59842C8
        id = CDwindow-014CE1A3541807E037B35AB0627BE9EE
        id = CDwindow-C7DF37DAA9E09A5C442A38D99958392E
        id = CDwindow-0F2BA810744FA0754A5F7781EBAADF4D
        id = CDwindow-25F8FEB7F4A67BF95E147A3C3640113F
        id = CDwindow-0A4D294A7826AE637813C14E73FE761D
         */
    }
}
