package com.browserstack;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;

public class LocalTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        //driver.get("http://localhost:45454");
        driver.get("http://localhost:45691");
        //driver.get("http://localhost/bs_test/callback.php");
        //driver.get("http://localhost:8000/");
        //Assert.assertTrue(driver.getTitle().contains("Demo Site"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        /*if(driver.findElement(By.xpath("/html/body")).getText().equals("This is an internal server for BrowserStack Local"))
           jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Validated\"}}");
       else
           jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Not Validated\"}}");*/
    }
}
