package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        String username = BrowserStackTestNGTest.username;
        String accesskey = BrowserStackTestNGTest.accessKey;

        
        driver.get("https://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
        
        String title = driver.getTitle();
        SessionId session = ((RemoteWebDriver) driver).getSessionId();
        System.out.println(session);
        
        JavascriptExecutor jse = (JavascriptExecutor)driver;
       

        if(title.contains("BrowserStack")) {
            //TestStatus.mark(session, "passed", username, accesskey);
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title Validated\"}}");

        }
        else{
            //TestStatus.mark(session,"failed", username, accesskey);
            //Assert.assertEquals("BrowserStack - Google Search", driver.getTitle());
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Title Not Validated\"}}");

        }
    }
}
