package org.testerbarbara.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


// este test paso con exito
public class Test017_MercuryDriversFirefox {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get(baseURL);
        driver.getTitle();
        actualResult = driver.getTitle();

        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada!" + actualResult : "Prueba Fallada!");

        driver.close();

    }
}


