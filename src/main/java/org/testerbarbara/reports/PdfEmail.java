package org.testerbarbara.reports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (JyperionListener.class)
public class PdfEmail extends BaseClass{
    WebDriver driver = getDriver();

    @Test (enabled = false)
    public void testOne(){
        driver.get("https://www.google.com.ar");
        Assert.assertTrue(true);
    }

    @Test (enabled = false)
    public void testTwo(){
        driver.get("https://www.facebook.com/");
        Assert.assertTrue(true);
    }

    @Test
    public void testThree(){
        driver.get("https://titaniumsolutions.org/");
        Assert.assertTrue(false);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @AfterSuite
    public void sendEmail(){
        sendPdfReportByEmail("barbara.mignoni@gmail.com", "zahia0501", "amine.metidji@gmail.com", "Barbara PDF Report", "Please Find Attached the pdf report");
        //sendPdfReportByEmail("titaniumsoltest@gmail.com", "Test619", "titaniumsoltest@gmail.com", "Barbara PDF Report", "Please Find Attached the pdf report");
    }

}
