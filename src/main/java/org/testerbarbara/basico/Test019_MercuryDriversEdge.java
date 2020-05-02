package org.testerbarbara.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// este test paso con exito
public class Test019_MercuryDriversEdge {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\MicrosoftWebDriver.exe");

        driver = new EdgeDriver();
        driver.get(baseURL);
        driver.getTitle();
        actualResult = driver.getTitle();

        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada!" + actualResult : "Prueba Fallada!");

        driver.close();

    }
}


