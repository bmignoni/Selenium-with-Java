package org.testerbarbara.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test004_MercadoLibre {

    public static void main (String[] args){
        WebDriver driver;
        String baseUrl = "https://www.mercadolibre.com.ar/";
        String actualResult = "";
        String expectedResult = "Mercado Libre Argentina";
        String actualResult2 = "";
        String expectedResult2 = "Disponible en 3 días después de tu compra";

        // Aca le decimos donde esta nuestro Chrome Driver
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        // Aca le decimos que tiene que abrir nuestro Chrome Driver desde donde esta guardado
        System.setProperty("webdriver.chrome.driver",chromePath);

        // Se crea un objeto driver para luego poder extraer los datos de la pagina web, como el titulo, xpath, cssSelector, etc.
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Con nuestro objeto driver le decimos que vaya a la direccion que esta guardada en la variable baseUrl
        driver.get(baseUrl);

        // Con este codigo se maximiza la ventana del navegador
        driver.manage().window().maximize();

        // Guardamos la informacion en nuestra variable actualResult
        actualResult = driver.getTitle();

        // Comparamos el contenido de nuestro actualResult y expectedResult
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada! " + actualResult : "Prueba Fallada!");

        // Con nuestro objeto driver buscamos un elemento xpath y enviamos texto para que se escriba en el input
        driver.findElement(By.xpath("/html/body/header/div/form/input")).sendKeys("Puesto de Feria");

        // clic en el boton buscar
        driver.findElement(By.xpath("/html/body/header/div/form/input")).sendKeys(Keys.RETURN);

        // Buscamos un archivo por xpath y hacemos clic
        WebElement Element = driver.findElement(By.linkText("Puesto De Feria 2x1x1 Facil De Tranportar."));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();

        actualResult2 = driver.findElement(By.cssSelector("#productInfo>div.stock-information--deferred>p")).getText();
        System.out.println(actualResult2.contentEquals(expectedResult2)?"Prueba Pasada! " + actualResult2 : "Prueba Fallada!");



        driver.close();

    }

}
