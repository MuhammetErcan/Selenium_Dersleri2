package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _07_İFrame3 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(0);  // "frame1"
        // sitede birden fazla iframe var. Frame gecisi yapilmadiginda o alandaki elemente ulasamiyoruz


        WebElement textBox = driver.findElement(By.cssSelector("body>input"));
        textBox.sendKeys("Kraft Techno");

        driver.switchTo().parentFrame();  // todo frame den cikmak icin bu kodu kullandik
        WebElement selenium = driver.findElement(By.xpath("(//a[@class='nav-link head'])[2]"));
        selenium.click();

        driver.quit();
    }
}