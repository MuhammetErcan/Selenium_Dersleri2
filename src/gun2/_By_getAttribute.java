package gun2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _By_getAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password= driver.findElement(By.id("password"));
        String attributeAutocorrect= password.getAttribute("autocorrect");

        // Assert.assertTrue("off".equals(attributeAutocorrect));
        System.out.println("attributeAutocorrect = " + attributeAutocorrect);


        password.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.id("login-button"));

        String a_Class=login.getAttribute("class");  // linkText ve partialLinkText te sonuç alınmıyor
        String  a_Type=login.getAttribute("type");


        System.out.println("a_Type = " + a_Type);
        System.out.println("a_Class = " + a_Class);

        login.click();


    }
}
