package gun8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _04_Odev_Form extends BaseStaticDriver {
    /*
    https://form.jotform.com/220466667555061   -  Ödev Form sıtesı

        Formdaki Tüm alanlari doldurarak
        submit butouna basiniz ve ekanda Cikan "Thank You!" yazisini Onaylayiniz
        Bulundugunuz sayfanin linkinin "https://submit.jotformeu.com/220466667555061"  oldgunu Assert ile test ediniz
     */

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://form.jotform.com/220466667555061");
        WebElement firsName=driver.findElement(By.cssSelector("input[id='first_3']"));
        firsName.sendKeys("ali");

        WebElement surName=driver.findElement(By.cssSelector("input[id='last_3']"));
        surName.sendKeys("veli");

        WebElement email=driver.findElement(By.cssSelector("input[id='input_4']"));
        email.sendKeys("asdad@gmail.com");

        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
        //        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);

        WebElement adres=driver.findElement(By.cssSelector("input[id='input_5_addr_line1']"));
        adres.sendKeys("adresss");

        WebElement city = driver.findElement(By.cssSelector("input[id='input_5_city']"));
        city.sendKeys("brüksel");

        WebElement zipCode=driver.findElement(By.cssSelector("input[id='input_5_postal']"));
        zipCode.sendKeys("3000");

        Thread.sleep(2000);

        WebElement countrySelect=driver.findElement(By.cssSelector("select[id='input_5_country']"));
        Select select=new Select(countrySelect);
        //select.selectByIndex(99);
        List<WebElement> options=select.getOptions();
        options.get(99).click();

        Thread.sleep(2000);

       WebElement itBransi=driver.findElement(By.cssSelector("select[id='input_6']"));
       Select itSelect=new Select(itBransi);
       itSelect.selectByIndex(2);

        Thread.sleep(2000);

       WebElement itChoose =driver.findElement(By.cssSelector("option[value='SDET']"));
       itChoose.click();

       WebElement date=driver.findElement(By.cssSelector("input[id='lite_mode_10']"));
       date.sendKeys("02-18-2022");

       WebElement textArea=driver.findElement(By.cssSelector("textarea[id='input_8']"));
       textArea.sendKeys("Merhaba");

       Thread.sleep(2000);

       WebElement submit = driver.findElement(By.cssSelector(" button[data-component='button']"));
       submit.click();

        List<WebElement> thankYouList=driver.findElements(By.cssSelector("h1[class='thankyou-main-text ty-text']"));
        if(thankYouList.size()==1){
            System.out.println("the form has been completed and the submission has been done successfully");
        }

        String ecpected="https://submit.jotformeu.com/220466667555061";
        String lastPageUrl=driver.getCurrentUrl();



        Assert.assertEquals("wrong page",ecpected,lastPageUrl);










    }
}
