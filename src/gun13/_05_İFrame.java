package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _05_İFrame extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(1); // "frame2"
        // sitede birden fazla iframe var. Frame gecisi yapilmadiginda o alandaki elemente ulasamiyoruz

        WebElement avatarOption = driver.findElement(By.xpath("//option[text()='Avatar']"));
        avatarOption.click();

        driver.quit();


    }
}