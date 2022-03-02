package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_CssSenaryo extends BaseStaticDriver {
    /*
        https://formsmarts.com/form/yu?mode=h5
        Business seç
        Online Advertising
        Every Day
        Average
        I'm using XYZ for about a week
        Message kismına bir yazı gönder
     */

    public static void main(String[] args) {
        driver.get("https://formsmarts.com/form/yu?mode=h5");

        WebElement busines= driver.findElement(By.cssSelector("input[id^='u_'][id$='_4586_0']"));//input[id='u_Dsr_4586_0']

        busines.click();

        WebElement ilkSelect=driver.findElement(By.cssSelector("select[id^='u_'][id$='_4588']"));
        ilkSelect.click();

        WebElement online = driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        online.click();

        WebElement everyDay= driver.findElement(By.cssSelector("input[id^='u_'][id$='_89585_0']"));
        everyDay.click();

        WebElement average = driver.findElement(By.cssSelector("input[id^='u_'][id$='_4589_1']"));
        average.click();

        WebElement ikinciSelect= driver.findElement(By.cssSelector("select[id^='u_'][id$='_4597']"));
        ikinciSelect.click();

        WebElement week = driver.findElement(By.cssSelector("option[value=\"I'm using XYZ for about a week\"]"));
        // Eger lokasyon icerisinde tek tirnak ' kullaniliyorsa cift tirnak " kullanarak lokasyunu daha rahat bulabiliriz.
        week.click();

        WebElement message = driver.findElement(By.cssSelector("textarea[id^='u_'][id$='_89597']"));
        message.sendKeys("Merhaba");



        WebElement date = driver.findElement(By.cssSelector("input[id^='u_'][id$='_14597']"));
        date.sendKeys("11.11.2021");











    }
}
