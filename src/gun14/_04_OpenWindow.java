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

        String anaSayfaId=driver.getWindowHandle();

        List<WebElement> targetLinks=driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement element :targetLinks) {
            element.click();
        }

        Set<String> windowHandles = driver.getWindowHandles();

        for (String id:windowHandles) {

            System.out.println("id = " + id);

        }

        /*
        id = CDwindow-BDE3C1D85D5E5D7B75A3DD81C0DA333C
        id = CDwindow-109058D7C16301CB6F7899889803DCE9
        id = CDwindow-E8789A453CAA6025148BE5FE2F8EFE65
        id = CDwindow-2220204D6AD1B2C005B529C0A9FFF6C5
        id = CDwindow-1A126D7E232845412E184EFA4FBB0B4F
        id = CDwindow-19034571542DD90BAA60863115A725F9
        id = CDwindow-E018976820BDAB75CBD19FCBCB86AE67
        id = CDwindow-F62DF62CE671AC62574C7A59ED09DAA5
        id = CDwindow-B1AAB176B7CBBE22DEFA6D6AC804FC37
        id = CDwindow-FE4ED0AA1D5882726F2A9C9EA14C75BF
        id = CDwindow-C3918EC9C29F00F321D88F608459379E
        id = CDwindow-C3594F543D305C157890534314DD81E1
         */

    }
}
