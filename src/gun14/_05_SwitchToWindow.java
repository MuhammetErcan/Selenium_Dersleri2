package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _05_SwitchToWindow extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get("https://www.selenium.dev/");

        String anaSayfaId=driver.getWindowHandle();

        System.out.println("anaSayfaId = " + anaSayfaId);

        WebElement github=driver.findElement(By.xpath("(//a[@target='_blank'])[9]"));

        github.click();


        Set<String>listId=driver.getWindowHandles();

        for (String windowId:listId) {

            if (windowId.equals(anaSayfaId))continue;

            System.out.println("geçiş öncesi windowId = " + windowId);
            driver.switchTo().window(windowId);
            System.out.println("geçiş sonrası windowId = " + windowId);
            WebElement wiki=driver.findElement(By.cssSelector("span[data-content='Wiki']"));
            wiki.click();

            driver.close();
        }

        driver.switchTo().window(anaSayfaId);
        WebElement slack=driver.findElement(By.xpath("(//a[@target='_blank'])[10]"));
        slack.click();

        System.out.println(driver.getTitle());



    }
}
