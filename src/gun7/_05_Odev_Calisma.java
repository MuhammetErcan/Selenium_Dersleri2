package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05_Odev_Calisma extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://form.jotform.com/220526097671357\n");

        WebElement devOps=driver.findElement(By.xpath("//label[@id='label_input_11_0']"));
        System.out.println("isDisplayed= " + devOps.isDisplayed());
        System.out.println("isEnabled= " + devOps.isEnabled());
        System.out.println(" clickten önce isSelected= " + devOps.isSelected());
        devOps.click();
        Thread.sleep(2000);
        System.out.println(" clickten sonra isSelected= " + devOps.isSelected());




    }
}
