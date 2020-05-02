package org.testerbarbara.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test013_DataProvider {
    WebDriver driver;

    @DataProvider(name = "SearchProvider")

    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Fernando", "Google"},
                {"Luis", "Yahoo"},
                {"Sara", "Gmail"},
                {"Lorena", "Amazon"},
        };
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = Test013_DataProvider.class)
    public void testMethod(String tester, String search) throws InterruptedException {

        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(search);
        System.out.println("Welcome -> " + tester + " your search word is -> " + search);
        Thread.sleep(3000);

        // para poder obtener el texto de un inputbox hay que utilizar el Artibuto "Value".
        String testValue = searchText.getAttribute("value");
        System.out.println("Test value is " + testValue + " and is equals to " + search);
        searchText.clear();
        // Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equals(search));
    }
}