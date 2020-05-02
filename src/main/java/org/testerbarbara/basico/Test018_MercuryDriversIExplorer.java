package org.testerbarbara.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

// este test paso con exito
public class Test018_MercuryDriversIExplorer {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");

        driver = new InternetExplorerDriver();
        driver.get(baseURL);
        driver.getTitle();
        actualResult = driver.getTitle();

        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada!" + actualResult : "Prueba Fallada!");

        driver.close();

    }
}


