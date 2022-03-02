package gun4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_LoginKontrolWithTrryCatch extends BaseStaticDriver {
    /*
        1- https://www.saucedemo.com/  sitesini acin
        2- Ekranda gorunen usernameleri bir string diziye atiniz
        3- Bu username ve passwordlarını hepsinin login olup olamadığını
        login olduktan sonraki sayfada Products kelimesinin kontrol ederek
        doğrulayınız.
        diğer login kontrolleri için navigate.back kullanınız.
        4- Login olamayan userları ve hata bilgisini yazdırınız.
         */

    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("https://www.saucedemo.com/");

        WebElement usersText=driver.findElement(By.cssSelector(".login_credentials"));
        //System.out.println(usersText.getText());

        String[] usernames= usersText.getText().split("\n");

        for (int i = 1; i < usernames.length; i++) {

            Thread.sleep(1000);
            WebElement userName= driver.findElement(By.id("user-name"));
            userName.clear();
            userName.sendKeys(usernames[i]);

            WebElement password= driver.findElement(By.id("password"));
            password.clear();
            password.sendKeys("secret_sauce");

            WebElement login=driver.findElement(By.id("login-button"));
            login.click();

           /* List<WebElement> products = driver.findElements(By.cssSelector("span[class='title']"));
            // verdiğimiz konumda eğer element yoksa hata verir. sonra yapmak istediğimiz işlemleri yapamayız
            if (products.size()==1){
                System.out.println(usernames[i] +  " Bu userName ile login olundu...");
                driver.navigate().back();
            }
            else {
                WebElement errorMessage =driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(usernames[i] + "Bu username ile login olmadı ....... " + errorMessage.getText());
            }

            */

            try{
                driver.navigate().refresh();
                WebElement products=driver.findElement(By.cssSelector("span[class='title']"));
                Assert.assertTrue(products.getText().equalsIgnoreCase("products"));
                System.out.println(usernames[i] +  " Bu userName ile login olundu...");
                driver.navigate().back();
            }catch (Exception e){
                // Elementi bulamama durumunda Exception hata type kullaniyoruz
                // Assert ile kontrol yapacagimiz zaman AssertionError hata type kullaniyoruz
               WebElement errorMessage =driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(usernames[i] + "Bu username ile login olmadı ....... " + errorMessage.getText());
                //
            }



        }
        driver.quit();
    }
}
