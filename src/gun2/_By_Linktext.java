package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _By_Linktext {
    public static void main(String[] args) {
        //Sauce Labs Backpack
        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.id("login-button"));
        login.click();

        // Linktext yalnızca "a" tagname li lokasyonda kullanılır.
        // text in tamamını alarak arama yapıyoruz (equals gibi)

        WebElement urun_1 =driver.findElement(By.linkText("Sauce Labs Backpack"));

        System.out.println(urun_1.getText());
        urun_1.click();



    }
}
