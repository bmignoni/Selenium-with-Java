package org.testerbarbara.pom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testerbarbara.pom.pages.HomePage;
import org.testerbarbara.pom.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterUserTest {
    WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    HomePage objHome;
    RegisterPage objRegister;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @Test (priority = 0)
    public void goToRegisterPage(){
        objHome = new HomePage(driver);
        objHome.cliclkRegisterLink();

        expectedResult = "Register: Mercury Tours";
        actualResult = objHome.getHomePageTitle();
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test (priority = 1)
    public void registerAnUser(){
        objRegister = new RegisterPage(driver);

        objRegister.setFirstName("Barbara");
        objRegister.selectCountry("AUSTRIA");
        objRegister.submitUserInformation("barbara.mignoni@gmial.com", "zahia0501");


        // ver aqui para que sirve la linea de abajo porque en el video no la mostro completa y se salto al otro video.
        //"//*[contains(text(), \"Note\")]"   intentar poner esto en el txtsucces con la extension .gettext (ver Test008)
        WebElement textSucces = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]"));
        System.out.println("Test passed! : " + textSucces);
    }



}
