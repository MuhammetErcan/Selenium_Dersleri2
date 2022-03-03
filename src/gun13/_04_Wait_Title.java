package gun13;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _04_Wait_Title extends BaseStaticDriver {

    /*
        https://www.yogaalliance.org/  siteye gidiniz
        Action ile Become a Member uzerine geliniz
        Teacher click yapiniz
        title  "Teachers | Yoga Alliance"  olana kadar beklet
     */
    public static void main(String[] args) {
        driver.get("https://www.yogaalliance.org/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions builder = new Actions(driver);

        WebElement become = driver.findElement(By.cssSelector("li[class='root haschild child-2']"));

        Action action = builder.moveToElement(become).build();
        action.perform();

        WebElement teacher = driver.findElement(By.xpath("(//a[text()='Teachers'])[2]"));  ////li[@class='category child-3']/a[text()='Teachers']
        teacher.click();

        String expected = "Teachers | Yoga Alliance";

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

//        boolean title = wait.until(ExpectedConditions.titleContains(expected));
        boolean title_1 = wait.until(ExpectedConditions.titleIs(expected));

        String resultTitel = driver.getTitle();     // Bulundugumuz sayfanin title aliyoruz.
        System.out.println("resultTitel = " + resultTitel);


    }
}