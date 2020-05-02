package org.testerbarbara.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By lnkRegster = By.linkText("REGISTER");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void cliclkRegisterLink(){
        driver.findElement(lnkRegster);
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }
}
