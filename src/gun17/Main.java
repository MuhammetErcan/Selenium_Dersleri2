package gun17;

import org.openqa.selenium.WebDriver;

public class Main {
    public static WebDriver driver;


    public static void main(String[] args) {
/*
        driver=Driver.getDriver();
        driver.get("https://google.com");
        Driver.quitDriver();

 */
        driver=Driver.getDriver(Browsers.FIREFOX);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        driver.quit();
    }
}
