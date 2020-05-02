package org.testerbarbara.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Test017_RealTimeReport.class)
public class Test018_TestRealTimeReport {
    @Test
    public void testOne(){
        Assert.assertTrue(true);
    }

    @Test
    public void testTwo(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "testTwo")
    public void testThree(){
        Assert.assertTrue(true);
    }
}
