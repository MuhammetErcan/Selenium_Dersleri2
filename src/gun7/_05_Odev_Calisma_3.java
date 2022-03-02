package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05_Odev_Calisma_3 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://form.jotform.com/220525974190356\n");

        Thread.sleep(2000);

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        WebElement devOps=driver.findElement(By.cssSelector("label[id='label_input_11_0']"));
        System.out.println(devOps.isSelected());
        Thread.sleep(2000);
        devOps.click();
        System.out.println("************");
        System.out.println(devOps.isSelected());



    }
}
