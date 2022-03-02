package gun6;

import gun3._01_Try_Catch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _01_XPath extends BaseStaticDriver {
    /**
     * https://www.saucedemo.com/  siteye git
     * Bütün ürünleri sepete ekle
     * Sepete git
     * Sepetteki ürünleri önceki ürünlerle kiyasla
     * dogruysa Checkout butonuna tikla
     * Cikan formu doldur
     * Continue butonuna tikla
     *Total fiyati kiyasla
     * Finish butonuna tikla
     * "THANK YOU FOR YOUR ORDER" yazisinin sayfada oldugunu onayla
     * Back Home basip bulundugu sayfanin url kontrol et "https://www.saucedemo.com/inventory.html"
     */

    public static void main(String[] args) {

        _01_Try_Catch.login("standard_user","secret_sauce");

        List<WebElement> urunList1=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        //todo  Linktext ev PartialLinkText ile olan metinler a tagName ile bulunur. a tagName ve diğer bütün textlerde xPath ile bulunabilir.
        // todo fakat eğer site farklı dil seçenekleriyle yapılmışsa testimşz sadece tek bir dil ile çalışır.

        List<String>list1=new ArrayList<>();
        //todo elementin get text ini alacağımız için String list oluşturduk

        for (WebElement urun:urunList1) {
            list1.add(urun.getText());
        }

        System.out.println(list1);

        List<WebElement> urunPrice1=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String>price1=new ArrayList<>();

        for (WebElement price:urunPrice1) {
            price1.add(price.getText());
        }
        System.out.println(price1);

        List<WebElement> addToCart=driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement e:addToCart ) {
           // System.out.println(e.getText());
            e.click();
        }

        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

        List<WebElement>urunlist2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String>list2=elementToString(urunlist2);
        // Cleancode mantığı için list elementi String liste atan metod olşturduk

        List<WebElement> urunPrice2=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price2=elementToString(urunPrice2);

        if(list1.size()==list2.size()){
            stringListKontrol(list1,list2);
        }
        else
            System.out.println("listenin uzunluğu eşit değil");

        System.out.println("**************");

        if (price1.size()==price2.size()){
            stringListKontrol(price1,price2);
        }
        else{
            System.out.println("listenin uzunluğu eşit değil");
        }

        WebElement checkOut=driver.findElement(By.xpath("//button[@data-test='checkout']"));
        checkOut.click();

        WebElement firstName=driver.findElement(By.xpath("//input[starts-with(@data-test,'first')]"));
        firstName.sendKeys("Kraft");

        WebElement lastName=driver.findElement(By.xpath("//input[starts-with(@data-test,'last')]"));
        lastName.sendKeys("Techno");

        WebElement zipCode=driver.findElement(By.xpath("//input[contains(@data-test,'posta')]"));
        zipCode.sendKeys("12345");

        WebElement next=driver.findElement(By.xpath("//input[@value='Continue']"));
        next.click();

        WebElement totalPrice=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));

        Double sumPrice=0.0;
        for (String s:price2) {
            sumPrice+=stringToDouble(s);
        }

        System.out.println("sumPrice = " + sumPrice);

        Double totalDouble=stringToDouble(totalPrice.getText());
        System.out.println("totalDouble = " + totalDouble);
        Assert.assertTrue(sumPrice.equals(totalDouble));

        if (sumPrice.equals(totalDouble)){
            System.out.println("fiyat toplamı doğru");
        }

//        String sumText = String.valueOf(sumPrice) ;
//
//        Assert.assertTrue(totalPrice.getText().contains(sumText));
//        if (totalPrice.getText().contains(sumText)){
//            System.out.println("Fiyat toplami dogru");
//        }

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















    }
    public static List<String> elementToString(List<WebElement> list){
        List<String> textList=new ArrayList<>();

        for (WebElement element:list) {
            textList.add(element.getText());
        }
        return textList;
    }

    public static void stringListKontrol(List<String> list1, List<String> list2){

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))){
                System.out.println(list1.get(i) +  "ürün sepette var");
            }
            //Assert.assertEquals("bilgiler eşleşmedi",list1.get(i),list2.get(i));
        }
    }

    public static double stringToDouble(String text){

        String rakamText=text.replaceAll("[[^0-9,.]]","");
        return  Double.parseDouble(rakamText);
    }

}
