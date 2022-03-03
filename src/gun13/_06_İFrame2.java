package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _06_İFrame2 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames\n");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame("frame1");
        driver.switchTo().frame("frame3");
        WebElement checkbox=driver.findElement(By.cssSelector("input[id='a']"));
        System.out.println("önce checkbox = " + checkbox.isSelected());
        checkbox.click();
        System.out.println("sonra checkbox = " + checkbox.isSelected());


    }
}