package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BaseStaticDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    static {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:\\SELENİUM\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait=new WebDriverWait(driver,Duration.ofSeconds(10));


    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void clickTo(By locater){
        //1-driver.findElement(locater).click();
        //2-WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locater));
        //element.click();
        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }

    public static void sendKeysTo(By locater, String str){
        //driver.findElement(locater).sendKeys(str);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(str);

    }

    public static void takeScreenShot(){
        String fileName ="ScreenShot_" +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        //driver screenshot yapması için cast ediliyor
        TakesScreenshot srcShot= (TakesScreenshot) driver;

        //driver screenshot yapıyor. source file
        File srcFile=srcShot.getScreenshotAs(OutputType.FILE);

        //yazdırılacak dosya
        File destFile=new File("screenShots\\" + fileName +".png");

        //FileUtils screenshot ı png olarak kaydediyor
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
