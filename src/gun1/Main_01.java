package gun1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main_01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement arama=driver.findElement(By.name("q"));
        arama.sendKeys("telefon");



        // class    .
        //id        #

    }
}
