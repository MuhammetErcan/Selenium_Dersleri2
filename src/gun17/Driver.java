package gun17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    private static WebDriver driver;
    //private static WebDriverWait wait;

    public WebDriver getDriver(){
        return getDriver(Browser.CHROME);
    }

    public  WebDriver getDriver(Browser browser) {
        if (driver == null) {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "C:\\SELENİUM\\FirefoxDriver\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case OPERA:
                    System.setProperty("webdriver.opera.driver", "C:\\SELENİUM\\OperaDriver\\operadriver.exe");
                    driver = new OperaDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.msedge.driver","C:\\SELENİUM\\EdgeDriver\\msedgedriver.exe");
                    driver=new EdgeDriver();
                    break;
            }
        }
        return driver;
    }


    public static void quitDriver(){
        driver.quit();
    }
}

