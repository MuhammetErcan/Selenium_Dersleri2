package gun16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

import java.io.File;
import java.io.IOException;

public class Main extends BaseStaticDriver {
    public static void main(String[] args) throws IOException {
        By usernamText=By.cssSelector("input[name='txtUsername']");
        By paswordText=By.cssSelector("input[name='txtPassword']");
        By submitButton=By.cssSelector("input[class='button");
        By welcome=By.cssSelector("#welcome");


        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        sendKeysTo(usernamText,"Admin");
        sendKeysTo(paswordText,"admin123");
        //clickTo(submitButton);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcome));
        }catch (Exception e){
            takeScreenShot();
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(welcome));
/*
        //driver screenshot yapması için cast ediliyor
        TakesScreenshot srcShot= (TakesScreenshot) driver;

        //driver screenshot yapıyor. source file
        File srcFile=srcShot.getScreenshotAs(OutputType.FILE);

        //yazdırılacak dosya
        File destFile=new File("screenShots\\screen.png");

        //FileUtils screenshot ı png olarak kaydediyor
        FileUtils.copyFile(srcFile,destFile);

 */

        sleep(5000);


        driver.quit();


    }
}
