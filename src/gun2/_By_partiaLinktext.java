package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _By_partiaLinktext {
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

        WebElement urun_1_partial = driver.findElement(By.partialLinkText("Backpack"));
        // partialLinktext yalnızca "a" tagname li lokasyonda kullanılır.
        // textin bir parçasını alarak arama yapıyoruz (contains gibi)

        System.out.println("urun_1_partial = " + urun_1_partial.getText());

        urun_1_partial.click();


    }
}
