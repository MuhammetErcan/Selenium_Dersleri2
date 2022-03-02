package gun7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BaseStaticDriver;

public class _03_CssValueOrnegi extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C://Users//moham//OneDrive//Desktop//Noname//Staj Dosyasi//TR-SDET_Kurs//SELENIUM//Driver//chromedriver92.107.exe");

        driver.manage().window().maximize();

        driver.get("https://form.jotform.com/220466667555061");

        WebElement name= driver.findElement(By.id("first_3"));
        Thread.sleep(2000);

        System.out.println("Click ten önce : "+name.getCssValue("border-color"));

        name.click();

        Thread.sleep(2000);
        WebElement surname= driver.findElement(By.id("last_3"));
        surname.click();
        Thread.sleep(2000);



        WebElement email= driver.findElement(By.id("input_4"));
        email.click();
        Thread.sleep(2000);
//        System.out.println(surname.getCssValue("border-color"));
        System.out.println("Clickten sonra : "+name.getCssValue("border-color"));



    }
}