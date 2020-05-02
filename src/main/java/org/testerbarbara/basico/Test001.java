package org.testerbarbara.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test001 {
    public static void main(String[] args){
        /////// Instanciar un objeto webdriver
        WebDriver driver;

        /////// Declarar Variables
        String baseURL = "//http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        /////// Indicar la localizacion del archivo chromedriver.exe en la propiedad webdriver.chrome.driver
        /////// System.getProperty("user.dir") = C:\..\..\..\SeleniumBasic --- aca le indica donde esta mi proyecto.
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        /////// Abrir el navegador Chrome
        driver = new ChromeDriver();

        /////// Navegar a la Pagina
        driver.get(baseURL);

        /////// Obtener el Título de mi Pagina Web
        actualResult = driver.getTitle();

        /////// Imprimir el resultado usando el operador terniario, que simula ser un IF-ELSE.
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada!" + actualResult : "Prueba Fallada!");
        //System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada!" + actualResult : "Prueba Fallada!");


        driver.close();






    }
}
