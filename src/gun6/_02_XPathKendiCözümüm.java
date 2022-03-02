package gun6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _02_XPathKendiCözümüm extends BaseStaticDriver {
    public static void main(String[] args) {

        login("standard_user","secret_sauce");

        List<WebElement> addToCart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        for (WebElement e: addToCart) {
            e.click();
        }

        WebElement sepet=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

        List<WebElement>ilkSayfaUrunListesi=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> stringIlkSayfaUrunListesi=elementToSring(ilkSayfaUrunListesi);

        List<WebElement>ilkSayfaPriceListesi=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> stringIlkSayfaPriceListesi=elementToSring(ilkSayfaPriceListesi);

        List<WebElement>ikinciSayfaUrunListesi=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> stringIkinciSayfaUrunListesi=elementToSring(ikinciSayfaUrunListesi);

        List<WebElement>ikinciSayfaPriceListesi=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> stringIkinciSayfaPriceListesi=elementToSring(ikinciSayfaPriceListesi);

        if (stringIlkSayfaUrunListesi.size()==stringIkinciSayfaUrunListesi.size()){
            stringListKontrol(stringIlkSayfaUrunListesi,stringIkinciSayfaUrunListesi);
        }
        else System.out.println("ürün liste uzunlukları eşit değil");

        System.out.println("****************");

        if (stringIlkSayfaPriceListesi.size()==ikinciSayfaPriceListesi.size()){
            stringListKontrol(stringIlkSayfaPriceListesi,stringIkinciSayfaPriceListesi);
        }
        else System.out.println("price listesi uzunlukları eşit değil");

        WebElement checkOut=driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
        checkOut.click();

       // Assert.assertEquals("hatalı eşleşme",stringIlkSayfaUrunListesi,stringIkinciSayfaUrunListesi);
       // Assert.assertEquals("hatalı eşleşme",stringIlkSayfaPriceListesi,stringIkinciSayfaPriceListesi);

        WebElement firstName=driver.findElement(By.xpath("//input[starts-with(@data-test,'first')]"));
        firstName.sendKeys("Kraft");

        WebElement lastName=driver.findElement(By.xpath("//input[starts-with(@data-test,'last')]"));
        lastName.sendKeys("Techno");

        WebElement zipCode=driver.findElement(By.xpath("//input[contains(@data-test,'posta')]"));
        zipCode.sendKeys("12345");

        WebElement next=driver.findElement(By.xpath("//input[@value='Continue']"));
        next.click();

        WebElement total=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        System.out.println(stringToDouble(total.getText()));
        Double doubleTotal=stringToDouble(total.getText());

        Double doublePriceToplama=0d;
        for (String s:stringIkinciSayfaPriceListesi) {
            doublePriceToplama+=stringToDouble(s);
        }
        System.out.println(doublePriceToplama);

        try{
            Assert.assertEquals("hatalı işlem",doublePriceToplama,doubleTotal);
        }catch (AssertionError e){
            System.out.println(e.getMessage());
        }

        WebElement finish=driver.findElement(By.xpath("//button[contains(text(),'Finish')]"));
        finish.click();

        List<WebElement> write=driver.findElements(By.xpath("//h2[@class='complete-header']"));

        if (write.size()==1){
            System.out.println("THANK YOU FOR YOUR ORDER  yazısı göründü");
        }

        WebElement backHome=driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small']"));
        backHome.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String driverUrl=driver.getCurrentUrl();

        try {
            Assert.assertEquals("sayfa yanlış",expectedUrl,driverUrl);
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            System.out.println("Asserte Girmedi");
        }

        driver.quit();

        System.out.println("işlem burda");

    }


    public static void login(String user, String pass){

        driver.get("https://www.saucedemo.com/");

        WebElement userName=driver.findElement(By.cssSelector("input[placeholder='Username']"));
        userName.sendKeys(user);

        WebElement password=driver.findElement(By.cssSelector("input[placeholder='Password']"));
        password.sendKeys(pass);

        WebElement login=driver.findElement(By.cssSelector("input[data-test='login-button']"));
        login.click();
    }

    public static List<String>elementToSring(List<WebElement>list){

        List<String> textList=new ArrayList<>();
        for (WebElement element:list) {
            textList.add(element.getText());
        }

        return textList;
    }

    public static void stringListKontrol(List<String>list1,List<String>list2){
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))){
                System.out.println(list1.get(i) + "ürün sepette var");
            }
        }
    }

    public static double stringToDouble(String text){

        String doubleText=text.replaceAll("[^0-9,.]","");

        return Double.parseDouble(doubleText);

    }
}
