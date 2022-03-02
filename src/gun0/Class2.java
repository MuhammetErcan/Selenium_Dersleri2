package gun0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://login.yahoo.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("createacc")).click();

        driver.findElement(By.id("usernamereg-firstName")).sendKeys("Ahmet");

        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Burak");

        driver.findElement(By.id("usernamereg-yid")).sendKeys("ahburak@yahoo.com");

        driver.findElement(By.id("usernamereg-password")).sendKeys("Pass1234567!");

        Thread.sleep(5000);

        driver.quit();



    }
}
