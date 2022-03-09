package gun17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseStaticDriver;

public class Main {
    public static WebDriver driver;


    public static void main(String[] args) {
/*
        driver=Driver.getDriver();
        driver.get("https://google.com");
        Driver.quitDriver();

 */

        driver=Driver.getDriver(Browser.FIREFOX);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");


        driver.quit();
    }
}
