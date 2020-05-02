package org.testerbarbara.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/// esta clase es para que falle y nos muestre donde fallo con un NoSuchElementException
public class Test006_WebDriverExceptions {

    static WebDriver driver;
    public static void main (String [] args){

        try {

            String baseUrl = "http://live.demoguru99.com/index.php/checkout/cart/";
            String actualResult = "";
            String expectedResult = "$615.00";
            String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();

            // Clic en link TV
            WebElement lnkTV = driver.findElement(By.linkText("TV"));
            lnkTV.click();

            // Clic en boton ADD TO CART /  esta es la ruta correcta: //*[@id="top"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span
            WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
            btnAddToCart.click();

            // Obtener el precio del objeto
            WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
            actualResult = lblSubtotal.getText();

            if (actualResult.contentEquals(expectedResult)) {
                System.out.println("Prueba Pasada! el resultado actual es: " + actualResult + " es igual a " + expectedResult);
            } else {
                System.out.println("Prueba Fallada! el resultado actual es: " + actualResult + " no es igual a " + expectedResult);
            }

            // Aca nos saltara un error si no encuentra algun objeto. "ne" es el nombre de mi variable "no existe".
        }catch (NoSuchElementException ne) {
            System.err.println("No se encontro el WebElement: " + ne.getMessage());
        }catch (WebDriverException we) {
            System.err.println("WebDriver " + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.close();
        }
    }
}
