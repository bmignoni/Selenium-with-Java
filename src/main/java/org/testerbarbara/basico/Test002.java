package org.testerbarbara.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test002 {
    public static void main (String [] args){
        WebDriver driver;
        String baseUrl = "http://live.demoguru99.com/index.php/checkout/cart/";
        String actualResult= "";
        String expectedResult = "$614.00";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        // Clic en link TV
        driver.findElement(By.linkText("TV")).click();

        // Clic en boton ADD TO CART
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();

        // Obtener el precio del objeto
        actualResult = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span")).getText();

        if(actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba Pasada! el resultado actual es: " + actualResult + " es igual a " + expectedResult);
        }else{
            System.out.println("Prueba Fallada! el resultado actual es: " + actualResult + " no es igual a " + expectedResult);
        }

        driver.close();

    }

}
