package org.testerbarbara.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test005_MlLlegaHoy {

    public static void main(String[] args) {
        WebDriver driver;

        String baseUrl = "https://www.mercadolibre.com.ar/";
        String actualResult = "";
        String expectedResult = "2 resultados";

        String chromePath = System.getProperty("User.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.driver.chrome", chromePath);

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/header/div/form/input")).sendKeys("Puesto de Feria");
        driver.findElement(By.xpath("/html/body/header/div/form/input")).clear();
        driver.findElement(By.xpath("/html/body/header/div/form/input")).sendKeys("Puesto de Feria");
        driver.findElement(By.cssSelector("body>header>div>form>button")).click();
        driver.findElement(By.cssSelector("#search-results-disclaimers>section>div>a>span")).click();
        actualResult = driver.findElement(By.cssSelector("#inner-main>aside>div.quantity-results")).getText();

        System.out.println(actualResult.contentEquals(expectedResult) ? "Prueba Pasada" + actualResult : "Prueba Fallada, el texto es: " + actualResult);

        if (actualResult.contentEquals(expectedResult)) {
            System.out.println("La Prueba paso con exito. El resultado actual es: " + actualResult + ". Igual que el resultado esperado.");
        } else {
            EventFiringWebDriver screen = new EventFiringWebDriver(driver);
            File myscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(myscreenshot, new File("Cantidad de Resultados" + System.currentTimeMillis() + ".png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("La captura de pantalla se guardo en: C:\\Users\\amine\\IdeaProjects\\SeleniumBasic");
        }

        driver.close();
    }
}

