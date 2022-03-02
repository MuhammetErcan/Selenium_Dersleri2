package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _01_Try_Catch extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://www.saucedemo.com/");

        login("standard_user", "secret_sauce");
        try{
            WebElement urun =driver.findElement(By.cssSelector("img.[alt='Sauce Labs Backpack']"));
            urun.click();
        }catch (Exception e){
            System.out.println("******** Element Bulunamadı****" + e.getMessage());
        }



    }
    public static void login (String user, String pass){
        driver.get("https://www.saucedemo.com/");
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys(user);

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys(pass);

        WebElement login=driver.findElement(By.id("login-button"));
        login.click();

    }
}
