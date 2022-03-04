package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _08_İFrame4Ornek extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://de.aliexpress.com/?gatewayAdapt=glo2deu\n");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
}