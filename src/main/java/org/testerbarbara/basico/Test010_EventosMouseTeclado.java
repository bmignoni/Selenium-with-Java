package org.testerbarbara.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Test010_EventosMouseTeclado {

    static WebDriver driver;

    public static void main(String[] args){
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseUrl = "https://www.facebook.com/";

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        try {
            WebElement txtUser = driver.findElement(By.id("email"));
            Actions builder = new Actions(driver);

            Action seriesOfActions = builder
                    .moveToElement(txtUser)
                    .click()
                    .keyDown(Keys.SHIFT)
                    .sendKeys("hello")
                    .keyUp(Keys.SHIFT)
                    .doubleClick()
                    .contextClick(txtUser)
                    .build();

            seriesOfActions.perform();
            Thread.sleep(2000);
            System.out.println("Test Passed!");

        } catch (NoSuchElementException ne) {
            System.err.println("Test Falled!: element was not found");

        } catch (Exception e) {
            System.err.println("Test Falled!: " + e.getMessage());

        } finally {
            driver.close();

        }
    }
}
