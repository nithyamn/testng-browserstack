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
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"org.openqa.selenium.TimeoutException: Expected condition failed: waiting for title to be Hotel Search Results. Current title: (tried for 45 second(s) with 500 milliseconds interval) Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11\"}}");


        /*if(title.equals("BrowserStack - Google Search")) {
            TestStatus.mark(session, "passed", username, accesskey);
        }
        else{
            TestStatus.mark(session,"failed", username, accesskey);
            Assert.assertEquals("BrowserStack - Google Search", driver.getTitle());
        }*/
    }
}
