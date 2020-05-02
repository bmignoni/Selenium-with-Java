package org.testerbarbara.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class Test008_Forms {
    static WebDriver driver;

    public static void main(String[] args) {
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        String baseUrl = "http://newtours.demoaut.com";
        System.setProperty("webdriver.crhome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
            // Aqui va a completar un formulario, da clic en submit y luego se verifica el correo de la cuenta creada
        try {
            driver.findElement(By.linkText("REGISTER")).click();
            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            txtFirstName.sendKeys("Gil");
            Thread.sleep(1500);
            txtFirstName.clear();
            Thread.sleep(1500);
            txtFirstName.sendKeys("Gilberto");
            driver.findElement(By.name("address1")).sendKeys("Test Address");

            // Aqui debajo muestra como se utiliza una lista desplegable, en este caso por texto, quiero por value debo poner en el numero
            // y si es por index comienza desde 0 a contar
            Select drpCountry = new Select(driver.findElement(By.name("country")));
            Thread.sleep(1500);
            drpCountry.selectByVisibleText("MEXICO");

            driver.findElement(By.id("email")).sendKeys("gilberto@mail.com");
            driver.findElement(By.name("password")).sendKeys("123");
            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            txtConfirmPass.sendKeys("123");
            txtConfirmPass.submit();

            System.out.println("Prueba Exitosa! " + driver.findElement(By.xpath("//*[contains(text(), \"Note\")]")).getText());

        } catch (NoSuchElementException ne) {
            System.err.println("No se encontró el WebElements" + ne.getMessage());

        } catch (WebDriverException we){
            System.err.println("WebDriver falló" + we.getMessage());

        } catch (Exception ex){
            System.err.println(ex.getMessage());

        } finally {
            driver.quit();
        }

    }
}
