package org.testerbarbara.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test009_ImplicitWait {

    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args) {

        System.setProperty("webdriver.crhome.driver", chromePath);
        driver = new ChromeDriver();
        String baseUrl = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait waitVar = new WebDriverWait(driver, 10);

        try {
            driver.switchTo().frame("iframeResult");

            WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
            btnTry.click();
            Thread.sleep(2000);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alrtWindows = driver.switchTo().alert();
            String alertText = alrtWindows.getText();
            System.out.println(alertText);
            alrtWindows.sendKeys("Gilberto S");
            alrtWindows.accept();

            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Gilberto")?finalText: "Prueba Fallida!");

        } catch (NoSuchElementException ne) {
            System.err.println("No se encontró el WebElements" + ne.getMessage());

        } catch (NoSuchFrameException nf) {
            System.err.println("No se encontró el Frame" + nf.getMessage());

        } catch (NoAlertPresentException na) {
            System.err.println("No se encontró la alerta" + na.getMessage());

        } catch (TimeoutException te) {
            System.err.println("Tiempo de espera Excedido: " + te.getMessage());

        } catch (WebDriverException we){
            System.err.println("WebDriver falló" + we.getMessage());

        } catch (Exception ex){
            System.err.println(ex.getMessage());

        } finally {
            driver.quit();
        }

    }
}

