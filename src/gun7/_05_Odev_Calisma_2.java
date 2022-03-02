package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05_Odev_Calisma_2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwBasicButton\n");

        Thread.sleep(2000);
        WebElement normalButton=driver.findElement(By.cssSelector("button[id='gwt-debug-cwBasicButton-normal']"));
        System.out.println("isDisplayed= " + normalButton.isDisplayed());
        System.out.println("isEnabled= " + normalButton.isEnabled());
        System.out.println(" isSelected= " + normalButton.isSelected());

        System.out.println("*******************");

        WebElement disabledButton=driver.findElement(By.cssSelector("button[id='gwt-debug-cwBasicButton-normal']"));
        System.out.println("isDisplayed= " + disabledButton.isDisplayed());
        System.out.println("isEnabled= " + disabledButton.isEnabled());
        System.out.println("isSelected= " + disabledButton.isSelected());

        //*[text()=’Search Google or type a URL’]







    }
}
